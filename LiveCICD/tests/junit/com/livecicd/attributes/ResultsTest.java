package junit.com.livecicd.attributes;
import junit.framework.TestCase;
import org.junit.Test;
import com.livecicd.attributes.Geometry;
import com.livecicd.attributes.Results;
import com.livecicd.utilities.Constants;

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
