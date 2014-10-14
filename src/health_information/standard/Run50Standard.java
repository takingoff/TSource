/**
 *	2014年10月14日 上午9:26:38
 *	TangLi
 */
package health_information.standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TangLi
 * 2014年10月14日上午9:26:38
 */
public class Run50Standard
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
		
		
		g1.add(10.2);	g2.add(9.6 );	g3.add(9.1 );	g4.add(8.7 );	g5.add(8.4 );	g6.add(8.2 );
		g1.add(10.3);	g2.add(9.7 );	g3.add(9.2 );	g4.add(8.8 );	g5.add(8.5 );	g6.add(8.3 );
		g1.add(10.4);	g2.add(9.8 );	g3.add(9.3 );	g4.add(8.9 );	g5.add(8.6 );	g6.add(8.4 );
		g1.add(10.5);	g2.add(9.9 );	g3.add(9.4 );	g4.add(9.0 );	g5.add(8.7 );	g6.add(8.5 );
		g1.add(10.6);	g2.add(10.0);	g3.add(9.5 );	g4.add(9.1 );	g5.add(8.8 );	g6.add(8.6 );
		g1.add(10.8);	g2.add(10.2);	g3.add(9.7 );	g4.add(9.3 );	g5.add(9.0 );	g6.add(8.8 );
		g1.add(11.0);	g2.add(10.4);	g3.add(9.9 );	g4.add(9.5 );	g5.add(9.2 );	g6.add(9.0 );
		g1.add(11.2);	g2.add(10.6);	g3.add(10.1);	g4.add(9.7 );	g5.add(9.4 );	g6.add(9.2 );
		g1.add(11.4);	g2.add(10.8);	g3.add(10.3);	g4.add(9.9 );	g5.add(9.6 );	g6.add(9.4 );
		g1.add(11.6);	g2.add(11.0);	g3.add(10.5);	g4.add(10.1);	g5.add(9.8 );	g6.add(9.6 );
		g1.add(11.8);	g2.add(11.2);	g3.add(10.7);	g4.add(10.3);	g5.add(10.0);	g6.add(9.8 );
		g1.add(12.0);	g2.add(11.4);	g3.add(10.9);	g4.add(10.5);	g5.add(10.2);	g6.add(10.0);
		g1.add(12.2);	g2.add(11.6);	g3.add(11.1);	g4.add(10.7);	g5.add(10.4);	g6.add(10.2);
		g1.add(12.4);	g2.add(11.8);	g3.add(11.3);	g4.add(10.9);	g5.add(10.6);	g6.add(10.4);
		g1.add(12.6);	g2.add(12.0);	g3.add(11.5);	g4.add(11.1);	g5.add(10.8);	g6.add(10.6);
		g1.add(12.8);	g2.add(12.2);	g3.add(11.7);	g4.add(11.3);	g5.add(11.0);	g6.add(10.8);
		g1.add(13.0);	g2.add(12.4);	g3.add(11.9);	g4.add(11.5);	g5.add(11.2);	g6.add(11.0);
		g1.add(13.2);	g2.add(12.6);	g3.add(12.1);	g4.add(11.7);	g5.add(11.4);	g6.add(11.2);
		g1.add(13.4);	g2.add(12.8);	g3.add(12.3);	g4.add(11.9);	g5.add(11.6);	g6.add(11.4);
		g1.add(13.6);	g2.add(13.0);	g3.add(12.5);	g4.add(12.1);	g5.add(11.8);	g6.add(11.6);
		
		
		f1.add(11.0);	f2.add(10.0);	f3.add(9.2 );	f4.add(8.7 );	f5.add(8.3 );	f6.add(8.2 );
		f1.add(11.1);	f2.add(10.1);	f3.add(9.3 );	f4.add(8.8 );	f5.add(8.4 );	f6.add(8.3 );
		f1.add(11.2);	f2.add(10.2);	f3.add(9.4 );	f4.add(8.9 );	f5.add(8.5 );	f6.add(8.4 );
		f1.add(11.5);	f2.add(10.5);	f3.add(9.7 );	f4.add(9.2 );	f5.add(8.8 );	f6.add(8.7 );
		f1.add(11.8);	f2.add(10.8);	f3.add(10.0);	f4.add(9.5 );	f5.add(9.1 );	f6.add(9.0 );
		f1.add(12.0);	f2.add(11.0);	f3.add(10.2);	f4.add(9.7 );	f5.add(9.3 );	f6.add(9.2 );
		f1.add(12.2);	f2.add(11.2);	f3.add(10.4);	f4.add(9.9 );	f5.add(9.5 );	f6.add(9.4 );
		f1.add(12.4);	f2.add(11.4);	f3.add(10.6);	f4.add(10.1);	f5.add(9.7 );	f6.add(9.6 );
		f1.add(12.6);	f2.add(11.6);	f3.add(10.8);	f4.add(10.3);	f5.add(9.9 );	f6.add(9.8 );
		f1.add(12.8);	f2.add(11.8);	f3.add(11.0);	f4.add(10.5);	f5.add(10.1);	f6.add(10.0);
		f1.add(13.0);	f2.add(12.0);	f3.add(11.2);	f4.add(10.7);	f5.add(10.3);	f6.add(10.2);
		f1.add(13.2);	f2.add(12.2);	f3.add(11.4);	f4.add(10.9);	f5.add(10.5);	f6.add(10.4);
		f1.add(13.4);	f2.add(12.4);	f3.add(11.6);	f4.add(11.1);	f5.add(10.7);	f6.add(10.6);
		f1.add(13.6);	f2.add(12.6);	f3.add(11.8);	f4.add(11.3);	f5.add(10.9);	f6.add(10.8);
		f1.add(13.8);	f2.add(12.8);	f3.add(12.0);	f4.add(11.5);	f5.add(11.1);	f6.add(11.0);
		f1.add(14.0);	f2.add(13.0);	f3.add(12.2);	f4.add(11.7);	f5.add(11.3);	f6.add(11.2);
		f1.add(14.2);	f2.add(13.2);	f3.add(12.4);	f4.add(11.9);	f5.add(11.5);	f6.add(11.4);
		f1.add(14.4);	f2.add(13.4);	f3.add(12.6);	f4.add(12.1);	f5.add(11.7);	f6.add(11.6);
		f1.add(14.6);	f2.add(13.6);	f3.add(12.8);	f4.add(12.3);	f5.add(11.9);	f6.add(11.8);
		f1.add(14.8);	f2.add(13.8);	f3.add(13.0);	f4.add(12.5);	f5.add(12.1);	f6.add(12.0);
		
		
		
		
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
			if(value<=scale)
				break;
			else
				index++;
		}
		return index;
	}
}
