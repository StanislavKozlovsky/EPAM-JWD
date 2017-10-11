package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;

public class OvenCreator implements CreateCommand {
	@Override
	public Appliance create(HashMap<String,String> criteriaMap) {
		Oven oven = new Oven();
		oven.setPowerConsumption(Integer.valueOf(criteriaMap.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString())));
		oven.setWeight(Double.valueOf(criteriaMap.get(SearchCriteria.Oven.WEIGHT.toString())));
		oven.setCapacity(Integer.valueOf(criteriaMap.get(SearchCriteria.Oven.CAPACITY.toString())));
		oven.setDepth(Double.valueOf(criteriaMap.get(SearchCriteria.Oven.DEPTH.toString())));
		oven.setHeight(Double.valueOf(criteriaMap.get(SearchCriteria.Oven.HEIGHT.toString())));
		oven.setWidth(Double.valueOf(criteriaMap.get(SearchCriteria.Oven.WIDTH.toString())));
		return oven;
	}
}
