package com.livecicd.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import com.livecicd.attributes.Location;
import com.livecicd.attributes.Results;
import com.livecicd.responseDTOs.WeatherResponse;
import com.livecicd.responseDTOs.ZipCodeResponse;

public class Utilities {
	private static final Logger log = LoggerFactory.getLogger(Utilities.class);

	public static boolean validateZip(String zipCode) {
		if (zipCode.length() != 5)
			return false;
		try {
			int result = Integer.parseInt(zipCode);
		} catch (Exception e) {
			log.info("failed to parse zipCode!");
			return false;
		}
		return true;
	}

	public static String getTime(Long time) {
		Date d = new Date(time * 1000);
		log.info(d.toString());
		return d.toString();
	}

	public static Results fetchLatAndLong(String zipCode) {
		String url = "http://maps.googleapis.com/maps/api/geocode/json?address=" + zipCode;
		RestTemplate rt = new RestTemplate();
		ZipCodeResponse response1 = rt.getForObject(url, ZipCodeResponse.class);
		log.info("Status : " + response1.getStatus());
		if (response1.getStatus().equals("OK")) {
			for (Results result : response1.getResults()) {
				return result;
			}
		}
		return null;
	}

	// you must create a darksky account in order to obtain an apiKey to use their services
	public static WeatherResponse fetchWeather(Location loc) throws IOException {		
		// create a darksky account and replace this api key with your key
		String apiKey = getPropValues();
		String url = "https://api.darksky.net/forecast/" + apiKey + "/" + loc.getLat() + "," + loc.getLng();
		RestTemplate rt = new RestTemplate();
		WeatherResponse wr = rt.getForObject(url, WeatherResponse.class);
		log.info(wr.toString());
		return wr;
	}
	
	@SuppressWarnings("unused")
	public static String getPropValues() throws IOException{
		String apiKey = "";
		InputStream configFile = null;
		
		try{
			Properties prop = new Properties();
			//configFile = new FileInputStream("//Users//Argos//Desktop//darkSkyApiKey.properties");
			configFile = new FileInputStream("//var//darkSkyApiKey.properties");
			
			if(configFile != null){
				prop.load(configFile);
			} else{
				throw new FileNotFoundException("property file '" + configFile + "' not found in the classpath");
			}
			apiKey = prop.getProperty("apiKey");
			System.out.println("Api Key - " + apiKey);
		} catch(Exception e){
			System.out.println("Exception: " + e);
		} finally{
			configFile.close();
		}
		return apiKey;
	}
}