package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;

public class VacuumCleanerCreator implements CreateCommand {
	@Override
	public Appliance create(HashMap<String,String> criteriaMap) {
		VacuumCleaner vacuumCleaner = new VacuumCleaner();
		vacuumCleaner.setPowerConsumption(Integer.valueOf(criteriaMap.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())));
		vacuumCleaner.setFilterType(criteriaMap.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString()));
		vacuumCleaner.setBagType(criteriaMap.get(SearchCriteria.VacuumCleaner.BAG_TYPE.toString()));
		vacuumCleaner.setWandType(criteriaMap.get(SearchCriteria.VacuumCleaner.WAND_TYPE.toString()));
		vacuumCleaner.setMotorSpeedRegulation(Integer.valueOf(criteriaMap.get
											 (SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())));
		vacuumCleaner.setCleaningWidth(Double.valueOf(criteriaMap.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())));
		return vacuumCleaner;
	}
}
