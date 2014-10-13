/**
 *	2014年10月13日 下午4:11:59
 *	TangLi
 */
package health_information.standard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TangLi
 * 2014年10月13日下午4:11:59
 */
public class WeightScale
{
	//	13.5) [13.5,18.2) [18.2,20.4)[20.4
	public List<Double> scaleList = new ArrayList<Double>();
	
	public WeightScale(double scale1,double scale2,double scale3)
	{
		scaleList.add(scale1);
		scaleList.add(scale2);
		scaleList.add(scale3);
	}
	
	static public final List<Integer> scoreList = new ArrayList<Integer>();
	static
	{
		scoreList.add(80);
		scoreList.add(100);
		scoreList.add(80);
		scoreList.add(60);
	}
	
	static public final List<String> level = new ArrayList<String>();
	static
	{
		level.add("低体重");
		level.add("正常体重");
		level.add("超重");
		level.add("肥胖");
	}
	
	static public int scaleRegion(WeightScale wh,Double weight)
	{
		
		int region = 0;
		for(Double scaleMax:wh.scaleList)
		{
			if(weight < scaleMax)
				break;
			else
				region ++;
		}
		return region;
	}
	
	
}
