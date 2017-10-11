package by.tc.task01.dao.creator;

import java.util.HashMap;
import java.util.Map;

public class ApplianceCreator {
	Map<String, CreateCommand> map = new HashMap<>();

	public ApplianceCreator(){
		map.put("Oven", new OvenCreator());
		map.put("Laptop", new LaptopCreator());
		map.put("Refrigerator", new RefrigeratorCreator());
		map.put("Speakers", new SpeakersCreator());
		map.put("TabletPC", new TabletPCCreator());
		map.put("VacuumCleaner", new VacuumCleanerCreator());
	}

	public CreateCommand getCommand(String typeName) {
		CreateCommand command;
		command = map.get(typeName);
		return command;
	}
}
