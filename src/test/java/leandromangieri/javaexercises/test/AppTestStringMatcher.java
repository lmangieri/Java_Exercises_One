package leandromangieri.javaexercises.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import leandromangieri.javaexercises.ApplicationStringMatcher;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTestStringMatcher 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void testStringMatcher_role1() {
    	String text = "Name:Alfredo Guimaraes,Idade:25 anos, Sexo: Masculino; Name:Maria Rosa,Idade:30anos, Sexo: Feminino ";
    	ApplicationStringMatcher app = new ApplicationStringMatcher();
    	
    	List<String> agesList = app.extractAgesFromText(text);
    	assertEquals(agesList.size(),2);
    	assertTrue(agesList.contains("25"));
    	assertTrue(agesList.contains("30"));
    }
    
    @Test
    public void test1StringMatcher_role2() {
    	String xml = 
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<log>\n" + 
                "    <entry id=\"1\">\n" + 
                "        <message>Application started</message>\n" + 
                "    </entry>\n" + 
                "    <entry id=\"2\">\n" + 
                "        <message>Application ended</message>\n" + 
                "    </entry>\n" + 
                "</log>";
    	
    	ApplicationStringMatcher app = new ApplicationStringMatcher();
    	String id = app.getIdBasedOnText(xml,"Application started");
    	assertEquals("1",id);
    }
    
    @Test
    public void test2StringMatcher_role2() {
    	String xml = 
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<log>\n" + 
                "    <entry id=\"1\">\n" + 
                "        <message>Application started</message>\n" + 
                "    </entry>\n" +
                
                "    <entry id=\"2\">\n" + 
                "    	<anotherTag something=\"555\">" +
                "            <message>Application ended</message>\n" + 
                "    	</anotherTag>"+
                "    </entry>\n" + 
                "</log>";
    	
    	ApplicationStringMatcher app = new ApplicationStringMatcher();
    	String id = app.getIdBasedOnText(xml,"Application ended");
    	assertEquals("2",id);
    }
}
