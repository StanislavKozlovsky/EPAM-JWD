package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO{

	private final static String PATH = "src\\main\\resources\\appliances_db.txt";

	@Override
	public <E> Appliance find(Criteria<E> criteria) {
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))){

			String fileLine;
			while ((fileLine = bufferedReader.readLine()) != null){
				if(fileLine.isEmpty()){
					continue;
				}

				String applianceName = fileLine.substring(0,fileLine.indexOf(" "));
				if(applianceName.equals(criteria.getParamClassName())){

					boolean containsCriteriaFlag =true;
					List<String> listCriteria = criteria.getListCriteria();
					for(String certainCriterion : listCriteria){
						if(!fileLine.contains(certainCriterion)){
							containsCriteriaFlag = false;
						}
					}

					if(containsCriteriaFlag){
						///////////
					}
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

}