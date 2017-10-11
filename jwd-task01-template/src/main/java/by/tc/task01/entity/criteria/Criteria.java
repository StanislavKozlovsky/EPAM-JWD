package by.tc.task01.entity.criteria;

import java.util.*;

public class Criteria<E> {

	private Map<E, Object> criteria = new HashMap<E, Object>();

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	/**
	 * @return	the contents of the criteria HashMap in the form "Key=Value" as List
	 */
	public List<String> getListCriteria() {
		List<String> list = new ArrayList<>();
		for (Map.Entry<E, Object> entry : criteria.entrySet()) {
			list.add(entry.getKey() + "=" + entry.getValue());
		}
		return list;
	}

	/**
	 *
	 * @return E type as a string  OR null if criteria Map is empty
	 */
	public String getParamClassName() {
		for (E e : criteria.keySet()) {
			String classParamSimpleName = e.getClass().getSimpleName();
			return classParamSimpleName;
		}
		return null;
	}

}
