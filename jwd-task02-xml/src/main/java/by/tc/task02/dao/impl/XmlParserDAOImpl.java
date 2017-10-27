package by.tc.task02.dao.impl;

import by.tc.task02.dao.XmlParserDAO;
import by.tc.task02.dao.XmlFileReader;
import by.tc.task02.dao.exeption.DAOLayerException;
import by.tc.task02.entity.ComplexTag;
import by.tc.task02.entity.Tag;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParserDAOImpl implements XmlParserDAO {
	private static final Pattern OPEN_TAG = Pattern.compile("[<]([A-z0-9]+)([ ]*[A-z0-9='\"]*)[>]");
	private static final Pattern CLOSE_TAG = Pattern.compile("[<][/]([A-z0-9]+)[>]");
	private static int TAG_NAME_GROUP = 1;
	private static int ATTRIBUTES_GROUP = 2;
	private static final String FILE_NAME = "task02.xml";
	private XmlFileReader xmlFileReader = new XmlFileReader(FILE_NAME);
	private Tag root;
	private static Stack<String> lexemesStack = new Stack<>();
	private static Stack<Tag> simpleTagStack = new Stack<>();
	private static Stack<Tag> complexTagStack = new Stack<>();


	public Tag parse() throws DAOLayerException{
		ArrayList<String> xmlFileContentLexemes = xmlFileReader.readXmlFileContent();
		for (String lexeme: xmlFileContentLexemes) {
			if(isCloseTag(lexeme)) {
				String tagContent;
				String fullOpenTag;
				String tagName;
				Tag tag;
				String topStackLexeme = lexemesStack.pop();
				if(isOpenTag(topStackLexeme)){
					tagContent = "";
					fullOpenTag = topStackLexeme;
					tagName = getTagName(fullOpenTag);
					tag = new ComplexTag(tagName, tagContent);
					/** Content text*/
				} else {
					tagContent = topStackLexeme;
					fullOpenTag = lexemesStack.pop();
					tagName = getTagName(fullOpenTag);
					tag = new Tag(tagName,tagContent);
				}
				String attributesLine = getAttributesGroup(fullOpenTag);
				if(!attributesLine.isEmpty()){
					String[] attributes = attributesLine.split(" ");

					for(int i = 0;i < attributes.length;i++) {
						String[] attributeWithValue = attributes[i].split("=");

						tag.addAttribute(attributeWithValue[0],attributeWithValue[1]);
					}
				}
				if(tag instanceof ComplexTag) {
					/**form a complex tag that contains all the simple tags */
					if(!simpleTagStack.isEmpty()){
						while (!simpleTagStack.isEmpty()){
							((ComplexTag) tag).addTag(simpleTagStack.pop());
						}
						complexTagStack.push(tag);
					} else {
						/**If the stack of simple tags is empty, then this means that this tag is complex and frames the other*/
						while (!complexTagStack.isEmpty()){
							((ComplexTag) tag).addTag(complexTagStack.pop());
						}
						complexTagStack.push(tag);
					}
					/**If tag is simple*/
				} else {
					simpleTagStack.push(tag);
				}
				/**if lexeme is open tag or content text*/
			} else {
				lexemesStack.push(lexeme);
			}
		}
		root = complexTagStack.pop();
		return root;
	}

	private boolean isCloseTag(String lexeme) {
		return CLOSE_TAG.matcher(lexeme).find();
	}

	private boolean isOpenTag(String lexeme) {
		return OPEN_TAG.matcher(lexeme).find();
	}

	private String getTagName(String openTag) {
		Matcher m = OPEN_TAG.matcher(openTag);
		m.matches();
		return m.group(TAG_NAME_GROUP);
	}
	private String getAttributesGroup(String openTag) {
		Matcher m = OPEN_TAG.matcher(openTag);
		m.matches();
		return m.group(ATTRIBUTES_GROUP).trim();
	}
}
