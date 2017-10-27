package by.tc.task02.main;

import by.tc.task02.entity.ComplexTag;
import by.tc.task02.entity.Tag;
import by.tc.task02.service.XmlParserService;
import by.tc.task02.service.ServiceFactory;
import by.tc.task02.service.exeption.ServiceLayerException;

public class Main {
	public static void main(String...args) throws ServiceLayerException {
		try {
			Tag root;
			ServiceFactory factory = ServiceFactory.getInstance();
			XmlParserService parseService = factory.getXmlParserService();

			root = parseService.parse();
			TagInfoPrinter.print((ComplexTag) root);
		} catch (ServiceLayerException e) {
			throw new ServiceLayerException(e);
		}
	}
}
