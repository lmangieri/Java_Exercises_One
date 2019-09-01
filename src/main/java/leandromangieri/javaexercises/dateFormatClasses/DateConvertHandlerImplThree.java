package leandromangieri.javaexercises.dateFormatClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertHandlerImplThree extends AbstractDateConvertHandler {

	public DateConvertHandlerImplThree() {
		this.nextHandler = null;
	}
	
	/*
	 * Tries to convert MM-DD-YYYY into YYYYMMDD
	 * */
	@Override
	public String handleRequest(String unformatedDateString) {
		System.out.println("DateConvertHandlerImplThree trying to handle request "+unformatedDateString);
		String patternInput = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormatInput = new SimpleDateFormat(patternInput);
		simpleDateFormatInput.setLenient(false);
		try {
			Date date = simpleDateFormatInput.parse(unformatedDateString);
			
			String patternOutPut = "yyyyMMdd";
			SimpleDateFormat simpleDateFormatOutput = new SimpleDateFormat(patternOutPut);
			String result = simpleDateFormatOutput.format(date);
			System.out.println("DateConvertHandlerImplThree managed to convert "+unformatedDateString+" - " +date + " - to "+result);
			return result;
		} catch (ParseException e) {
			if(nextHandler != null) {
				return this.nextHandler.handleRequest(unformatedDateString);
			}
		}
		return null;
	}

	@Override
	public void registerNextHandler(
			AbstractDateConvertHandler dateConvertHandler) {
		this.nextHandler = dateConvertHandler;
		
	}

}
