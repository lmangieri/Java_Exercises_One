package leandromangieri.javaexercises;

import java.util.ArrayList;
import java.util.List;

import leandromangieri.javaexercises.dateFormatClasses.*;

public class ApplicationDateFormat {
	
	private AbstractDateConvertHandler dateConvertHandlerOne;
	
	public ApplicationDateFormat() {
		AbstractDateConvertHandler dateConvertHandlerOne = new DateConvertHandlerImplOne();
		AbstractDateConvertHandler dateConvertHandlerTwo = new DateConvertHandlerImplTwo();
		AbstractDateConvertHandler dateConvertHandlerThree = new DateConvertHandlerImplThree();
		
		dateConvertHandlerOne.registerNextHandler(dateConvertHandlerTwo);
		dateConvertHandlerTwo.registerNextHandler(dateConvertHandlerThree);
		
		this.dateConvertHandlerOne = dateConvertHandlerOne;
	}
	
	/*
	 * Pre requirement: All incoming dates will be valid dates, but only those in one of the following formats:
YYYY/MM/DD, DD/MM/YYYY and MM-DD-YYYY should be included in the returned list.
	 * 
	 * Post requirement: returns a new list with each date in the format YYYYMMDD.
	 * 
	 * */
	public List<String> changeDateFormat(List<String> notFormatedDateList) {
		List<String> formatedDateList = new ArrayList<>();
		for(String notFormatedDateString : notFormatedDateList) {
			String formatedDateString = this.dateConvertHandlerOne.handleRequest(notFormatedDateString);
			if(formatedDateString != null) {
				formatedDateList.add(formatedDateString);
			}
		}
		return formatedDateList;
	}
}
