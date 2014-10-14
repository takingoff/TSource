/**
 *	2014年10月13日 下午10:01:30
 *	TangLi
 *	Standard.java
 */
package health_information.standard;

import health_information.model.SingleIndicator;

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
	public static final List<Integer> standardScores = new ArrayList<Integer>();
	static 
	{
		standardScores.add(100);
		standardScores.add(95 );
		standardScores.add(90 );
		standardScores.add(85 );
		standardScores.add(80 );
		standardScores.add(78 );
		standardScores.add(76 );
		standardScores.add(74 );
		standardScores.add(72 );
		standardScores.add(70 );
		standardScores.add(68 );
		standardScores.add(66 );
		standardScores.add(64 );
		standardScores.add(62 );
		standardScores.add(60 );
		standardScores.add(50 );
		standardScores.add(40 );
		standardScores.add(30 );
		standardScores.add(20 );
		standardScores.add(10 );
	}
	
	static public final List<String> standardLevels = new ArrayList<String>();
	static
	{
		standardLevels.add("优秀");
		standardLevels.add("良好");
		standardLevels.add("及格");
		standardLevels.add("不及格");
	}
	
	public static int getScore(int index)
	{
		return Standard.standardScores.get((index>=standardScores.size()?standardScores.size()-1:index));
	}

	public static String getLevel(int index)
	{
		if(index<3)
			return Standard.standardLevels.get(0);//优秀
		if(index<5)
			return Standard.standardLevels.get(1);//良好
		if(index<15)
			return Standard.standardLevels.get(2);//及格
		
		return Standard.standardLevels.get(3);//不及格
	}
	
	
	public static void main(String[] args)
	{
//		System.out.println(VitalCapacityStandard.scaleMap.get(GRADE6).get(FEMALE));
		
//		System.out.println(getLevel(VitalCapacityStandard.getRegion(1580, GRADE4, MALE)));
//		System.out.println(getScore(VitalCapacityStandard.getRegion(1580, GRADE4, MALE)));
		
//		System.out.println(getLevel(Run50Standard.getRegion(19.9, GRADE3, MALE)));
//		System.out.println(getScore(Run50Standard.getRegion(19.9, GRADE3, MALE)));
		
		
//		System.out.println(getLevel(SitBendStandard.getRegion(13.1, GRADE3, FEMALE)));
//		System.out.println(getScore(SitBendStandard.getRegion(13.1, GRADE3, FEMALE)));
		
		
//		System.out.println(getLevel(SkipStandard.getRegion(90, GRADE3,MALE)));
//		System.out.println(getScore(SkipStandard.getRegion(90, GRADE3,MALE)));
//		System.out.println(SkipStandard.getExtra(179, GRADE4,FEMALE));
		
//		System.out.println(getLevel(SitupStandard.getRegion(39, GRADE4,MALE)));
//		System.out.println(getScore(SitupStandard.getRegion(39, GRADE4,MALE)));
		
//		System.out.println(getLevel(EnduranceStandard.getRegion(142, GRADE5,FEMALE)));
//		System.out.println(getScore(EnduranceStandard.getRegion(142, GRADE5,FEMALE)));
		
		
		
		SingleIndicator si = EnduranceStandard.judge(142, GRADE5, FEMALE);
		System.out.println(si.valueDouble);
		System.out.println(si.valueInt);
		
		
	}
	
	
	
	
	
}
