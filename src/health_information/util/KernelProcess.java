/**
 *	2014年10月15日 下午4:39:00
 *	TangLi
 */
package health_information.util;

import health_information.model.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author TangLi
 * 2014年10月15日下午4:39:00
 */
public class KernelProcess
{
	public static void main(String[] arg)
	{
		IEntityReader reader = new EntityReader();
		IEntityWriter writer = new EntityWriter();
		
		List<Student> students = reader.readFromExcel("");
		
			
		///.................process
		
		Collections.sort(students, new Comparator<Student>()
		{
			@Override
			public int compare(Student o1, Student o2)
			{
				int class1 = Integer.parseInt(o1.className.substring(0, 4));
				int class2 = Integer.parseInt(o2.className.substring(0, 4));
				if(class1-class2>0)
				{
					return 1;
				}
				else if(class1-class2<0)
				{
					return -1;
				}
				else
				{
					
					return 0;
				}
			}
			
		});
		
		
		writer.writeToWord(students);
		
	}
}
