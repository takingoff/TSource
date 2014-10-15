/**
 *	2014年10月15日 下午4:27:18
 *	TangLi
 */
package health_information.util;

import health_information.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author TangLi
 * 2014年10月15日下午4:27:18
 */
public class EntityReader implements IEntityReader
{

	@Override
	public List<Student> readFromExcel(String filePath)
	{
		List<Student> list = new ArrayList<Student>();
		
		
		List<String> sex = new ArrayList<String>();
		sex.add("男");
		sex.add("女");
		
		List<String> grade = new ArrayList<String>();
		grade.add("2009");
		grade.add("2010");
		grade.add("2011");
		grade.add("2012");
		grade.add("2013");
		grade.add("2014");
		
		Random rand = new Random();
		
		
		for(int i = 0 ;i <100;i++)
		{
			list.add(new Student("classNO"+i,grade.get(rand.nextInt(100)%6)+"className"+i,"code"+i,"nativeCode","name"+i,sex.get(rand.nextInt(100)%2),"birthDay"+i,"origin"+i,"idcard"+i,"address"+i));
			
		}
		
		return list;
	}

}
