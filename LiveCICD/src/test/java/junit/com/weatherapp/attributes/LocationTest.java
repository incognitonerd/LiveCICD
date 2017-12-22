package junit.com.weatherapp.attributes;
import junit.framework.TestCase;
import org.junit.Test;
import com.weatherapp.attributes.Location;
import com.weatherapp.utilities.Constants;

public class LocationTest extends TestCase {
	@Test
	public void testSetLat(){
		Location l = new Location();
		l.setLat(Constants.STRING_TESTER);
		assertEquals(Constants.STRING_TESTER, l.getLat());
	}
	
	@Test
	public void testSetLng(){
		Location l = new Location();
		l.setLng(Constants.STRING_TESTER);
		assertEquals(Constants.STRING_TESTER, l.getLng());
	}
}
