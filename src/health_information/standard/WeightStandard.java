/**
 *	2014年10月13日 下午2:23:59
 *	TangLi
 */
package health_information.standard;

import health_information.model.SingleIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author TangLi
 * 2014年10月13日下午2:23:59
 */
public class WeightStandard
{
	
	
//	等级	单项
//	得分	一年级	二年级	三年级	四年级	五年级	六年级
//	正常	100	13.5~18.1	13.7~18.4	13.9~19.4	14.2~20.1	14.4~21.4	14.7~21.8
//	低体重	80	≤13.4		≤13.6		≤13.8		≤14.1		≤14.3		≤14.6
//	超重		18.2~20.3	18.5~20.4	19.5~22.1	20.2~22.6	21.5~24.1	21.9~24.5
//	肥胖	60	≥20.4		≥20.5		≥22.2		≥22.7		≥24.2		≥24.6
	
	
//	等级	单项得分	一年级	二年级	三年级	四年级	五年级	六年级
//	正常	100	13.3~17.3	13.5~17.8	13.6~18.6	13.7~19.4	13.8~20.5	14.2~20.8
//	低体重	80	≤13.2		≤13.4		≤13.5		≤13.6		≤13.7		≤14.1
//	超重		17.4~19.2	17.9~20.2	18.7~21.1	19.5~22.0	20.6~22.9	20.9~23.6
//	肥胖	60	≥19.3		≥20.3		≥21.2		≥22.1		≥23.0		≥23.7
	
	public static final Map<String,Map<String,WeightScale>> scaleMap = new HashMap<String,Map<String,WeightScale>>();
	static
	{
		Map<String,WeightScale> map = new HashMap<String,WeightScale>();
		
		map.put(Standard.MALE, new WeightScale(13.5, 18.2, 20.4));
		map.put(Standard.FEMALE, new WeightScale(13.3, 17.4, 19.3));
		scaleMap.put(Standard.GRADE1, map);
		
		map = new HashMap<String,WeightScale>();
		map.put(Standard.MALE, new WeightScale(13.7, 18.5, 20.5));
		map.put(Standard.FEMALE, new WeightScale(13.5, 17.9, 20.3));
		scaleMap.put(Standard.GRADE2, map);
		
		map = new HashMap<String,WeightScale>();
		map.put(Standard.MALE, new WeightScale(13.9, 19.5,22.2));
		map.put(Standard.FEMALE, new WeightScale(13.6, 18.7, 21.2));
		scaleMap.put(Standard.GRADE3, map);
		
		map = new HashMap<String,WeightScale>();
		map.put(Standard.MALE, new WeightScale(14.2, 20.2, 22.7));
		map.put(Standard.FEMALE, new WeightScale(13.7, 19.5, 22.1));
		scaleMap.put(Standard.GRADE4, map);
		
		map = new HashMap<String,WeightScale>();
		map.put(Standard.MALE, new WeightScale(14.4, 21.5, 24.2));
		map.put(Standard.FEMALE, new WeightScale(13.8, 20.6, 23.0));
		scaleMap.put(Standard.GRADE5, map);
		
		map = new HashMap<String,WeightScale>();
		map.put(Standard.MALE, new WeightScale(14.7, 21.9, 24.6));
		map.put(Standard.FEMALE, new WeightScale(14.2, 20.9, 23.7));
		scaleMap.put(Standard.GRADE6, map);
		
	}
	
	static public final List<Integer> weightScoreList = new ArrayList<Integer>();
	static
	{
		weightScoreList.add(80);
		weightScoreList.add(100);
		weightScoreList.add(80);
		weightScoreList.add(60);
	}
	
	static public final List<String> weightLevelList = new ArrayList<String>();
	static
	{
		weightLevelList.add("低体重");
		weightLevelList.add("正常体重");
		weightLevelList.add("超重");
		weightLevelList.add("肥胖");
	}
	
	
	public static int getRegion(Double value, String grade, String sex)
	{
		int region = 0;
		for(Double scaleMax:scaleMap.get(grade).get(sex).scaleList)
		{
			if(value < scaleMax)
				break;
			else
				region ++;
		}
		return region;
	}
	
	public static int getScore(Double value, String grade, String sex)
	{
		int index = getRegion(value,grade,sex);
		index = index>=weightScoreList.size()?(weightScoreList.size()-1):index;
		return weightScoreList.get(index);
	}

	public static String getLevel(Double value, String grade, String sex)
	{
		int index = getRegion(value,grade,sex);
		index = index>=weightLevelList.size()?(weightLevelList.size()-1):index;
		return weightLevelList.get(index);
	}


	static public void main(String[] ars)
	{
		
//		System.out.println(weightStandar.get(GRADE3).get(MALE).scaleList);
		System.out.println(getScore(12.7,"2012","男"));
		System.out.println(getLevel(12.7,"2012","男"));
		
	}

	public static SingleIndicator judge(Double value,String grade ,String sex)
	{
		SingleIndicator si = new SingleIndicator();
		
		int index = getRegion(value,grade,sex);
		si.valueDouble = value; 
		si.level = Standard.getLevel(index);
		si.score = Standard.getScore(index);
		
		return si;
		
	}

	
	
}
