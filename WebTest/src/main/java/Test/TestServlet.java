package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HttpServletBean;

public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("Hello Servlet !");
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
