package com.livecicd.attributes;
import junit.framework.TestCase;
import org.junit.Test;
import com.livecicd.utilities.Constants;

public class CurrentlyTest extends TestCase {
	@Test
	public void testSetTime(){
		Currently c = new Currently();
		c.setTime(Constants.LONG_TESTER);
		assertEquals(new Long(Constants.LONG_TESTER), c.getTime());
	}
	
	@Test
	public void testSetSummary(){
		Currently c = new Currently();
		c.setSummary(Constants.STRING_TESTER);
		assertEquals(Constants.STRING_TESTER, c.getSummary());
	}
	
	@Test
	public void testSetTemperature(){
		Currently c = new Currently();
		c.setTemperature(Constants.STRING_TESTER);
		assertEquals(Constants.STRING_TESTER, c.getTemperature());
	}
}
