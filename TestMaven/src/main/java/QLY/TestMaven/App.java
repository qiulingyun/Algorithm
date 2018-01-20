package QLY.TestMaven;

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
    }
}
