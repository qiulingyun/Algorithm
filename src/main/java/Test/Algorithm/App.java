package Test.Algorithm;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
	private final ArrayList<String> aList;
	public App(){
		aList = new ArrayList<String>();
		aList.add("a");
	}
	
	public void test(){
		aList.add("b");
		System.out.println(aList);
	}
	
    public static void main( String[] args )
    {
    	App app = new App();
    	app.test();
    }
}
