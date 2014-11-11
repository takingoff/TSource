/**
 *	2014年11月10日 下午3:07:11
 *	TangLi
 */
package chaos.chaosin;

import chaos.Chaos;

/**
 * @author TangLi
 * 2014年11月10日下午3:07:11
 */
public class ChaosIn extends Chaos
{
	
	public static void main(String[] ars)
	{
		Chaos c = new Chaos();
		System.out.println(c);
	}
	
	protected void fun()
	{
		this.protectedFun();
	}
	
}
