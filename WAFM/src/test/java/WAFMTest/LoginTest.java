package WAFMTest;

import main.java.BaseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sg.Page.LoginPage;
import com.sg.mobile.MyIam.Utils.AppProperties;
import com.sg.mobile.MyIam.Utils.AppStringConstants;
import com.sg.mobile.MyIam.Utils.UserProperty;


public class LoginTest extends BaseTest {

	String userName = AppProperties.getProperty(UserProperty.APP_USER_NAME,
			"testindec2");
	String passWord = AppProperties.getProperty(UserProperty.APP_PASSWORD,
			"testppdev");
	
	
	LoginPage login = new LoginPage();
	  
	@Test(priority = 1)
	public void Launchtest() throws InterruptedException {
		login.launch();
	}

	@Test(priority = 2)
	public void LoginValidation() throws InterruptedException {
		
		login.performLogin();
		
	}	
	@Test(priority=3)
	public void homePageContents() throws InterruptedException
	{
		login.verifyHomePage();
	}

	
	
	
	
}
