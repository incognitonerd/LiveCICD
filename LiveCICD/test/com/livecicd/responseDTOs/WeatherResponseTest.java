package com.livecicd.responseDTOs;
import junit.framework.TestCase;
import org.junit.Test;
import com.livecicd.attributes.Currently;

public class WeatherResponseTest extends TestCase {
	@Test
	public void testSetCurrently(){
		WeatherResponse w = new WeatherResponse();
		w.setCurrently(new Currently());
		assertNotNull(w.getCurrently());
		assertTrue(w instanceof WeatherResponse);
	}
}
