/**
 *	2014年10月14日 上午10:02:58
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
 * 2014年10月14日上午10:02:58
 */
public class SkipStandard
{
public static Map<String,Map<String,List<Integer>>> scaleMap = new HashMap<String,Map<String,List<Integer>>>();
	
	static
	{
		Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
		
		 List<Integer> g1 = new ArrayList<Integer>();
		 List<Integer> g2 = new ArrayList<Integer>();
		 List<Integer> g3 = new ArrayList<Integer>();
		 List<Integer> g4 = new ArrayList<Integer>();
		 List<Integer> g5 = new ArrayList<Integer>();
		 List<Integer> g6 = new ArrayList<Integer>();
		 
		 List<Integer> f1 = new ArrayList<Integer>();
		 List<Integer> f2 = new ArrayList<Integer>();
		 List<Integer> f3 = new ArrayList<Integer>();
		 List<Integer> f4 = new ArrayList<Integer>();
		 List<Integer> f5 = new ArrayList<Integer>();
		 List<Integer> f6 = new ArrayList<Integer>();
		
		
		g1.add(109);	g2.add(117);	g3.add(126);	g4.add(137);	g5.add(148);	g6.add(157);
		g1.add(104);	g2.add(112);	g3.add(121);	g4.add(132);	g5.add(143);	g6.add(152);
		g1.add(99 );	g2.add(107);	g3.add(116);	g4.add(127);	g5.add(138);	g6.add(147);
		g1.add(93 );	g2.add(101);	g3.add(110);	g4.add(121);	g5.add(132);	g6.add(141);
		g1.add(87 );	g2.add(95 );	g3.add(104);	g4.add(115);	g5.add(126);	g6.add(135);
		g1.add(80 );	g2.add(88 );	g3.add(97 );	g4.add(108);	g5.add(119);	g6.add(128);
		g1.add(73 );	g2.add(81 );	g3.add(90 );	g4.add(101);	g5.add(112);	g6.add(121);
		g1.add(66 );	g2.add(74 );	g3.add(83 );	g4.add(94 );	g5.add(105);	g6.add(114);
		g1.add(59 );	g2.add(67 );	g3.add(76 );	g4.add(87 );	g5.add(98 );	g6.add(107);
		g1.add(52 );	g2.add(60 );	g3.add(69 );	g4.add(80 );	g5.add(91 );	g6.add(100);
		g1.add(45 );	g2.add(53 );	g3.add(62 );	g4.add(73 );	g5.add(84 );	g6.add(93 );
		g1.add(38 );	g2.add(46 );	g3.add(55 );	g4.add(66 );	g5.add(77 );	g6.add(86 );
		g1.add(31 );	g2.add(39 );	g3.add(48 );	g4.add(59 );	g5.add(70 );	g6.add(79 );
		g1.add(24 );	g2.add(32 );	g3.add(41 );	g4.add(52 );	g5.add(63 );	g6.add(72 );
		g1.add(17 );	g2.add(25 );	g3.add(34 );	g4.add(45 );	g5.add(56 );	g6.add(65 );
		g1.add(14 );	g2.add(22 );	g3.add(31 );	g4.add(42 );	g5.add(53 );	g6.add(62 );
		g1.add(11 );	g2.add(19 );	g3.add(28 );	g4.add(39 );	g5.add(50 );	g6.add(59 );
		g1.add(8  );	g2.add(16 );	g3.add(25 );	g4.add(36 );	g5.add(47 );	g6.add(56 );
		g1.add(5  );	g2.add(13 );	g3.add(22 );	g4.add(33 );	g5.add(44 );	g6.add(53 );
		g1.add(2  );	g2.add(10 );	g3.add(19 );	g4.add(30 );	g5.add(41 );	g6.add(50 );
		
		
		f1.add(117);	f2.add(127);	f3.add(139);	f4.add(149);	f5.add(158);	f6.add(166);
		f1.add(110);	f2.add(120);	f3.add(132);	f4.add(142);	f5.add(151);	f6.add(159);
		f1.add(103);	f2.add(113);	f3.add(125);	f4.add(135);	f5.add(144);	f6.add(152);
		f1.add(95 );	f2.add(105);	f3.add(117);	f4.add(127);	f5.add(136);	f6.add(144);
		f1.add(87 );	f2.add(97 );	f3.add(109);	f4.add(119);	f5.add(128);	f6.add(136);
		f1.add(80 );	f2.add(90 );	f3.add(102);	f4.add(112);	f5.add(121);	f6.add(129);
		f1.add(73 );	f2.add(83 );	f3.add(95 );	f4.add(105);	f5.add(114);	f6.add(122);
		f1.add(66 );	f2.add(76 );	f3.add(88 );	f4.add(98 );	f5.add(107);	f6.add(115);
		f1.add(59 );	f2.add(69 );	f3.add(81 );	f4.add(91 );	f5.add(100);	f6.add(108);
		f1.add(52 );	f2.add(62 );	f3.add(74 );	f4.add(84 );	f5.add(93 );	f6.add(101);
		f1.add(45 );	f2.add(55 );	f3.add(67 );	f4.add(77 );	f5.add(86 );	f6.add(94 );
		f1.add(38 );	f2.add(48 );	f3.add(60 );	f4.add(70 );	f5.add(79 );	f6.add(87 );
		f1.add(31 );	f2.add(41 );	f3.add(53 );	f4.add(63 );	f5.add(72 );	f6.add(80 );
		f1.add(24 );	f2.add(34 );	f3.add(46 );	f4.add(56 );	f5.add(65 );	f6.add(73 );
		f1.add(17 );	f2.add(27 );	f3.add(39 );	f4.add(49 );	f5.add(58 );	f6.add(66 );
		f1.add(14 );	f2.add(24 );	f3.add(36 );	f4.add(46 );	f5.add(55 );	f6.add(63 );
		f1.add(11 );	f2.add(21 );	f3.add(33 );	f4.add(43 );	f5.add(52 );	f6.add(60 );
		f1.add(8  );	f2.add(18 );	f3.add(30 );	f4.add(40 );	f5.add(49 );	f6.add(57 );
		f1.add(5  );	f2.add(15 );	f3.add(27 );	f4.add(37 );	f5.add(46 );	f6.add(54 );
		f1.add(2  );	f2.add(12 );	f3.add(24 );	f4.add(34 );	f5.add(43 );	f6.add(51 );
		
		
		
		
		map.put(Standard.MALE, g1);
		map.put(Standard.FEMALE, f1);
		scaleMap.put(Standard.GRADE1, map);
		
		map = new HashMap<String,List<Integer>>();
		map.put(Standard.MALE, g2);
		map.put(Standard.FEMALE, f2);
		scaleMap.put(Standard.GRADE2, map);
		
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
	
	public static int getExtra(int value, String grade, String sex)
	{
		int score =0;
		int more = value - scaleMap.get(grade).get(sex).get(0);
		if(more>40)
			score = 20;
		else if(more>0)
			score = more/2;
		return score;
	}
	
	public static SingleIndicator judge(int value,String grade ,String sex)
	{
		SingleIndicator si = new SingleIndicator();
		
		int index = getRegion(value,grade,sex);
		si.valueInt = value; 
		si.level = Standard.getLevel(index);
		si.score = Standard.getScore(index);
		si.extraScore = getExtra(value, grade, sex);
		
		return si;
		
	}
	
}
