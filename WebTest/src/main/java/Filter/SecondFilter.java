package Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter printWriter = response.getWriter();
		printWriter.println("Begin Second Filter");
		
		chain.doFilter(request, response);
		
		printWriter.println("Finish Second Filter");
	}
	
	public void destroy() {}

}
