package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.creator.ApplianceCreator;
import by.tc.task01.dao.creator.CreateCommand;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO{

	private final static String APPLIANCES_DATABASE_PATH = "src\\main\\resources\\appliances_db.txt";
	private ApplianceCreator applianceCreator = new ApplianceCreator();

	@Override
	public <E> Appliance find(Criteria<E> criteria) {
		Appliance appliance = null;
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(APPLIANCES_DATABASE_PATH))) {
			/** This line contains information about a particular device from the database */
			String applianceReadLine;
			while ((applianceReadLine = bufferedReader.readLine()) != null) {
				if (applianceReadLine.isEmpty()) {
					continue;
				}
				if (isSuitableApplianceType(applianceReadLine,criteria)) {
					HashMap<String,String> applianceCriteriaMap;
					applianceCriteriaMap = createApplianceCriteriaMap(applianceReadLine);
					if (isApplianceMeetCriteria(applianceCriteriaMap,criteria)) {
						String applianceType = criteria.getParamClassName();
						appliance = createAppliance(applianceType,applianceCriteriaMap);
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appliance;
	}

	private <E> boolean isSuitableApplianceType(String applianceInfoLine,Criteria<E> criteria) {
		String applianceType = applianceInfoLine.substring(0,applianceInfoLine.indexOf(" "));
		return applianceType.equals(criteria.getParamClassName());
	}

	/**
	 * Here information about the appliance from the database is placed in the Map
	 * @param applianceReadLine is information about the appliance read from the database
	 * @return  appliance parameters with their values as a HashMap.
	 */
	private HashMap<String,String> createApplianceCriteriaMap(String applianceReadLine) {
		HashMap<String,String> applianceCriteriaMap = new HashMap<>();
		String[] applianceParameters = applianceReadLine.split("[:;\\s,=]+");
		for (int i = 1;i<applianceParameters.length-1;i = i + 2) {
			applianceCriteriaMap.put(applianceParameters[i],applianceParameters[i+1]);
		}
		return applianceCriteriaMap;
	}

	/**
	 * checking the compliance of our criteria
	 * and the appliance read from the database
	 */
	private <E> boolean isApplianceMeetCriteria(HashMap<String,String> applianceCriteriaMap, Criteria<E> criteria) {
		boolean isMeet = true;
		List<String> criteriaList = criteria.getListCriteria();
		for (String certainCriterion : criteriaList) {
			String criterionName = certainCriterion.substring(0,certainCriterion.indexOf("="));
			String criterionValue = certainCriterion.substring(certainCriterion.indexOf("=")+1,certainCriterion.length());
			if (!applianceCriteriaMap.get(criterionName).equalsIgnoreCase(criterionValue)) {
				isMeet = false;
			}
		}
		return isMeet;
	}

	/** Create appliance objects using the Command Pattern*/
	private Appliance createAppliance(String applianceType, HashMap<String,String> applianceCriteriaMap) {
		Appliance appliance;
		CreateCommand command = applianceCreator.getCommand(applianceType);
		appliance = command.create(applianceCriteriaMap);
		return appliance;
	}
}