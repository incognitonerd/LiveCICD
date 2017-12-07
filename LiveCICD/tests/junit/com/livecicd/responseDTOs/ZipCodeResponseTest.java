package junit.com.livecicd.responseDTOs;
import junit.framework.TestCase;
import org.junit.Test;
import com.livecicd.attributes.Results;
import com.livecicd.responseDTOs.ZipCodeResponse;
import com.livecicd.utilities.Constants;

public class ZipCodeResponseTest extends TestCase {
	@Test
	public void testSetStatus(){
		ZipCodeResponse z = new ZipCodeResponse();
		z.setStatus(Constants.STRING_TESTER);
		assertEquals(Constants.STRING_TESTER, z.getStatus());
	}
	
	@Test
	public void testSetResults(){
		ZipCodeResponse z = new ZipCodeResponse();
		Results[] r = new Results[Constants.SIZE_TESTER];
		for(int i = 0; i < Constants.SIZE_TESTER; i++){
			r[i] = new Results();
		}
		z.setResults(r);
		assertNotNull(z.getResults());
		assertTrue(z instanceof ZipCodeResponse);
		assertEquals(Constants.SIZE_TESTER, z.getResults().length);
	}
}
