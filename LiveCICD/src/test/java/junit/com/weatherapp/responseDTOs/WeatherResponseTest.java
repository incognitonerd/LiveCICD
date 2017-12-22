package junit.com.weatherapp.responseDTOs;
import junit.framework.TestCase;
import org.junit.Test;
import com.weatherapp.attributes.Currently;
import com.weatherapp.responseDTOs.WeatherResponse;

public class WeatherResponseTest extends TestCase {
	@Test
	public void testSetCurrently(){
		WeatherResponse w = new WeatherResponse();
		w.setCurrently(new Currently());
		assertNotNull(w.getCurrently());
		assertTrue(w instanceof WeatherResponse);
	}
}
