package junit.com.weatherapp.services;
import junit.framework.TestCase;
import org.junit.Test;
import com.weatherapp.responseDTOs.ResponseMsgs;
import com.weatherapp.services.Services;
import com.weatherapp.utilities.Constants;

public class ServicesTest extends TestCase {
	@Test
	public void testWeatherApp() throws Exception{
		Services s = new Services();
		assertNotNull(s.weatherApp(Constants.INVALID_ZIP_CODE_TESTER));
		assertFalse(s.weatherApp(Constants.INVALID_ZIP_CODE_TESTER) instanceof ResponseMsgs);
		s.weatherApp(Constants.VALID_ZIP_CODE_TESTER);
		assertNotNull(s.weatherApp(Constants.VALID_ZIP_CODE_TESTER));
		assertTrue(s.weatherApp(Constants.VALID_ZIP_CODE_TESTER) instanceof ResponseMsgs);
	}
}
