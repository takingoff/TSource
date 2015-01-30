/**
 *	2015年1月30日 上午9:57:32
 *	TangLi
 */
package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TangLi
 * 2015年1月30日上午9:57:32
 */
@Controller
@RequestMapping(value="Acontroller")
public class AController
{

	@RequestMapping(value="getText")
	public String  getText(String requestVal)
	{
		
		return "this mesg from Contoller,receive your msg: '"+requestVal+",";
	}
}
