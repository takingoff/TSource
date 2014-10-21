/**
 *	2014年10月15日 下午4:27:18
 *	TangLi
 */
package health_information.util;

import health_information.model.Student;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author TangLi 2014年10月15日下午4:27:18
 */
public class EntityReader implements IEntityReader
{

	@Override
	public List<Student> readIn(String filePath)
	{
		// return fakeData();

		return fromExcel(filePath);
	}

	public List<Student> fakeData()
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
		for (int i = 0; i < 1600; i++)
		{
			list.add(new Student("classNO" + i, grade.get(rand.nextInt(100) % 6) + "className" + i, "code" + i, "nativeCode", "name" + i, sex.get(rand.nextInt(100) % 2), "birthDay" + i, "origin" + i, "idcard" + i, "address" + i));

		}

		return list;
	}

	public static List<Student> fromExcel(String filePath)
	{
		try
		{
			List<Student> students = new ArrayList<Student>();

			InputStream xls = new FileInputStream(filePath);
			HSSFWorkbook wb = new HSSFWorkbook(xls);
			HSSFSheet sheet = wb.getSheetAt(0); // 第一个工作表

			HSSFRow row;
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				row = sheet.getRow(i); // 第三行
				students.add(new Student(row.getCell(0).toString(), row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString(), row.getCell(5).toString(), row.getCell(6).toString(), row.getCell(7).toString(),
						row.getCell(8).toString(), row.getCell(9).toString()));
			}
			return students;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	
	public static void main(String[] ars)
	{
		fromExcel("C:\\Users\\TangLi\\Desktop\\学生基本信息模版.xls");
	}

}
