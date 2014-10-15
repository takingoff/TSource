/**
 *	2014年10月15日 下午4:23:34
 *	TangLi
 */
package health_information.util;

import health_information.model.Student;

import java.util.List;

/**
 * @author TangLi
 * 2014年10月15日下午4:23:34
 */
public interface IEntityReader
{
	public List<Student> readFromExcel(String filePath);
	
}
