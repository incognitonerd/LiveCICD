package com.livecicd.attributes;
import junit.framework.TestCase;
import org.junit.Test;

public class GeometryTest extends TestCase {
	@Test
	public void testSetLocation(){
		Geometry g = new Geometry();
		g.setLocation(new Location());
		assertNotNull(g.getLocation());
		assertTrue(g instanceof Geometry);
	}
}
