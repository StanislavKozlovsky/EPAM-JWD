package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;

public class LaptopCreator implements CreateCommand {
	@Override
	public Appliance create(HashMap<String,String> criteriaMap) {
		Laptop laptop = new Laptop();
		laptop.setBatteryCapacity(Double.valueOf(criteriaMap.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString())));
		laptop.setOs(criteriaMap.get(SearchCriteria.Laptop.OS.toString()));
		laptop.setMemoryRom(Integer.valueOf(criteriaMap.get(SearchCriteria.Laptop.MEMORY_ROM.toString())));
		laptop.setSystemMemory(Integer.valueOf(criteriaMap.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString())));
		laptop.setCpu(Double.valueOf(criteriaMap.get(SearchCriteria.Laptop.CPU.toString())));
		laptop.setDisplayInchs(Integer.valueOf(criteriaMap.get(SearchCriteria.Laptop.DISPLAY_INCHS.toString())));
		return laptop;
	}
}
