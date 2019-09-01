package leandromangieri.javaexercises.test;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import leandromangieri.javaexercises.ApplicationDateFormat;
public class AppTestFormatDate {

	@Test
	public void testChangeDateFormat() {
		ApplicationDateFormat app = new ApplicationDateFormat();
		List<String> formatedDatesAsString = app.changeDateFormat(Arrays.asList("2010/03/30","15/12/2016","11-15-2012","20130720"));
	
		for(String str : formatedDatesAsString) {
			System.out.println(str);
		}
		assertEquals(formatedDatesAsString.size(),3);
    	assertTrue(formatedDatesAsString.contains("20100330"));
    	assertTrue(formatedDatesAsString.contains("20161215"));
    	assertTrue(formatedDatesAsString.contains("20121115"));
	}
	
}
