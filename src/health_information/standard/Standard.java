/**
 *	2014年10月13日 下午10:01:30
 *	TangLi
 *	Standard.java
 */
package health_information.standard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TangLi
 * 2014年10月13日下午10:01:30
 */
public abstract class Standard
{
	
	
	///年级、男女、
	public static final String GRADE1 = "2014";
	public static final String GRADE2 = "2013";
	public static final String GRADE3 = "2012";
	public static final String GRADE4 = "2011";
	public static final String GRADE5 = "2010";
	public static final String GRADE6 = "2009";
	
	public static final String FEMALE = "男";
	public static final String MALE = "女";
	
	
	/**
	 * 100分 -- 10分 共20个档次
	 */
	public static List<Integer> scores = new ArrayList<Integer>();
	static 
	{
		scores.add(100);
		scores.add(95 );
		scores.add(90 );
		scores.add(85 );
		scores.add(80 );
		scores.add(78 );
		scores.add(76 );
		scores.add(74 );
		scores.add(72 );
		scores.add(70 );
		scores.add(68 );
		scores.add(66 );
		scores.add(64 );
		scores.add(62 );
		scores.add(60 );
		scores.add(50 );
		scores.add(40 );
		scores.add(30 );
		scores.add(20 );
		scores.add(10 );
	}
	
	
	static public final List<String> levels = new ArrayList<String>();
	static
	{
		levels.add("优秀");
		levels.add("良好");
		levels.add("及格");
		levels.add("不及格");
	}
	
	
	
	public abstract int getRegion(int value,String grade,String sex);
	
	public int getScore(int value, String grade, String sex)
	{
		return Standard.scores.get(getRegion(value, grade, sex));
	}

	public String getLevel(int value, String grade, String sex)
	{
		if(getRegion(value, grade, sex)<3)
			return Standard.levels.get(0);//优秀
		if(getRegion(value, grade, sex)<5)
			return Standard.levels.get(1);//良好
		if(getRegion(value, grade, sex)<3)
			return Standard.levels.get(2);//及格
		
		return Standard.levels.get(3);//不及格
	}
	
	public static void main(String[] args)
	{
		System.out.println(VitalCapacityStandard.scaleMap.get(GRADE6).get(FEMALE));
	}
	
	
	
	
	
}
