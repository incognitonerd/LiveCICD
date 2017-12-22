package junit.com.weatherapp.utilities;
import java.util.Date;
import junit.framework.TestCase;
import org.junit.Test;
import com.weatherapp.utilities.Constants;
import com.weatherapp.utilities.Utilities;

public class UtilitiesTest extends TestCase {
	@Test
	public void testValidateZip(){
		assertTrue(Utilities.validateZip(Constants.VALID_ZIP_CODE_TESTER));
		assertFalse(Utilities.validateZip(Constants.INVALID_ZIP_CODE_TESTER));
	}
	
	@Test
	public void testGetTime(){
		long currentTime = System.currentTimeMillis();
		Date d = new Date(currentTime * 1000);
		assertEquals(d.toString(), Utilities.getTime(currentTime));
	}
	/*
	 * @Test public void testFetchLatAndLong(){ assertNull(Utilities.fetchLatAndLong(Constants.INVALID_ZIP_CODE_TESTER)); assertTrue(Utilities.fetchLatAndLong(Constants.INVALID_ZIP_CODE_TESTER) instanceof Results);
	 * assertNotNull(Utilities.fetchLatAndLong(Constants.VALID_ZIP_CODE_TESTER)); assertTrue(Utilities.fetchLatAndLong(Constants.VALID_ZIP_CODE_TESTER) instanceof Results); }
	 */
	/*
	 * @Test public void testFetchWeather() throws IOException{ Location l = new Location(); l.setLat(Constants.LAT_TESTER); l.setLng(Constants.LNG_TESTER); assertNotNull(Utilities.fetchWeather(l)); assertTrue(Utilities.fetchWeather(l) instanceof
	 * WeatherResponse); }
	 */
}
