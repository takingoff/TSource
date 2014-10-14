/**
 *	2014年10月14日 上午9:54:49
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
 * 2014年10月14日上午9:54:49
 */
public class SitBendStandard
{
public static Map<String,Map<String,List<Double>>> scaleMap = new HashMap<String,Map<String,List<Double>>>();
	
	static
	{
		Map<String,List<Double>> map = new HashMap<String,List<Double>>();
		
		 List<Double> g1 = new ArrayList<Double>();
		 List<Double> g2 = new ArrayList<Double>();
		 List<Double> g3 = new ArrayList<Double>();
		 List<Double> g4 = new ArrayList<Double>();
		 List<Double> g5 = new ArrayList<Double>();
		 List<Double> g6 = new ArrayList<Double>();
		 
		 List<Double> f1 = new ArrayList<Double>();
		 List<Double> f2 = new ArrayList<Double>();
		 List<Double> f3 = new ArrayList<Double>();
		 List<Double> f4 = new ArrayList<Double>();
		 List<Double> f5 = new ArrayList<Double>();
		 List<Double> f6 = new ArrayList<Double>();
		
		
		g1.add(16.1);	g2.add(16.2);	g3.add(16.3);	g4.add(16.4);	g5.add(16.5);	g6.add(16.6);
		g1.add(14.6);	g2.add(14.7);	g3.add(14.9);	g4.add(15.0);	g5.add(15.2);	g6.add(15.3);
		g1.add(13.0);	g2.add(13.2);	g3.add(13.4);	g4.add(13.6);	g5.add(13.8);	g6.add(14.0);
		g1.add(12.0);	g2.add(11.9);	g3.add(11.8);	g4.add(11.7);	g5.add(11.6);	g6.add(11.5);
		g1.add(11.0);	g2.add(10.6);	g3.add(10.2);	g4.add(9.8 );	g5.add(9.4 );	g6.add(9.0 );
		g1.add(9.9 );	g2.add(9.5 );	g3.add(9.1 );	g4.add(8.6 );	g5.add(8.2 );	g6.add(7.7 );
		g1.add(8.8 );	g2.add(8.4 );	g3.add(8.0 );	g4.add(7.4 );	g5.add(7.0 );	g6.add(6.4 );
		g1.add(7.7 );	g2.add(7.3 );	g3.add(6.9 );	g4.add(6.2 );	g5.add(5.8 );	g6.add(5.1 );
		g1.add(6.6 );	g2.add(6.2 );	g3.add(5.8 );	g4.add(5.0 );	g5.add(4.6 );	g6.add(3.8 );
		g1.add(5.5 );	g2.add(5.1 );	g3.add(4.7 );	g4.add(3.8 );	g5.add(3.4 );	g6.add(2.5 );
		g1.add(4.4 );	g2.add(4.0 );	g3.add(3.6 );	g4.add(2.6 );	g5.add(2.2 );	g6.add(1.2 );
		g1.add(3.3 );	g2.add(2.9 );	g3.add(2.5 );	g4.add(1.4 );	g5.add(1.0 );	g6.add(-0.1);
		g1.add(2.2 );	g2.add(1.8 );	g3.add(1.4 );	g4.add(0.2 );	g5.add(-0.2);	g6.add(-1.4);
		g1.add(1.1 );	g2.add(0.7 );	g3.add(0.3 );	g4.add(-1.0);	g5.add(-1.4);	g6.add(-2.7);
		g1.add(0.0 );	g2.add(-0.4);	g3.add(-0.8);	g4.add(-2.2);	g5.add(-2.6);	g6.add(-4.0);
		g1.add(-0.8);	g2.add(-1.2);	g3.add(-1.6);	g4.add(-3.2);	g5.add(-3.6);	g6.add(-5.0);
		g1.add(-1.6);	g2.add(-2.0);	g3.add(-2.4);	g4.add(-4.2);	g5.add(-4.6);	g6.add(-6.0);
		g1.add(-2.4);	g2.add(-2.8);	g3.add(-3.2);	g4.add(-5.2);	g5.add(-5.6);	g6.add(-7.0);
		g1.add(-3.2);	g2.add(-3.6);	g3.add(-4.0);	g4.add(-6.2);	g5.add(-6.6);	g6.add(-8.0);
		g1.add(-4.0);	g2.add(-4.4);	g3.add(-4.8);	g4.add(-7.2);	g5.add(-7.6);	g6.add(-9.0);
		
		
		f1.add(18.6);	f2.add(18.9);	f3.add(19.2);	f4.add(19.5);	f5.add(19.8);	f6.add(19.9);
		f1.add(17.3);	f2.add(17.6);	f3.add(17.9);	f4.add(18.1);	f5.add(18.5);	f6.add(18.7);
		f1.add(16.0);	f2.add(16.3);	f3.add(16.6);	f4.add(16.9);	f5.add(17.2);	f6.add(17.5);
		f1.add(14.7);	f2.add(14.8);	f3.add(14.9);	f4.add(15.0);	f5.add(15.1);	f6.add(15.2);
		f1.add(13.4);	f2.add(13.3);	f3.add(13.2);	f4.add(13.1);	f5.add(13.0);	f6.add(12.9);
		f1.add(12.3);	f2.add(12.2);	f3.add(12.1);	f4.add(12.0);	f5.add(11.9);	f6.add(11.8);
		f1.add(11.2);	f2.add(11.1);	f3.add(11.0);	f4.add(10.9);	f5.add(10.8);	f6.add(10.7);
		f1.add(10.1);	f2.add(10.0);	f3.add(9.9 );	f4.add(9.8 );	f5.add(9.7 );	f6.add(9.6 );
		f1.add(9.0 );	f2.add(8.9 );	f3.add(8.8 );	f4.add(8.7 );	f5.add(8.6 );	f6.add(8.5 );
		f1.add(7.9 );	f2.add(7.8 );	f3.add(7.7 );	f4.add(7.6 );	f5.add(7.5 );	f6.add(7.4 );
		f1.add(6.8 );	f2.add(6.7 );	f3.add(6.6 );	f4.add(6.5 );	f5.add(6.4 );	f6.add(6.3 );
		f1.add(5.7 );	f2.add(5.6 );	f3.add(5.5 );	f4.add(5.4 );	f5.add(5.3 );	f6.add(5.2 );
		f1.add(4.6 );	f2.add(4.5 );	f3.add(4.4 );	f4.add(4.3 );	f5.add(4.2 );	f6.add(4.1 );
		f1.add(3.5 );	f2.add(3.4 );	f3.add(3.3 );	f4.add(3.2 );	f5.add(3.1 );	f6.add(3.0 );
		f1.add(2.4 );	f2.add(2.3 );	f3.add(2.2 );	f4.add(2.1 );	f5.add(2.0 );	f6.add(1.9 );
		f1.add(1.6 );	f2.add(1.5 );	f3.add(1.4 );	f4.add(1.3 );	f5.add(1.2 );	f6.add(1.1 );
		f1.add(0.8 );	f2.add(0.7 );	f3.add(0.6 );	f4.add(0.5 );	f5.add(0.4 );	f6.add(0.3 );
		f1.add(0.0 );	f2.add(-0.1);	f3.add(-0.2);	f4.add(-0.3);	f5.add(-0.4);	f6.add(-0.5);
		f1.add(-0.8);	f2.add(-0.9);	f3.add(-1.0);	f4.add(-1.1);	f5.add(-1.2);	f6.add(-1.3);
		f1.add(-1.6);	f2.add(-1.7);	f3.add(-1.8);	f4.add(-1.9);	f5.add(-2.0);	f6.add(-2.1);
		
		
		
		
		map.put(Standard.MALE, g1);
		map.put(Standard.FEMALE, f1);
		scaleMap.put(Standard.GRADE1, map);
		
		map = new HashMap<String,List<Double>>();
		map.put(Standard.MALE, g2);
		map.put(Standard.FEMALE, f2);
		scaleMap.put(Standard.GRADE2, map);
		
		map = new HashMap<String,List<Double>>();
		map.put(Standard.MALE, g3);
		map.put(Standard.FEMALE, f3);
		scaleMap.put(Standard.GRADE3, map);
		
		map = new HashMap<String,List<Double>>();
		map.put(Standard.MALE, g4);
		map.put(Standard.FEMALE,f4);
		scaleMap.put(Standard.GRADE4, map);
		
		map = new HashMap<String,List<Double>>();
		map.put(Standard.MALE, g5);
		map.put(Standard.FEMALE,f5);
		scaleMap.put(Standard.GRADE5, map);
		
		map = new HashMap<String,List<Double>>();
		map.put(Standard.MALE, g6);
		map.put(Standard.FEMALE, f6);
		scaleMap.put(Standard.GRADE6, map);
		
	}
	
	public static int getRegion(Double value, String grade, String sex)
	{
		int index =0;
		for(Double scale:scaleMap.get(grade).get(sex))
		{
			if(value>=scale)
				break;
			else
				index++;
		}
		return index;
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
