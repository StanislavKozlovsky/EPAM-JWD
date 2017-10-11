package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;

import java.util.HashMap;

public interface CreateCommand {
	Appliance create(HashMap<String,String> criteriaMap);
}
