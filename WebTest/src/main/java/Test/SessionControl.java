package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionControl extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		HttpSession httpSession = req.getSession();
		String logout = (String) req.getParameter("logout");
		if(logout != null){
			httpSession.invalidate();
			resp.sendRedirect("UserSession.html");
		}else{
			PrintWriter printWriter = resp.getWriter();
			
			String inputUser = (String) req.getParameter("user");
			this.printSessionInfo(printWriter, httpSession, inputUser);
		}
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		
		
	}
	
	private void printSessionInfo(PrintWriter printWriter, HttpSession httpSession, String inputUser){
		if(printWriter == null || httpSession == null || inputUser == null || inputUser == ""){
			return;
		}
		
//		printWriter.println("<html>");
//		printWriter.println("<head>Session</head>");
//		printWriter.println("<body>");
		
		String user = (String) httpSession.getAttribute("user");
		if(httpSession.isNew()){
			printWriter.println("New User:" + inputUser);
			httpSession.setAttribute("user", inputUser);
			
		}else{
			printWriter.println("Existed User:" + user);
		}
		
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		printWriter.println("Session Id:" + httpSession.getId());
		printWriter.println("Session Creation Time:" + format.format(httpSession.getCreationTime()));
		printWriter.println("Session Last Accessed Time:" + format.format(httpSession.getLastAccessedTime()));
		printWriter.println("Session Max Inactive Interval:" + httpSession.getMaxInactiveInterval());
//		printWriter.println("<input type=button name=logout value=logout>");
//		printWriter.println("</body>");
//		printWriter.println("</html>");

		
	}
}
