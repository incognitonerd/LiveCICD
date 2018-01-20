package junit.com.weatherapp;
import junit.com.weatherapp.attributes.CurrentlyTest;
import junit.com.weatherapp.attributes.GeometryTest;
import junit.com.weatherapp.attributes.LocationTest;
import junit.com.weatherapp.attributes.ResultsTest;
import junit.com.weatherapp.responseDTOs.ResponseMsgsTest;
import junit.com.weatherapp.responseDTOs.WeatherResponseTest;
import junit.com.weatherapp.responseDTOs.ZipCodeResponseTest;
import junit.com.weatherapp.services.ServicesTest;
import junit.com.weatherapp.utilities.UtilitiesTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite(){
		TestSuite ts = new TestSuite();
		ts.addTestSuite(CurrentlyTest.class);
		ts.addTestSuite(GeometryTest.class);
		ts.addTestSuite(LocationTest.class);
		ts.addTestSuite(ResultsTest.class);
		ts.addTestSuite(ResponseMsgsTest.class);
		ts.addTestSuite(WeatherResponseTest.class);
		ts.addTestSuite(ZipCodeResponseTest.class);
		//ts.addTestSuite(ServicesTest.class);
		ts.addTestSuite(UtilitiesTest.class);
		return ts;
	}
}
