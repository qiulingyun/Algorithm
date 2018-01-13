package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
public class LoginAction extends AbstractController {
	
	private String successView;
	private String failView;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ModelAndView model = null;
		if(this.login(username, password)){
			model = new ModelAndView(this.getSuccessView());
			model.addObject("message", "Yeah!");
		}else{
			model = new ModelAndView(this.getFailView());
			model.addObject("message", "Oh No!");
		}
		 
		return model;
	}
	
	protected boolean login(String username, String password){
		if(username.equals("a") && password.equals("a")){
			return true;
		}else{
			return false;
		}
	}

	
	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	public String getFailView() {
		return failView;
	}

	public void setFailView(String failView) {
		this.failView = failView;
	}
	
	

}
