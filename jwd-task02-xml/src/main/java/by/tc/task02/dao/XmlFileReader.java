package by.tc.task02.dao;

import by.tc.task02.dao.exeption.DAOLayerException;
import by.tc.task02.dao.constants.TagConstants;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * This class read and returns the contents of the XMLfile as Array of Lexemes
 * EXCLUDING :
 * declaration line (Example : <?xml version...?>)
 * and comments (Example :  <!--catalog last updated 2000-11-01-->)
*/
public class XmlFileReader {
	private String xmlFileName;
	private static ArrayList<String> tokensList = new ArrayList<>();

	public XmlFileReader() {}

	public XmlFileReader(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	public String getXmlFileName() {
		return xmlFileName;
	}

	public ArrayList<String> readXmlFileContent() throws DAOLayerException {

		try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/"+getXmlFileName()))) {
			String tagContentBuffer = "";
			while (reader.ready()) {
				String xmlLine = (reader.readLine()).trim();

				if (isDeclarationOrCommentLine(xmlLine))
					continue;
				if(isContainsAnOpenTag(xmlLine)) {
					addOpenTag(xmlLine);
					if(isContainsCloseTag(xmlLine)) {
						addContentBetweenTwoTags(xmlLine);
						addCloseTag(xmlLine);
					} else {
						/**
						 * here the problem of a situation when the line does not end with the closing tag.
						 * This means that the text will continue in the next line.
						 * tagContentBuffer is solve this problem
						 */
						String lineContent = xmlLine.substring(xmlLine.indexOf(TagConstants.LAST_BRACKET)+
								TagConstants.INCLUDING_LAST_BRACKET, xmlLine.length());
						if(!lineContent.isEmpty()) {
							tagContentBuffer += TagConstants.SPACE_LINKER_LINES + lineContent;
						}
					}
				} else if(isContainsCloseTag(xmlLine)) {
					String lineContent = xmlLine.substring(TagConstants.BEGIN_OF_LINE,xmlLine.indexOf(TagConstants.CLOSE_BRACKET));
					if(!lineContent.isEmpty()) {
						tagContentBuffer += TagConstants.SPACE_LINKER_LINES + lineContent;
						addContent(tagContentBuffer);
						tagContentBuffer = "";
					}
					addCloseTag(xmlLine);

				} else {
					tagContentBuffer += xmlLine;
				}
			}
			return tokensList;

		} catch (UnsupportedEncodingException e) {
			throw new DAOLayerException(e);
		} catch (FileNotFoundException e) {
			throw new DAOLayerException("File not found!",e);
		} catch (IOException e) {
			throw new DAOLayerException(e);
		}
	}

	private boolean isDeclarationOrCommentLine(String xmlLine) {
		return ((patternMatch(TagConstants.XML_DECLARATION,xmlLine) ||
				patternMatch(TagConstants.COMMENT_TAG,xmlLine)));
	}

	private boolean isContainsAnOpenTag(String xmlLine) {
		return patternMatch(TagConstants.OPEN_TAG,xmlLine);
	}

	private boolean isContainsCloseTag(String xmlLine) {
		return patternMatch(TagConstants.CLOSE_TAG,xmlLine);
	}

	private void addOpenTag(String xmlLine) {
		tokensList.add(xmlLine.substring(TagConstants.BEGIN_OF_LINE,
				xmlLine.indexOf(TagConstants.LAST_BRACKET)+TagConstants.INCLUDING_LAST_BRACKET));
	}

	private void addCloseTag(String xmlLine) {
		tokensList.add(xmlLine.substring(xmlLine.indexOf(TagConstants.CLOSE_BRACKET),xmlLine.length()));
	}

	private void addContentBetweenTwoTags(String xmlLine) {
		tokensList.add(xmlLine.substring(xmlLine.indexOf(TagConstants.LAST_BRACKET)+
				TagConstants.INCLUDING_LAST_BRACKET,
				xmlLine.indexOf(TagConstants.CLOSE_BRACKET,xmlLine.indexOf(TagConstants.LAST_BRACKET)+
						TagConstants.INCLUDING_LAST_BRACKET)));
	}

	private void addContent(String tagContentBuffer) {
		tokensList.add(tagContentBuffer);
	}

	private boolean patternMatch(Pattern pattern, String xmlLine) {
		return pattern.matcher(xmlLine).find();
	}
}
