/**
 *	2014年10月14日 上午11:30:22
 *	TangLi
 */
package health_information.util;

import health_information.standard.EnduranceStandard;
import health_information.standard.Run50Standard;
import health_information.standard.SitBendStandard;
import health_information.standard.SitupStandard;
import health_information.standard.SkipStandard;
import health_information.standard.Standard;
import health_information.standard.VitalCapacityStandard;
import health_information.standard.WeightStandard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author TangLi
 * 2014年10月14日上午11:30:22
 */
public class ValueGenerator
{
	public List<Integer> randomInt(String grade,String sex,int num,int indicatorType)
	{
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> scales;
		switch(indicatorType)
		{
		case Standard.TYPE_ENDURANCE:
			scales = EnduranceStandard.scaleMap.get(grade).get(sex);
			break;
		case Standard.TYPE_SITUP:
			scales = SitupStandard.scaleMap.get(grade).get(sex);
			break;
		case Standard.TYPE_SKIP :
			scales = SkipStandard.scaleMap.get(grade).get(sex);
			break;
		case Standard.TYPE_VITALCAPACITY:
			scales = VitalCapacityStandard.scaleMap.get(grade).get(sex);
			break;
//		case Standard.TYPE_WEIGHT:
//			scaleMap = WeightStandard.scaleMap;
//			break;
		}
		
		List<Integer> allocation = allocation(num);
		
		Random rand = new Random();
		for(int i= 0 ;i <allocation.get(0);i++)
		{
			result.add(rand.nextInt();)
		}
		
		rand.nextInt();
		rand.nextInt();
		rand.nextInt();
		
		return null;
	}
	
	
	public static List<Integer> allocation(int num)
	{
		List<Integer> list = new ArrayList<Integer>();
		
		//14.25 80.75  5
//		2] (2,4] (4,14] (14
		list.add((int)(0.1428*num)); //good
		list.add((int)(0.8175*num));//generic
		list.add((int)(0.04*num));//bad
		int sum = list.get(0) + list.get(1)+list.get(2);
		int leave = num - sum;
		
		for(int i=0;leave>0 ;leave--,i=(i+1)%3)
		{
			list.set(i, list.get(i)+1);
		}
		
		return list;
	}
	
	
	public List<Double> randomDouble(String grade,String sex,int num,int indicatorType)
	{
		Map<String,Map<String,List<Double>>> scaleMap;
		switch(indicatorType)
		{
		case Standard.TYPE_RUN50 :
			scaleMap = Run50Standard.scaleMap;
			break;
		case Standard.TYPE_SITBEND:
			scaleMap = SitBendStandard.scaleMap;
			break;
		}
		
//		2] (2,4] (4,14] (14
		
		return null;
	}
	
	
	
	public static void main(String[] arsg)
	{
		
		List<Integer> list = new ArrayList<Integer>();
		
		Random rand = new Random();
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
			
		
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		
		
		allocation(97);
		allocation(98);
		allocation(99);
		allocation(100);
		allocation(101);
		allocation(102);
		allocation(103);
		allocation(104);
		allocation(105);
	}
}
























