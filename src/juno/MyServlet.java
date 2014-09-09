package juno;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name="myServlet",urlPatterns="/myServlet")
public class MyServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		System.out.println("from public service");
		
		response.getWriter().write("this message come from myServlet");
		
		
	}	
	
	
	
}
