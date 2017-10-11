package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;

public class SpeakersCreator implements CreateCommand {
	@Override
	public Appliance create(HashMap<String,String> criteriaMap) {
		Speakers speakers = new Speakers();
		speakers.setPowerConsumption(Integer.valueOf(criteriaMap.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())));
		speakers.setNumberOfSpeakers(Integer.valueOf(criteriaMap.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())));
		speakers.setFrequencyRange(criteriaMap.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString()));
		speakers.setCordLength(Double.valueOf(criteriaMap.get(SearchCriteria.Speakers.CORD_LENGTH.toString())));
		return speakers;
	}
}
