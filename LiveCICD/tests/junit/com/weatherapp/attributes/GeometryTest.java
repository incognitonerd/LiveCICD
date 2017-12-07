package junit.com.weatherapp.attributes;
import junit.framework.TestCase;
import org.junit.Test;
import com.weatherapp.attributes.Geometry;
import com.weatherapp.attributes.Location;

public class GeometryTest extends TestCase {
	@Test
	public void testSetLocation(){
		Geometry g = new Geometry();
		g.setLocation(new Location());
		assertNotNull(g.getLocation());
		assertTrue(g instanceof Geometry);
	}
}
