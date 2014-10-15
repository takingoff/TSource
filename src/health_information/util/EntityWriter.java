/**
 *	2014年10月15日 下午4:36:37
 *	TangLi
 */
package health_information.util;

import health_information.model.Student;

import java.util.List;

/**
 * @author TangLi
 * 2014年10月15日下午4:36:37
 */
public class EntityWriter implements IEntityWriter
{
	@Override
	public void writeToWord(List<Student> entityList)
	{

		for(Student s:entityList)
		{
			System.out.println(s.toString());
		}
	}

	
	
	
	
	
	
	public static void main(String[] ars)
	{
		
		
	}
	
	
	
	
}
