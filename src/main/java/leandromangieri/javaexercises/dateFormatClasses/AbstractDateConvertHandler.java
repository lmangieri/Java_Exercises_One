package leandromangieri.javaexercises.dateFormatClasses;

public abstract class AbstractDateConvertHandler {
	public AbstractDateConvertHandler nextHandler;
	public abstract String handleRequest (String unformatedDateString);
	public abstract void registerNextHandler(AbstractDateConvertHandler dateConvertHandler);
}
