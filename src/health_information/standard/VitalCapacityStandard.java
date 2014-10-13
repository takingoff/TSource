/**
 *	2014年10月13日 下午9:32:47
 *	TangLi
 *	VitalCapacity.java
 */
package health_information.standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TangLi
 * 2014年10月13日下午9:32:47
 */
public class VitalCapacityStandard extends Standard
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
		
		
		g1.add(1700);	g2.add(2000);	g3.add(2300);	g4.add(2600);	g5.add(2900);	g6.add(3200);
		g1.add(1600);	g2.add(1900);	g3.add(2200);	g4.add(2500);	g5.add(2800);	g6.add(3100);
		g1.add(1500);	g2.add(1800);	g3.add(2100);	g4.add(2400);	g5.add(2700);	g6.add(3000);
		g1.add(1400);	g2.add(1650);	g3.add(1900);	g4.add(2150);	g5.add(2450);	g6.add(2750);
		g1.add(1300);	g2.add(1500);	g3.add(1700);	g4.add(1900);	g5.add(2200);	g6.add(2500);
		g1.add(1240);	g2.add(1430);	g3.add(1620);	g4.add(1820);	g5.add(2110);	g6.add(2400);
		g1.add(1180);	g2.add(1360);	g3.add(1540);	g4.add(1740);	g5.add(2020);	g6.add(2300);
		g1.add(1120);	g2.add(1290);	g3.add(1460);	g4.add(1660);	g5.add(1930);	g6.add(2200);
		g1.add(1060);	g2.add(1220);	g3.add(1380);	g4.add(1580);	g5.add(1840);	g6.add(2100);
		g1.add(1000);	g2.add(1150);	g3.add(1300);	g4.add(1500);	g5.add(1750);	g6.add(2000);
		g1.add(940 );	g2.add(1080);	g3.add(1220);	g4.add(1420);	g5.add(1660);	g6.add(1900);
		g1.add(880 );	g2.add(1010);	g3.add(1140);	g4.add(1340);	g5.add(1570);	g6.add(1800);
		g1.add(820 );	g2.add(940 );	g3.add(1060);	g4.add(1260);	g5.add(1480);	g6.add(1700);
		g1.add(760 );	g2.add(870 );	g3.add(980 );	g4.add(1180);	g5.add(1390);	g6.add(1600);
		g1.add(700 );	g2.add(800 );	g3.add(900 );	g4.add(1100);	g5.add(1300);	g6.add(1500);
		g1.add(660 );	g2.add(750 );	g3.add(840 );	g4.add(1030);	g5.add(1220);	g6.add(1410);
		g1.add(620 );	g2.add(700 );	g3.add(780 );	g4.add(960 );	g5.add(1140);	g6.add(1320);
		g1.add(580 );	g2.add(650 );	g3.add(720 );	g4.add(890 );	g5.add(1060);	g6.add(1230);
		g1.add(540 );	g2.add(600 );	g3.add(660 );	g4.add(820 );	g5.add(980 );	g6.add(1140);
		g1.add(500 );	g2.add(550 );	g3.add(600 );	g4.add(750 );	g5.add(900 );	g6.add(1050);
		
		
		f1.add(1400);	f2.add(1600);	f3.add(1800);	f4.add(2000);	f5.add(2250);	f6.add(2500);
		f1.add(1300);	f2.add(1500);	f3.add(1700);	f4.add(1900);	f5.add(2150);	f6.add(2400);
		f1.add(1200);	f2.add(1400);	f3.add(1600);	f4.add(1800);	f5.add(2050);	f6.add(2300);
		f1.add(1100);	f2.add(1300);	f3.add(1500);	f4.add(1700);	f5.add(1950);	f6.add(2200);
		f1.add(1000);	f2.add(1200);	f3.add(1400);	f4.add(1600);	f5.add(1850);	f6.add(2100);
		f1.add(960 );	f2.add(1150);	f3.add(1340);	f4.add(1530);	f5.add(1770);	f6.add(2010);
		f1.add(920 );	f2.add(1100);	f3.add(1280);	f4.add(1460);	f5.add(1690);	f6.add(1920);
		f1.add(880 );	f2.add(1050);	f3.add(1220);	f4.add(1390);	f5.add(1610);	f6.add(1830);
		f1.add(840 );	f2.add(1000);	f3.add(1160);	f4.add(1320);	f5.add(1530);	f6.add(1740);
		f1.add(800 );	f2.add(950 );	f3.add(1100);	f4.add(1250);	f5.add(1450);	f6.add(1650);
		f1.add(760 );	f2.add(900 );	f3.add(1040);	f4.add(1180);	f5.add(1370);	f6.add(1560);
		f1.add(720 );	f2.add(850 );	f3.add(980 );	f4.add(1110);	f5.add(1290);	f6.add(1470);
		f1.add(680 );	f2.add(800 );	f3.add(920 );	f4.add(1040);	f5.add(1210);	f6.add(1380);
		f1.add(640 );	f2.add(750 );	f3.add(860 );	f4.add(970 );	f5.add(1130);	f6.add(1290);
		f1.add(600 );	f2.add(700 );	f3.add(800 );	f4.add(900 );	f5.add(1050);	f6.add(1200);
		f1.add(580 );	f2.add(680 );	f3.add(780 );	f4.add(880 );	f5.add(1020);	f6.add(1170);
		f1.add(560 );	f2.add(660 );	f3.add(760 );	f4.add(860 );	f5.add(990 );	f6.add(1140);
		f1.add(540 );	f2.add(640 );	f3.add(740 );	f4.add(840 );	f5.add(960 );	f6.add(1110);
		f1.add(520 );	f2.add(620 );	f3.add(720 );	f4.add(820 );	f5.add(930 );	f6.add(1080);
		f1.add(500 );	f2.add(600 );	f3.add(700 );	f4.add(800 );	f5.add(900 );	f6.add(1050);
		
		
		
		
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
	


	@Override
	public int getRegion(int value, String grade, String sex)
	{
		int index =0;
		for(int scale:scaleMap.get(grade).get(sex))
		{
			if(value>scale)
				break;
			else
				index++;
		}
		return index;
	}
	
	
}
