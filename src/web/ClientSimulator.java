/**
 *	2015年1月29日 下午4:50:15
 *	TangLi
 */
package web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author TangLi
 * 2015年1月29日下午4:50:15
 */
public class ClientSimulator
{
	public static void main(String[] ars)
	{
		
		ExecutorService es = Executors.newFixedThreadPool(60);
		
		for (int i = 0; i < 60; i++)
		{
			es.execute(new Runnable()
			{
				@Override
				public void run(){
					
					try
					{
						URL url = new URL("http://127.0.0.1:7070/TSource/ajaxServlet");
						HttpURLConnection con = (HttpURLConnection) url.openConnection();
						InputStream inputStream = con.getInputStream();
						LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream));
						System.out.println(lineNumberReader.readLine());
						lineNumberReader.close();
						con.disconnect();
						
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					
				}
			});
		}
		
		es.shutdown();
		
	}
}
