/**
 *	2014年10月21日 下午12:40:54
 *	TangLi
 */
package health_information.util;

import health_information.standard.Standard;

/**
 * @author TangLi
 * 2014年10月21日下午12:40:54
 */
public class Common
{
	public static String identifyGrade(String gradeString)
	{
		if(gradeString.contains(Standard.GRADE1))
			return Standard.GRADE1;
		else if(gradeString.contains(Standard.GRADE2))
			return Standard.GRADE2;
		else if(gradeString.contains(Standard.GRADE3))
			return Standard.GRADE3;
		else if(gradeString.contains(Standard.GRADE4))
			return Standard.GRADE4;
		else if(gradeString.contains(Standard.GRADE5))
			return Standard.GRADE5;
		else
			return Standard.GRADE6;
	}
	
	public static String identifySex(String sex)
	{
		if(sex.contains(Standard.FEMALE))
			return Standard.FEMALE;
		else
			return Standard.MALE;
	}
}
