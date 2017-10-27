package by.tc.task02.service;

import by.tc.task02.entity.Tag;
import by.tc.task02.service.exeption.ServiceLayerException;

public interface XmlParserService {
	Tag parse() throws ServiceLayerException;
}
