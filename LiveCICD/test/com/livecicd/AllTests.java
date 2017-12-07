package com.livecicd;
import junit.framework.Test;
import junit.framework.TestSuite;
import com.livecicd.attributes.CurrentlyTest;
import com.livecicd.attributes.GeometryTest;
import com.livecicd.attributes.LocationTest;
import com.livecicd.attributes.ResultsTest;
import com.livecicd.responseDTOs.ResponseMsgsTest;
import com.livecicd.responseDTOs.WeatherResponseTest;
import com.livecicd.responseDTOs.ZipCodeResponseTest;
import com.livecicd.services.ServicesTest;
import com.livecicd.utilities.UtilitiesTest;

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
