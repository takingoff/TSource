/**
 *	2014年10月14日 上午11:30:22
 *	TangLi
 */
package health_information.util;

import health_information.standard.WeightScale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author TangLi
 * 2014年10月14日上午11:30:22
 */
public class ValueGenerator
{
	
	/*--------------------------------------generic--------------------------------------*/
	
	/**
	 * @param num
	 * @param scales
	 * @param amendHight 超出最高成绩的允许范围
	 * @param amendLow	  低于最低成绩的允许范围
	 * @return
	 */
	public static List<Integer> generateIntValue(int num,List<Integer> scales,int amendHight,int amendLow)
	{
		///分配，三个成绩等级的个数
		List<Integer> allocation = allocation(num);
		List<Integer> result = new ArrayList<Integer>();
		
		//14.25 80.75  5
		//		2] (2,4] (4,14] (14
		if(scales.get(0)>scales.get(1))
		{
			result.addAll(getRandomIntData(scales.get(2), scales.get(0)+amendHight, allocation.get(1)));
			result.addAll(getRandomIntData(scales.get(14), scales.get(2)-1, allocation.get(0)));
			result.addAll(getRandomIntData(scales.get(19)-amendLow, scales.get(14)-1, allocation.get(2)));
		}
		else
		{
			result.addAll(getRandomIntData(scales.get(0)-amendHight, scales.get(2), allocation.get(1)));
			result.addAll(getRandomIntData(scales.get(2)+1, scales.get(14), allocation.get(0)));
			result.addAll(getRandomIntData(scales.get(14)+1, scales.get(19)+amendLow, allocation.get(2)));
			
		}

		Collections.shuffle(result);
		return result;
	}
	
	/**
	 * @param num
	 * @param scales
	 * @param amendHight 超出最高成绩的允许范围
	 * @param amendLow	  低于最低成绩的允许范围
	 * @return
	 */
	public static List<Double> generateDoubleValue(int num,List<Double> scales,int ratio,double amendHight,double amendLow)
	{
		///分配，三个成绩等级的个数
		List<Integer> allocation = allocation(num);
		List<Double> result = new ArrayList<Double>();
		
		if(scales.get(0)>scales.get(1))
		{
			result.addAll(getRandomDoubleData(scales.get(2), scales.get(0)+amendHight, allocation.get(1),ratio));
			result.addAll(getRandomDoubleData(scales.get(14), scales.get(2)-0.1, allocation.get(0),1));
			result.addAll(getRandomDoubleData(scales.get(19)-amendLow, scales.get(14)-0.1, allocation.get(2),ratio));
		}
		else
		{
			result.addAll(getRandomDoubleData(scales.get(0)-amendHight, scales.get(2), allocation.get(1),ratio));
			result.addAll(getRandomDoubleData(scales.get(2)+0.1, scales.get(14), allocation.get(0),1));
			result.addAll(getRandomDoubleData(scales.get(14)+0.1, scales.get(19)+amendLow, allocation.get(2),ratio));
			
		}
		
		Collections.shuffle(result);
		return result;
	}
	
	
	
	/**
	 * @param min 包含最小值
	 * @param max 包含最大值
	 * @param num 个数
	 * @return
	 */
	public static List<Integer> getRandomIntData(int min,int max,int num)
	{
		List<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		
		int sub = max - min;
		
		for(int i = 0 ; i<num ;i++)
		{
			//差必须要加上1.才可能包含max
			list.add(rand.nextInt(sub+1)+min);
		}
		return list;
	}
	
	/**
	 * @param min
	 * @param max
	 * @param num
	 * @param dotNum 小数点后的位数
	 * @return
	 */
	public static List<Double> getRandomDoubleData(double min,double max,int num,int dotNum)
	{
		List<Double> list = new ArrayList<Double>();
		Random rand = new Random();
		double ratio =  Math.pow(10,dotNum);
		double sub = max - min;
		
		for(int i = 0 ; i<num ;i++)
		{
			//差必须要加上1.才可能包含max
			list.add(new BigDecimal(new Double(rand.nextInt((int)(sub*ratio)+1))/ratio +min).setScale(dotNum,BigDecimal.ROUND_HALF_UP).doubleValue());
		}
		return list;
	}
	
	/**
	 * @param num
	 * @return 依次为：及格，优秀，不及格（按照比例大小排序）
	 */
	public static List<Integer> allocation(int num)
	{
		List<Integer> list = new ArrayList<Integer>();
		
		//14.25 80.75  5
//		2] (2,4] (4,14] (14
		list.add((int)(0.8175*num));//generic
		list.add((int)(0.1428*num)); //good
		list.add((int)(0.04*num));//bad
		int sum = list.get(0) + list.get(1)+list.get(2);
		int leave = num - sum;
		
		for(int i=0;leave>0 ;leave--,i=(i+1)%3)
		{
			list.set(i, list.get(i)+1);
		}
		
		return list;
	}
	
	
	/*--------------------------------------forweightStandard--------------------------------------*/
	
