/**
 *	2014年12月2日 上午10:56:47
 *	TangLi
 */
package t_ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * @author TangLi 2014年12月2日上午10:56:47
 */
public class StudentDaoImpl
{

	private static SqlMapClient sqlMapClient = null;
	// 读取配置文件
	static
	{
		try
		{
			Reader reader = Resources.getResourceAsReader("ibatis/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public boolean addStudent(Student student)
	{
		Object object = null;
		boolean flag = false;
		try
		{
			object = sqlMapClient.insert("addStudent", student);
			System.out.println("添加学生信息的返回值：" + object);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		if (object != null)
		{
			flag = true;
		}
		return flag;
	}

	public boolean deleteStudentById(int id)
	{
		boolean flag = false;
		Object object = null;
		try
		{
			object = sqlMapClient.delete("deleteStudentById", id);
			System.out.println("删除学生信息的返回值：" + object + "，这里返回的是影响的行数");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		if (object != null)
		{
			flag = true;
		}
		return flag;
	}

	public boolean updateStudent(Student student)
	{
		boolean flag = false;
		Object object = false;
		try
		{
			object = sqlMapClient.update("updateStudent", student);
			System.out.println("更新学生信息的返回值：" + object + "，返回影响的行数");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		if (object != null)
		{
			flag = true;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<Student> selectAllStudent()
	{
		List<Student> students = null;
		try
		{
			students = sqlMapClient.queryForList("selectAllStudent");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return students;
	}

	@SuppressWarnings("unchecked")
	public List<Student> selectStudentByName(String name)
	{
		List<Student> students = null;
		try
		{
			students = sqlMapClient.queryForList("selectStudentByName", name);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return students;
	}

	public Student selectStudentById(int id)
	{
		Student student = null;
		try
		{
			student = (Student) sqlMapClient.queryForObject("selectStudentById", id);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return student;
	}
}