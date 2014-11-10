/**
 *	2014年11月10日 上午11:12:41
 *	TangLi
 */
package chaos;

import java.io.File;

/**
 * @author TangLi 2014年11月10日上午11:12:41
 */
public class Chaos
{
	public static void main(String[] ar) throws Exception
	{

		System.out.println(System.getProperty("user.name"));// 
		System.out.println(System.getProperty("user.home"));// 。
		System.out.println(System.getProperty("java.home"));// /当前项目路径。
		System.out.println(System.getProperty("user.dir"));// /当前项目路径。

		File directory = new File("");// 设定为当前文件夹
		System.out.println(directory.getCanonicalPath());// 获取标准的路径
		System.out.println(directory.getAbsolutePath());// 获取绝对路径
		
		
		System.out.println(Chaos.class.getResource("").toString());
	}
}
