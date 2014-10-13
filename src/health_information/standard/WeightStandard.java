/**
 *	2014年10月13日 下午2:23:59
 *	TangLi
 */
package health_information.standard;

import java.util.LinkedList;
import java.util.List;

/**
 * @author TangLi
 * 2014年10月13日下午2:23:59
 */
public class WeightStandard
{
	///年级、男女、

	public static List<WeightScale> weightScale = new LinkedList<WeightScale>();

	public static List<Double> heightList = new LinkedList<Double>();
	static 
	{
		
	}
	
	static
	{
		//14.8)	[14.8,16.9)	[16.9,19.2)	[19.2,19.9)	[19.9	
		weightScale.add(new WeightScale(106.0 , 14.8 , 16.9   , 19.2   ,19.9));
		weightScale.add(new WeightScale(107.0 , 15.1 , 17.2   , 19.6   ,20.4));
		weightScale.add(new WeightScale(108.0 , 15.3 , 17.6   , 20.0   ,20.8));
		weightScale.add(new WeightScale(109.0 , 15.6 , 18.0   , 20.4   ,21.2));
		weightScale.add(new WeightScale(110.0 , 15.8 , 18.4   , 20.8   ,21.6));
		weightScale.add(new WeightScale(111.0 , 16.1 , 18.7   , 21.2   ,22.0));
		weightScale.add(new WeightScale(112.0 , 16.4 , 19.0   , 21.6   ,22.4));
		weightScale.add(new WeightScale(113.0 , 16.7 , 19.3   , 22.1   ,22.9));
		weightScale.add(new WeightScale(114.0 , 17.0 , 19.7   , 22.5   ,23.3));
		weightScale.add(new WeightScale(115.0 , 17.3 , 20.0   , 22.9   ,23.7));
		weightScale.add(new WeightScale(116.0 , 17.6 , 20.4   , 23.3   ,24.2));
		weightScale.add(new WeightScale(117.0 , 18.0 , 20.7   , 23.7   ,24.7));
		weightScale.add(new WeightScale(118.0 , 18.3 , 21.1   , 24.2   ,25.1));
		weightScale.add(new WeightScale(119.0 , 18.6 , 21.5   , 24.7   ,25.6));
		weightScale.add(new WeightScale(120.0 , 19.0 , 21.9   , 25.2   ,26.3));
		weightScale.add(new WeightScale(121.0 , 19.4 , 22.3   , 25.7   ,26.9));
		weightScale.add(new WeightScale(122.0 , 19.7 , 22.7   , 26.3   ,27.5));
		weightScale.add(new WeightScale(123.0 , 20.1 , 23.1   , 26.9   ,28.1));
		weightScale.add(new WeightScale(124.0 , 20.5 , 23.5   , 27.4   ,28.7));
		weightScale.add(new WeightScale(125.0 , 20.9 , 23.9   , 27.9   ,29.3));
		weightScale.add(new WeightScale(126.0 , 21.3 , 24.4   , 28.6   ,29.9));
		weightScale.add(new WeightScale(127.0 , 21.7 , 24.8   , 29.1   ,30.5));
		weightScale.add(new WeightScale(128.0 , 22.1 , 25.2   , 29.6   ,31.1));
		weightScale.add(new WeightScale(129.0 , 22.6 , 25.7   , 30.2   ,31.7));
		weightScale.add(new WeightScale(130.0 , 23.0 , 26.2   , 31.0   ,32.4));
		weightScale.add(new WeightScale(131.0 , 23.5 , 26.7   , 31.7   ,33.3));
		weightScale.add(new WeightScale(132.0 , 23.9 , 27.2   , 32.4   ,34.1));
		weightScale.add(new WeightScale(133.0 , 24.4 , 27.8   , 33.0   ,34.8));
		weightScale.add(new WeightScale(134.0 , 24.9 , 28.4   , 33.7   ,35.4));
		weightScale.add(new WeightScale(135.0 , 25.3 , 29.0   , 34.3   ,36.1));
		weightScale.add(new WeightScale(136.0 , 25.8 , 29.6   , 35.0   ,36.8));
		weightScale.add(new WeightScale(137.0 , 26.4 , 30.2   , 35.7   ,37.5));
		weightScale.add(new WeightScale(138.0 , 27.0 , 30.9   , 36.4   ,38.3));
		weightScale.add(new WeightScale(139.0 , 27.6 , 31.6   , 37.2   ,39.2));
		weightScale.add(new WeightScale(140.0 , 28.1 , 32.3   , 38.1   ,40.1));
		weightScale.add(new WeightScale(141.0 , 28.6 , 33.0   , 39.0   ,41.0));
		weightScale.add(new WeightScale(142.0 , 29.1 , 33.8   , 39.9   ,41.9));
		weightScale.add(new WeightScale(143.0 , 29.7 , 34.6   , 40.8   ,42.8));
		weightScale.add(new WeightScale(144.0 , 30.3 , 35.3   , 41.8   ,43.7));
		weightScale.add(new WeightScale(145.0 , 30.9 , 36.0   , 42.4   ,44.6));
		weightScale.add(new WeightScale(146.0 , 31.5 , 36.7   , 43.3   ,45.5));
		weightScale.add(new WeightScale(147.0 , 32.1 , 37.5   , 44.3   ,46.5));
		weightScale.add(new WeightScale(148.0 , 32.7 , 38.2   , 45.1   ,47.4));
		weightScale.add(new WeightScale(149.0 , 33.3 , 38.9   , 46.0   ,48.3));
		weightScale.add(new WeightScale(150.0 , 34.0 , 39.6   , 46.8   ,49.2));
		weightScale.add(new WeightScale(151.0 , 34.6 , 40.2   , 47.6   ,50.0));
		weightScale.add(new WeightScale(152.0 , 35.2 , 41.0   , 48.5   ,50.8));
		weightScale.add(new WeightScale(153.0 , 35.9 , 41.7   , 49.2   ,51.6));
		weightScale.add(new WeightScale(154.0 , 36.5 , 42.5   , 50.0   ,52.5));
		weightScale.add(new WeightScale(155.0 , 37.1 , 43.4   , 51.2   ,53.5));
	}                                                                                                          
	
	static public void main(String[] ars)
	{
		
	}
	
	
}
