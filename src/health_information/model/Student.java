/**
 *	2014年10月13日 下午2:17:53
 *	TangLi
 */
package health_information.model;

/**
 * @author TangLi
 * 2014年10月13日下午2:17:53
 */
public class Student
{
//	班级编号	班级名称	学籍号	民族代码	姓名	性别	出生日期	学生来源	身份证号	家庭住址
	
	
//	体重指数（BMI）（千克/米2）
//	肺活量（毫升）
//	50米跑（秒）
//	坐位体前屈(厘米）
//	1分钟仰卧起坐(女)（次）
///	50*8往返跑	
	
	public String classNo;
	public String className;
	public String studentCode;
	public String nativeCode;
	public String name;
	public String birthday;
	public String origin;
	public String idCard;
	public String address;
	
	public String getClassNo()
	{
		return classNo;
	}
	public void setClassNo(String classNo)
	{
		this.classNo = classNo;
	}
	public String getClassName()
	{
		return className;
	}
	public void setClassName(String className)
	{
		this.className = className;
	}
	public String getStudentCode()
	{
		return studentCode;
	}
	public void setStudentCode(String studentCode)
	{
		this.studentCode = studentCode;
	}
	public String getNativeCode()
	{
		return nativeCode;
	}
	public void setNativeCode(String nativeCode)
	{
		this.nativeCode = nativeCode;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getBirthday()
	{
		return birthday;
	}
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	public String getOrigin()
	{
		return origin;
	}
	public void setOrigin(String origin)
	{
		this.origin = origin;
	}
	public String getIdCard()
	{
		return idCard;
	}
	public void setIdCard(String idCard)
	{
		this.idCard = idCard;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	
	
	
}
