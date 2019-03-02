package Wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ChoiceRequestWrapper extends HttpServletRequestWrapper {

	public ChoiceRequestWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	public String getParameter(String name){
		String choice = super.getParameter(name);
		if(choice == null || choice == ""){
			return "(wrapped)" + choice;
		}
		return choice;
		
	}

}
