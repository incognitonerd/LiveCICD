package com.livecicd.services;
import junit.framework.TestCase;
import org.junit.Test;
import com.livecicd.responseDTOs.ResponseMsgs;
import com.livecicd.utilities.Constants;

public class ServicesTest extends TestCase {
	@Test
	public void testWeatherApp() throws Exception{
		Services s = new Services();
		assertNotNull(s.weatherApp(Constants.INVALID_ZIP_CODE_TESTER));
		assertTrue(s.weatherApp(Constants.INVALID_ZIP_CODE_TESTER) instanceof ResponseMsgs);
		s.weatherApp(Constants.VALID_ZIP_CODE_TESTER);
		assertNotNull(s.weatherApp(Constants.VALID_ZIP_CODE_TESTER));
		assertTrue(s.weatherApp(Constants.VALID_ZIP_CODE_TESTER) instanceof ResponseMsgs);
	}
}
