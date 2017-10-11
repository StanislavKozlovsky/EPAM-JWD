package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;

public class RefrigeratorCreator implements CreateCommand {
	@Override
	public Appliance create(HashMap<String,String> criteriaMap) {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.setPowerConsumption(Integer.valueOf(criteriaMap.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())));
		refrigerator.setWeight(Double.valueOf(criteriaMap.get(SearchCriteria.Refrigerator.WEIGHT.toString())));
		refrigerator.setFreezerCapacity(Integer.valueOf(criteriaMap.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())));
		refrigerator.setOverallCapacity(Double.valueOf(criteriaMap.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())));
		refrigerator.setHeight(Double.valueOf(criteriaMap.get(SearchCriteria.Refrigerator.HEIGHT.toString())));
		refrigerator.setWidth(Double.valueOf(criteriaMap.get(SearchCriteria.Refrigerator.HEIGHT.toString())));
		return refrigerator;
	}
}
