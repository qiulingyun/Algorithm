package Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Model.City;
import Wrapper.ChoiceRequestWrapper;

public class UserChoice extends HttpServlet {
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	public void init(){
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mysql-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("This is a choice");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
		ChoiceRequestWrapper wrappedRequest = new ChoiceRequestWrapper(req);
		String choice = wrappedRequest.getParameter("choice");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		City city = (City) sqlSession.selectOne("selectCity", choice);
		ServletContext servletContext = this.getServletContext();
		RequestDispatcher counterRequestDispatcher = servletContext.getRequestDispatcher("/counter");
		try {
			PrintWriter printWriter = resp.getWriter();
			if(city != null){
				printWriter.println(city.toString());

			}else{
//				resp.sendRedirect("NoResult.html");
//				resp.sendRedirect("hello");
				counterRequestDispatcher.forward(wrappedRequest, resp);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		sqlSession.close();
	}
}
