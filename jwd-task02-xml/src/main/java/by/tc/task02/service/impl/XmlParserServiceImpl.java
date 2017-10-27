package by.tc.task02.service.impl;

import by.tc.task02.dao.DAOFactory;
import by.tc.task02.dao.XmlParserDAO;
import by.tc.task02.dao.exeption.DAOLayerException;
import by.tc.task02.entity.Tag;
import by.tc.task02.service.XmlParserService;
import by.tc.task02.service.exeption.ServiceLayerException;

public class XmlParserServiceImpl implements XmlParserService {

	public Tag parse() throws ServiceLayerException{
		try {
			DAOFactory factory = DAOFactory.getInstance();
			XmlParserDAO parserDAO = factory.getParserDAO();

			Tag tag = parserDAO.parse();

			return tag;
		} catch (DAOLayerException e) {
			throw new ServiceLayerException(e);
		}
	}
}
