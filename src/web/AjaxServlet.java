/**
 *	2015年1月27日 上午11:25:18
 *	TangLi
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author TangLi
 * 2015年1月27日上午11:25:18
 */
public class AjaxServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		PrintWriter writer = response.getWriter();
		writer.write("this is from ajax servlet");
		writer.flush();
		
	}
	
	

}
