package by.tc.task02.main;

import by.tc.task02.entity.ComplexTag;
import by.tc.task02.entity.Tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagInfoPrinter {
	public static void print(ComplexTag root) {
		print(root, " ");
	}

	private static void print(ComplexTag tag, String space) {
		System.out.println(space + "name:" + tag.getName());
		printAttributes(space, tag);
		System.out.println(space + "nodes:");
		printNodes(tag, space);
	}

	private static void printNodes(Tag element, String space) {
		List<Tag> tags = ((ComplexTag)element).getContentTags();
		if (!tags.isEmpty()) {
			for (Tag tag : tags) {
				if (tag instanceof ComplexTag) {
					printComplexTag(space, (ComplexTag) tag);
				} else {
					System.out.println(space + "      " + tag.getContent());
				}
			}
		}
	}

	private static void printComplexTag(String space, ComplexTag tag) {
		String largeSpace = space + "      ";
		print(tag, largeSpace);
	}

	private static void printAttributes(String space, ComplexTag tag) {
		if (!(tag.getAttributes()).isEmpty()) {
			System.out.println(space + "attributes:");
			printAttributes(tag, space);
		}
	}

	private static void printAttributes(ComplexTag tag, String space) {
		HashMap<String,String> attributes = tag.getAttributes();
		for (Map.Entry<String,String> attribute : attributes.entrySet()) {
			System.out.println(space + "   " +
					attribute.getKey()
					+ "=\""
					+ attribute.getValue() + "\"");
		}
	}
}

