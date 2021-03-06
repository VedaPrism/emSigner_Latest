package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_loginpage;

public class Login_Script extends Basefunctions {
	final static Logger log = Logger.getLogger(Login_Script.class);

	@Test(dataProvider= "valid_login",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void Login(Map hm) throws Exception{	
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.properties");
		//login

		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();

		et =  es.startTest("Login");
		log.info("this is login information");
		String uid = hm.get("Uname").toString();
		String pas = hm.get("Pwd").toString();
		pf_loginpage pl = new pf_loginpage(w);

		log.info("Username picked from Excel is "+uid);
		log.info("Username picked from Excel is "+pas);
		pl.logincredentials(uid,pas);
		log.info("Logged in successfully");

	}

}
