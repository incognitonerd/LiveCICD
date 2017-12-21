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
	private static final String errMsg = "Invalid Zip Code!";
	
	// example request: http://localhost:8080/zaysServices/weatherApp?zipCode=30032
	@RequestMapping(value = "/weatherApp", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public Object weatherApp(@RequestParam(value = "zipCode", required = true) String zipCode) throws Exception{
		if(Utilities.validateZip(zipCode)){
			Results result = Utilities.fetchLatAndLong(zipCode);
			WeatherResponse wr = Utilities.fetchWeather(result.getGeometry().getLocation());
			return new ResponseMsgs(Utilities.getTime(wr.getCurrently().getTime()), result.getFormatted_address(), wr
					.getCurrently().getTemperature(), wr.getCurrently().getSummary());
		} else{
			return new ErrorMsgs(errMsg);
		}
	}
}