package com.weatherapp.responseDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weatherapp.attributes.Currently;


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
		System.out.println("hey george");
	}
}