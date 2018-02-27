package QLY.TestMaven;

import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Begin!" );
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Guy guy = (Guy) ctx.getBean("guy");
        guy.useWeapon();
        
        SortedMap<Integer, String> scoreMap = new TreeMap<Integer, String>();
		scoreMap.put(1, "a");
		scoreMap.put(3, "c");
		scoreMap.put(2, "b");
		scoreMap.put(4, "d");
		System.out.println(scoreMap);
		System.out.println(scoreMap.values());
		System.out.println(scoreMap.get(scoreMap.lastKey())); 
		
		SortedMap<String, String> scoreMap2 = new TreeMap<String, String>();
		scoreMap2.put("a", "a");
		scoreMap2.put("c", "c");
		scoreMap2.put("b", "b");
		scoreMap2.put("d", "d");
		System.out.println(scoreMap2);
    }
}
