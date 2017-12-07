package com.weatherapp.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import com.weatherapp.attributes.Location;
import com.weatherapp.attributes.Results;
import com.weatherapp.responseDTOs.WeatherResponse;
import com.weatherapp.responseDTOs.ZipCodeResponse;

public class Utilities {
	private static final Logger log = LoggerFactory.getLogger(Utilities.class);
	
	public static boolean validateZip(String zipCode){
		if(zipCode.length() != 5)
			return false;
		try{
			int result = Integer.parseInt(zipCode);
		} catch(Exception e){
			log.info("failed to parse zipCode!");
			return false;
		}
		return true;
	}
	
	public static String getTime(Long time){
		Date d = new Date(time * 1000);
		log.info(d.toString());
		return d.toString();
	}
	
	public static Results fetchLatAndLong(String zipCode){
		String url = "http://maps.googleapis.com/maps/api/geocode/json?address=" + zipCode;
		RestTemplate rt = new RestTemplate();
		ZipCodeResponse response = null;
		Boolean lock = true;
		while(lock){
			response = rt.getForObject(url, ZipCodeResponse.class);
			if(response != null){
				lock = false;
			}
		}
		log.info("Status : " + response.getStatus());
		if(response.getStatus().equals("OK")){
			for(Results result: response.getResults()){
				return result;
			}
		}
		return null;
	}
	
	// you must create a darksky account in order to obtain an apiKey to use their services
	public static WeatherResponse fetchWeather(Location loc) throws IOException{
		// create a darksky account and replace this api key with your key
		String apiKey = getApiKey();
		String url = "https://api.darksky.net/forecast/" + apiKey + "/" + loc.getLat() + "," + loc.getLng();
		RestTemplate rt = new RestTemplate();
		WeatherResponse wr = null;
		Boolean lock = true;
		while(lock){
			wr = rt.getForObject(url, WeatherResponse.class);
			if(wr != null){
				lock = false;
			}
		}
		log.info(wr.toString());
		return wr;
	}
	
	@SuppressWarnings("unused")
	public static String getApiKey() throws IOException{
		String apiKey = "";
		InputStream configFile = null;
		try{
			Properties prop = new Properties();
			// configFile = new FileInputStream("//Users//Argos//Desktop//darkSkyApiKey.properties");
			configFile = new FileInputStream("//var//darkSkyApiKey.properties");
			if(configFile != null){
				prop.load(configFile);
			} else{
				throw new FileNotFoundException("property file '" + configFile + "' not found in the classpath");
			}
			apiKey = prop.getProperty("apiKey");
			log.info("Api Key - " + apiKey);
		} catch(Exception e){
			log.info("Exception: " + e);
		} finally{
			configFile.close();
		}
		return apiKey;
	}
}