package junit.com.weatherapp.attributes;
import junit.framework.TestCase;
import org.junit.Test;
import com.weatherapp.attributes.Geometry;
import com.weatherapp.attributes.Results;
import com.weatherapp.utilities.Constants;

public class ResultsTest extends TestCase {
	@Test
	public void testSetFormatted_address(){
		Results r = new Results();
		r.setFormatted_address(Constants.STRING_TESTER);
		assertEquals(Constants.STRING_TESTER, r.getFormatted_address());
	}
	
	@Test
	public void testSetGeometry(){
		Results r = new Results();
		r.setGeometry(new Geometry());
		assertNotNull(r.getGeometry());
		assertTrue(r instanceof Results);
	}
}
