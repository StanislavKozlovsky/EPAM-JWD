package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;

public class TabletPCCreator implements CreateCommand {
	@Override
	public Appliance create(HashMap<String,String> criteriaMap) {
		TabletPC tabletPC = new TabletPC();
		tabletPC.setBatteryCapacity(Integer.valueOf(criteriaMap.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())));
		tabletPC.setDisplayInches(Double.valueOf(criteriaMap.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString())));
		tabletPC.setMemoryRom(Integer.valueOf(criteriaMap.get(SearchCriteria.TabletPC.MEMORY_ROM.toString())));
		tabletPC.setFlashMemoryCapacity(Integer.valueOf(criteriaMap.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())));
		tabletPC.setColor(criteriaMap.get(SearchCriteria.TabletPC.COLOR.toString()));
		return tabletPC;
	}
}
