package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

public class Validator {

	private final static String stringTypeSearchCriteria = "OS, FILTER_TYPE, BAG_TYPE, WAND_TYPE, COLOR, FREQUENCY_RANGE";

	/**
	 * Cases of failed validation:
	 * 1.userCriteriaList is empty
	 * 2.NumberFormatException during parsing for the values of the criteria, except those whose values can be a string
	 */
	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
		List<String> userCriteriaList = criteria.getListCriteria();
		if (userCriteriaList.isEmpty()) {
			return false;
		}

		for (String certainCriterion: userCriteriaList) {
			String searchCriterion = certainCriterion.substring(0,certainCriterion.indexOf("="));
			if(!stringTypeSearchCriteria.contains(searchCriterion)) {
				String value = certainCriterion.substring(certainCriterion.indexOf("=")+1,certainCriterion.length());
				try {
					Double d = Double.parseDouble(value);
				}catch (NumberFormatException e) {
					return false;
				}
			}
		}
		return true;
	}

}