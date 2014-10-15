/**
 *	2014年10月14日 上午10:30:07
 *	TangLi
 */
package health_information.model;

/**
 * @author TangLi
 * 2014年10月14日上午10:30:07
 */
public class SingleIndicator
{
	public Double valueDouble; //成绩
	public Integer valueInt; //成绩
	public int score;//分数
	public String level;//等级
	
	public int extraScore;//跳绳额外加分。

	@Override
	public String toString()
	{
		return "SingleIndicator [valueDouble=" + valueDouble + ", valueInt=" + valueInt + ", score=" + score + ", level=" + level + ", extraScore=" + extraScore + "]";
	}

}
