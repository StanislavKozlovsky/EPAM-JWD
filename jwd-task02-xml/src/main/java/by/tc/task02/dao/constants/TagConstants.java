package by.tc.task02.dao.constants;

import java.util.regex.Pattern;

public final class TagConstants {

	public final static String SPACE_LINKER_LINES = " ";
	public final static String CLOSE_BRACKET = "</";
	public final static String LAST_BRACKET = ">";
	public final static String ENCODING = "UTF-8";
	public final static int BEGIN_OF_LINE = 0;
	public final static int INCLUDING_LAST_BRACKET = 1;
	public final static Pattern XML_DECLARATION = Pattern.compile("(<\\?.*\\?>)");
	public final static Pattern COMMENT_TAG = Pattern.compile("(<!--.*-->)");
	public final static Pattern OPEN_TAG = Pattern.compile("[<]([A-z0-9-]+)([ A-z0-9='\"]*)[>]");
	public final static Pattern CLOSE_TAG = Pattern.compile("([<][/]([A-z0-9]+)[>])");

	private TagConstants(){}

}
