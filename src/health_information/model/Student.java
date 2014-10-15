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

	public SingleIndicator weightResult;
	public SingleIndicator vitalCapacityResult;
	public SingleIndicator run50Result;
	public SingleIndicator sitBendResult;
	public SingleIndicator skipResult;
	public SingleIndicator situpResult;
	public SingleIndicator enduranceResult;
	
	public String classNo;//班级编号
	public String className;//班全名
	public String studentCode;//学籍号
	public String nativeCode;//名族
	public String name;
	public String sex;
	public String birthday;
	public String origin;//来源
	public String idCard;//身份证
	public String address;//家庭住址
	/**
	 * @param classNo
	 * @param className
	 * @param studentCode
	 * @param nativeCode
	 * @param name
	 * @param sex
	 * @param birthday
	 * @param origin
	 * @param idCard
	 * @param address
	 */
	public Student(String classNo, String className, String studentCode, String nativeCode, String name, String sex, String birthday, String origin, String idCard, String address)
	{
		super();
		this.classNo = classNo;
		this.className = className;
		this.studentCode = studentCode;
		this.nativeCode = nativeCode;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.origin = origin;
		this.idCard = idCard;
		this.address = address;
	}
	
	public Student()
	{
	}

	@Override
	public String toString()
	{
		return "Student [weightResult=" + weightResult + ", vitalCapacityResult=" + vitalCapacityResult + ", run50Result=" + run50Result + ", sitBendResult=" + sitBendResult + ", skipResult=" + skipResult + ", situpResult=" + situpResult
				+ ", enduranceResult=" + enduranceResult + ", classNo=" + classNo + ", className=" + className + ", studentCode=" + studentCode + ", nativeCode=" + nativeCode + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", origin="
				+ origin + ", idCard=" + idCard + ", address=" + address + "]";
	}
	
	
	
	
	
}
