/**
 *	2014年10月14日 上午10:09:28
 *	TangLi
 */
package health_information.standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TangLi
 * 2014年10月14日上午10:09:28
 */
public class SitupStandard
{
public static Map<String,Map<String,List<Integer>>> scaleMap = new HashMap<String,Map<String,List<Integer>>>();
	
	static
	{
		Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
		
		 List<Integer> g3 = new ArrayList<Integer>();
		 List<Integer> g4 = new ArrayList<Integer>();
		 List<Integer> g5 = new ArrayList<Integer>();
		 List<Integer> g6 = new ArrayList<Integer>();
		 
		 List<Integer> f3 = new ArrayList<Integer>();
		 List<Integer> f4 = new ArrayList<Integer>();
		 List<Integer> f5 = new ArrayList<Integer>();
		 List<Integer> f6 = new ArrayList<Integer>();
		
		
		g3.add(48);	g4.add(49);	g5.add(50);	g6.add(51);
		g3.add(45);	g4.add(46);	g5.add(47);	g6.add(48);
		g3.add(42);	g4.add(43);	g5.add(44);	g6.add(45);
		g3.add(39);	g4.add(40);	g5.add(41);	g6.add(42);
		g3.add(36);	g4.add(37);	g5.add(38);	g6.add(39);
		g3.add(34);	g4.add(35);	g5.add(36);	g6.add(37);
		g3.add(32);	g4.add(33);	g5.add(34);	g6.add(35);
		g3.add(30);	g4.add(31);	g5.add(32);	g6.add(33);
		g3.add(28);	g4.add(29);	g5.add(30);	g6.add(31);
		g3.add(26);	g4.add(27);	g5.add(28);	g6.add(29);
		g3.add(24);	g4.add(25);	g5.add(26);	g6.add(27);
		g3.add(22);	g4.add(23);	g5.add(24);	g6.add(25);
		g3.add(20);	g4.add(21);	g5.add(22);	g6.add(23);
		g3.add(18);	g4.add(19);	g5.add(20);	g6.add(21);
		g3.add(16);	g4.add(17);	g5.add(18);	g6.add(19);
		g3.add(14);	g4.add(15);	g5.add(16);	g6.add(17);
		g3.add(12);	g4.add(13);	g5.add(14);	g6.add(15);
		g3.add(10);	g4.add(11);	g5.add(12);	g6.add(13);
		g3.add(8 );	g4.add(9 );	g5.add(10);	g6.add(11);
		g3.add(6 );	g4.add(7 );	g5.add(8 );	g6.add(9 );
		
		
		f3.add(46);	f4.add(47);	f5.add(48);	f6.add(49);
		f3.add(44);	f4.add(45);	f5.add(46);	f6.add(47);
		f3.add(42);	f4.add(43);	f5.add(44);	f6.add(45);
		f3.add(39);	f4.add(40);	f5.add(41);	f6.add(42);
		f3.add(36);	f4.add(37);	f5.add(38);	f6.add(39);
		f3.add(34);	f4.add(35);	f5.add(36);	f6.add(37);
		f3.add(32);	f4.add(33);	f5.add(34);	f6.add(35);
		f3.add(30);	f4.add(31);	f5.add(32);	f6.add(33);
		f3.add(28);	f4.add(29);	f5.add(30);	f6.add(31);
		f3.add(26);	f4.add(27);	f5.add(28);	f6.add(29);
		f3.add(24);	f4.add(25);	f5.add(26);	f6.add(27);
		f3.add(22);	f4.add(23);	f5.add(24);	f6.add(25);
		f3.add(20);	f4.add(21);	f5.add(22);	f6.add(23);
		f3.add(18);	f4.add(19);	f5.add(20);	f6.add(21);
		f3.add(16);	f4.add(17);	f5.add(18);	f6.add(19);
		f3.add(14);	f4.add(15);	f5.add(16);	f6.add(17);
		f3.add(12);	f4.add(13);	f5.add(14);	f6.add(15);
		f3.add(10);	f4.add(11);	f5.add(12);	f6.add(13);
		f3.add(8 );	f4.add(9 );	f5.add(10);	f6.add(11);
		f3.add(6 );	f4.add(7 );	f5.add(8 );	f6.add(9 );
		
		
	
		
		map = new HashMap<String,List<Integer>>();
		map.put(Standard.MALE, g3);
		map.put(Standard.FEMALE, f3);
		scaleMap.put(Standard.GRADE3, map);
		
		map = new HashMap<String,List<Integer>>();
		map.put(Standard.MALE, g4);
		map.put(Standard.FEMALE,f4);
		scaleMap.put(Standard.GRADE4, map);
		
		map = new HashMap<String,List<Integer>>();
		map.put(Standard.MALE, g5);
		map.put(Standard.FEMALE,f5);
		scaleMap.put(Standard.GRADE5, map);
		
		map = new HashMap<String,List<Integer>>();
		map.put(Standard.MALE, g6);
		map.put(Standard.FEMALE, f6);
		scaleMap.put(Standard.GRADE6, map);
		
	}
	
	public static int getRegion(int value, String grade, String sex)
	{
		int index =0;
		for(int scale:scaleMap.get(grade).get(sex))
		{
			if(value>=scale)
				break;
			else
				index++;
		}
		return index;
	}

}
