/**
 *	2014年12月16日 下午2:57:26
 *	TangLi
 */
package tshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author TangLi 2014年12月16日下午2:57:26
 */
public class ShiroTest
{

	private static Logger log = LoggerFactory.getLogger(ShiroTest.class);

	public static void main(String[] args)
	{
		// Using the IniSecurityManagerFactory, which will use the an INI file
		// as the security file.
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("shiro.ini");

		// Setting up the SecurityManager...
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		Subject user = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken("root", "secret");

		user.login(token);

		Session session = user.getSession();
		session.setAttribute( "someKey", "aValue" );
		
		log.info("User key value:  " + session.getAttribute("someKey"));
		
		log.info("User is authenticated:  " + user.isAuthenticated());
		
		log.info( "User [" + user.getPrincipal() + "] logged in successfully." );
		
		if ( user.hasRole( "schwartz" ) ) {
		    log.info("May the Schwartz be with you!" );
		} else {
		    log.info( "Hello, mere mortal." );
		}
		
		if ( user.isPermitted( "lightsaber:weild" ) ) {
		    log.info("You may use a lightsaber ring.  Use it wisely.");
		} else {
		    log.info("Sorry, lightsaber rings are for schwartz masters only.");
		}
		
		if ( user.isPermitted( "winnebago:drive:eagle5" ) ) {
		    log.info("You are permitted to 'drive' the 'winnebago' with license plate (id) 'eagle5'.  " +
		                "Here are the keys - have fun!");
		} else {
		    log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
		}
	}
}
