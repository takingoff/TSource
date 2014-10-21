/**
 *	2014年10月15日 下午4:25:36
 *	TangLi
 */
package health_information.util;

import health_information.model.Student;

import java.util.List;

/**
 * @author TangLi
 * 2014年10月15日下午4:25:36
 */
public interface IEntityWriter
{
	public void writeOut(List<Student> entityList);
}
