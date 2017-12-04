package com.livecicd.responseDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.livecicd.attributes.Currently;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
	private Currently currently;

	public WeatherResponse() {
	}

	public Currently getCurrently() {
		return currently;
	}

	public void setCurrently(Currently currently) {
		this.currently = currently;
	}
}