	public static List<Double> generateWeightData(WeightScale ws,int num)
	{
		
		List<Integer> allocation = new ArrayList<Integer>();
		allocation.add((int)(0.85*num)); //正常
		allocation.add((int)(0.07*num));//偏瘦
		allocation.add((int)(0.07*num));//偏胖
		allocation.add((int)(0.01*num));//肥胖
		int sum = allocation.get(0) + allocation.get(1)+allocation.get(2)+allocation.get(3);
		int leave = num - sum;
		for(int i=0;leave>0 ;leave--,i=(i+1)%4)
		{
			allocation.set(i, allocation.get(i)+1);
		}
		
		////// 13.5) [13.5,18.2) [18.20.4) [20.4
		List<Double> result = new ArrayList<Double>();
		List<Double> scales = ws.scaleList;
		double amendHight = 0.6;
		double amendLow = 0.6;
		result.addAll(getRandomDoubleData(scales.get(0)-amendHight, scales.get(0)-0.1, allocation.get(1),1));
		result.addAll(getRandomDoubleData(scales.get(0), scales.get(1)-0.1, allocation.get(0),1));
		result.addAll(getRandomDoubleData(scales.get(1), scales.get(2)-0.1, allocation.get(2),1));
		result.addAll(getRandomDoubleData(scales.get(2), scales.get(2)+amendLow, allocation.get(3),1));
		
		Collections.shuffle(result);
		return result;
		
	}
	
	
	/*--------------------------------------for enduranceStandard--------------------------------------*/
	
	public static List<Integer> generateEnduranceData(List<Integer> scales,int num)
	{
		//14.25 80.75  5
		//		2] (2,4] (4,14] (14
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> allocation = allocation(num);
		int amendHight  = 10;
		int amendLow  = 10;
		
		result.addAll(getRandomTimeData(scales.get(0)-amendHight, scales.get(2), allocation.get(1)));
		result.addAll(getRandomTimeData(scales.get(2)+1, scales.get(14), allocation.get(0)));
		result.addAll(getRandomTimeData(scales.get(14)+1, scales.get(19)+amendLow, allocation.get(2)));
		Collections.shuffle(result);
		return result;
		
	}
	
	public static int convertMinuteToSecond(int time)
	{
		return (time/100)*60 + (time%100);
	}
	
	public static int convertSecondToMinute(int time)
	{
		return (time/60)*100 + (time%60);
	}
	
	/**
	 * @param min 包含最小值
	 * @param max 包含最大值
	 * @param num 个数
	 * @return
	 */
	public static List<Integer> getRandomTimeData(int min,int max,int num)
	{
		List<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		
		int maxs = convertMinuteToSecond(max);
		int mins = convertMinuteToSecond(min);
		
		int sub = maxs - mins;
		
		for(int i = 0 ; i<num ;i++)
		{
			//差必须要加上1.才可能包含max
			list.add(convertSecondToMinute(rand.nextInt(sub+1)+mins));
		}
		return list;
	}
	
	
	
	public static void main(String[] arsg)
	{
		
//		allocation(97);
//		allocation(98);
//		allocation(99);
//		allocation(100);
//		allocation(101);
//		allocation(102);
//		allocation(103);
//		allocation(104);
//		allocation(105);
//		System.out.println(Math.pow(10, 2));
//		System.out.println(getRandomIntData(0, 10, 100));
//		System.out.println(getRandomDoubleData(0.1, 1.0, 100,1));
//		
//		System.out.println(getRandomIntData(-10, 10, 100));
//		System.out.println(getRandomDoubleData(-0.5, 0.5, 100,1));
//		System.out.println(getRandomDoubleData(13.8, 16.7, 100,1));
		
//		System.out.println(generateIntValue(100,VitalCapacityStandard.scaleMap.get(Standard.GRADE1).get(Standard.FEMALE),100,100));
//		System.out.println(generateIntValue(100,SitupStandard.scaleMap.get(Standard.GRADE5).get(Standard.MALE),3,3));
//		System.out.println(generateIntValue(100,SkipStandard.scaleMap.get(Standard.GRADE5).get(Standard.MALE),40,1));
		
//		System.out.println(generateDoubleValue(100,SitBendStandard.scaleMap.get(Standard.GRADE5).get(Standard.MALE),1,0.2,0.2));
//		System.out.println(generateDoubleValue(100,Run50Standard.scaleMap.get(Standard.GRADE5).get(Standard.MALE),1,0.1,0.2));
		
//		System.out.println(getWeightData(WeightStandard.scaleMap.get(Standard.GRADE1).get(Standard.MALE),100));
//		System.out.println(generateEnduranceData(EnduranceStandard.scaleMap.get(Standard.GRADE5).get(Standard.MALE),100));
	}
	
	
	
}
























