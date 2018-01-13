package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Counter extends HttpServlet {
	private HashMap<String, Long> counterMap = new HashMap<String, Long>();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("Current Counter is: \n" + counterMap.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		
		String choice = (String) req.getParameter("choice");
		Long counter = counterMap.get(choice);
		if(counter == null){
			counter = new Long(1);
			counterMap.put(choice, counter);
		}else{
			counterMap.put(choice, ++counter);
		}
		try {
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("Choice is: " + choice);
			printWriter.println("Counter is: " + counter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
