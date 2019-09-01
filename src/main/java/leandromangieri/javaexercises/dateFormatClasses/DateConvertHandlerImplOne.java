package leandromangieri.javaexercises.dateFormatClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertHandlerImplOne extends AbstractDateConvertHandler {
	public DateConvertHandlerImplOne() {
		this.nextHandler = null;
	}
	/*
	 * Tries to convert YYYY/MM/DD into YYYYMMDD
	 * */
	@Override
	public String handleRequest(String unformatedDateString) {
		System.out.println("DateConvertHandlerImplOne trying to handle request "+unformatedDateString);
		String patternInput = "yyyy/MM/dd";
		SimpleDateFormat simpleDateFormatInput = new SimpleDateFormat(patternInput);
		
		/* Specify whether or not date/time parsing is to be lenient. With lenient parsing, 
		 * the parser may use heuristics to interpret inputs that do not precisely match this object's format. 
		 * With strict parsing, inputs must match this object's format.
		So, if you have a pattern and create a date object that strictly matches your pattern, set lenient to 
		false. Also, DateFormat is lenient, by default. */
		simpleDateFormatInput.setLenient(false);
		
		try {
			Date date = simpleDateFormatInput.parse(unformatedDateString);
			
			String patternOutPut = "yyyyMMdd";
			SimpleDateFormat simpleDateFormatOutput = new SimpleDateFormat(patternOutPut);
			
			String result = simpleDateFormatOutput.format(date);
			
			System.out.println("DateConvertHandlerImplOne managed to convert "+unformatedDateString+" - " +date + " - to "+result);
			
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
