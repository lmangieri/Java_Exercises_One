package leandromangieri.javaexercises;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationStringMatcher {

	public List<String> extractAgesFromText(String text) {
		List<String> list = new ArrayList<>();
		Pattern pattern = Pattern.compile("(Idade:)(\\d+)(\\s*anos)");
		Matcher matcher = pattern.matcher(text);
		boolean found = false;
		while (matcher.find()) {
			System.out.println(matcher.group(1) + "|" + matcher.group(2) + "|" + matcher.group(3));
			/* Examples of output :
			 * 
			 * Idade:|25| anos
			 * Idade:|30|anos
			 * 
			 * matcher.group(2) => will contain the age that we are looking for
			 */
			
			list.add(matcher.group(2));
		}
		return list;
	}
	
	public String getIdBasedOnText(String xml, String text) {
		Pattern pattern = Pattern.compile("(id=\")(\\d+)(\">)(((?!entry)[\\s\\S])*)(<message>)("+text+")(<\\/message>)");
		/*
		 *  (((?!entry)[\\s\\S])*)
		 *  The above piece of regex expression looks for a String that doesn't contain entry... otherwise it will have wrong behavior in the xml.
		 *  Example of problem: without above expression it would find the first entry/id and the latest message of the xml ignoring the correct entry/id 
		 *  that is trully related to the message of the xml
		 * 
		 *  Related to this lesson, would like to save below tip to find strings
		 *  that doesn't contain a bad word...
		 *  ^((?!badword).)*$
		 *  ^ => start of line
		 *  $ => end of line
		 *  . => Matches any character except line breaks... if you want to consider line breaks
		 *  you can substitute to [\\s\\S]
		 * */
		
		
		System.out.println(pattern);
		System.out.println(xml);
		Matcher matcher = pattern.matcher(xml);
		boolean found = false;
		int count = 0;
		String match = null;
		while (matcher.find()) {
			
			match = matcher.group(2);
			System.out.println(match);
			count ++;
		}
		
		if(count > 1) {
			System.out.println("This behavior shouldn't happen, something is wrong with the given xml");
			return null;
		}
		
		return match;
	}
}
