/**
 *	2014年10月13日 下午4:11:59
 *	TangLi
 */
package health_information.standard;

import java.util.LinkedList;
import java.util.List;

/**
 * @author TangLi
 * 2014年10月13日下午4:11:59
 */
public class WeightScale
{
	public List<Double> scaleList = new LinkedList<Double>();
	public Double height ;
	public Double weight;
	
	public WeightScale(double height,double scale1,double scale2,double scale3,double scale4)
	{
		this.height = height;
		scaleList.add(scale1);
		scaleList.add(scale2);
		scaleList.add(scale3);
		scaleList.add(scale4);
	}
	
	static public final List<Integer> scoreList = new LinkedList<Integer>();
	static
	{
		scoreList.add(50);
		scoreList.add(60);
		scoreList.add(100);
		scoreList.add(60);
		scoreList.add(50);
	}
	
	static public final List<String> level = new LinkedList<String>();
	static
	{
		level.add("营养不良");
		level.add("较低体重");
		level.add("正常体重");
		level.add("超  重");
		level.add("肥胖");
	}
	
	static public int scaleRegion(WeightScale wh)
	{
		//14.8)	[14.8,16.9)	[16.9,19.2)	[19.2,19.9)	[19.9	
		
		int region = 0;
		for(Double scaleMax:wh.scaleList)
		{
			if(wh.weight < scaleMax)
				break;
			else
				region ++;
		}
		
		return region;
		
	}
	
	
	
	
	
}
