package com.weatherapp.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapp.attributes.Results;
import com.weatherapp.responseDTOs.ErrorMsgs;
import com.weatherapp.responseDTOs.ResponseMsgs;
import com.weatherapp.responseDTOs.WeatherResponse;
import com.weatherapp.utilities.Utilities;

@RestController
@RequestMapping(value = "/zaysServices")
public class Services {
	private static final String invalidZipCodeError = "Invalid Zip Code!";
	private static final String queryLimitError = "OVER_QUERY_LIMIT!";

	// example request: http://localhost:8080/zaysServices/weatherApp?zipCode=30032
	@RequestMapping(value = "/weatherApp", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public Object weatherApp(@RequestParam(value = "zipCode", required = true) String zipCode) throws Exception {
		Results result = null;
		WeatherResponse wr = null;
		if (Utilities.validateZip(zipCode)) {
			try {
				result = Utilities.fetchLatAndLong(zipCode);
				wr = Utilities.fetchWeather(result.getGeometry().getLocation());
				return new ResponseMsgs(Utilities.getTime(wr.getCurrently().getTime()), result.getFormatted_address(),
						wr.getCurrently().getTemperature(), wr.getCurrently().getSummary());
			} catch (Exception e) {
				return new ErrorMsgs(queryLimitError);
			}
		} else {
			return new ErrorMsgs(invalidZipCodeError);
		}
	}
}