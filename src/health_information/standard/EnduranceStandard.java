/**
 *	2014年10月14日 上午10:15:34
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
 * 2014年10月14日上午10:15:34
 */
public class EnduranceStandard
{
public static Map<String,Map<String,List<Integer>>> scaleMap = new HashMap<String,Map<String,List<Integer>>>();
	
	static
	{
		Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
		
		 List<Integer> g5 = new ArrayList<Integer>();
		 List<Integer> g6 = new ArrayList<Integer>();
		 
		 List<Integer> f5 = new ArrayList<Integer>();
		 List<Integer> f6 = new ArrayList<Integer>();
		
		
		g5.add(136);	g6.add(130);
		g5.add(139);	g6.add(133);
		g5.add(142);	g6.add(136);
		g5.add(145);	g6.add(139);
		g5.add(148);	g6.add(142);
		g5.add(151);	g6.add(145);
		g5.add(154);	g6.add(148);
		g5.add(157);	g6.add(151);
		g5.add(200);	g6.add(154);
		g5.add(203);	g6.add(157);
		g5.add(206);	g6.add(200);
		g5.add(209);	g6.add(203);
		g5.add(212);	g6.add(206);
		g5.add(215);	g6.add(209);
		g5.add(218);	g6.add(212);
		g5.add(222);	g6.add(216);
		g5.add(226);	g6.add(220);
		g5.add(230);	g6.add(224);
		g5.add(234);	g6.add(228);
		g5.add(238);	g6.add(232);
		
		
		f5.add(141);	f6.add(137);
		f5.add(144);	f6.add(140);
		f5.add(147);	f6.add(143);
		f5.add(150);	f6.add(146);
		f5.add(153);	f6.add(149);
		f5.add(156);	f6.add(152);
		f5.add(159);	f6.add(155);
		f5.add(202);	f6.add(158);
		f5.add(205);	f6.add(201);
		f5.add(208);	f6.add(204);
		f5.add(211);	f6.add(207);
		f5.add(214);	f6.add(210);
		f5.add(217);	f6.add(213);
		f5.add(220);	f6.add(216);
		f5.add(223);	f6.add(219);
		f5.add(227);	f6.add(223);
		f5.add(231);	f6.add(227);
		f5.add(235);	f6.add(231);
		f5.add(239);	f6.add(235);
		f5.add(243);	f6.add(239);
		
		
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
			if(value<=scale)
				break;
			else
				index++;
		}
		return index;
	}
	
	public static SingleIndicator judge(int value,String grade ,String sex)
	{
		SingleIndicator si = new SingleIndicator();
		
		int index = getRegion(value,grade,sex);
		si.valueInt = value; 
		si.level = Standard.getLevel(index);
		si.score = Standard.getScore(index);
		
		return si;
		
	}
	
	
	
	
	
}
