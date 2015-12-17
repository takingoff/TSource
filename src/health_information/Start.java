/**
 *	2014年10月15日 下午8:34:38
 *	TangLi
 *	Start.java
 */
package health_information;

import health_information.model.Student;
import health_information.util.EntityReader;
import health_information.util.EntityWriter;
import health_information.util.IEntityReader;
import health_information.util.IEntityWriter;
import health_information.util.KernelProcess;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author TangLi
 * 2014年10月15日下午8:34:38
 */
public class Start
{
	public static void main(String[] arg) throws IOException
	{
		
		
		IEntityReader reader = new EntityReader();
		
		String projectPath = new File("").getCanonicalPath();
		List<Student> students = reader.readIn(projectPath+"\\desktop\\新健康标准\\学生基本信息模版(1).xls");
		
		System.setProperty("java.class.path", System.getProperty("java.class.path")+";"+projectPath+"\\desktop\\jacob-1.18-M2-x86.dll");
		System.out.println(System.getProperty("java.class.path"));
			
		///..process
		KernelProcess.process(students);
		
		
		IEntityWriter writer = new EntityWriter();
		writer.writeOut(students);
		
	}
}
