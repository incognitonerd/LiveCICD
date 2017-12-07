package junit.com.livecicd;
import junit.com.livecicd.attributes.CurrentlyTest;
import junit.com.livecicd.attributes.GeometryTest;
import junit.com.livecicd.attributes.LocationTest;
import junit.com.livecicd.attributes.ResultsTest;
import junit.com.livecicd.responseDTOs.ResponseMsgsTest;
import junit.com.livecicd.responseDTOs.WeatherResponseTest;
import junit.com.livecicd.responseDTOs.ZipCodeResponseTest;
import junit.com.livecicd.services.ServicesTest;
import junit.com.livecicd.utilities.UtilitiesTest;
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
		ts.addTestSuite(ServicesTest.class);
		ts.addTestSuite(UtilitiesTest.class);
		return ts;
	}
}
