 package main.java;

//import com.sg.mobile.pointp.Utils.CrashLog;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class BaseTest {
	public  static ExtentReports extent;
	// static PPHelper helper=new PPHelper();
	public BaseTest() {
		
		try {
			DriverController.instance.start();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	
		PageFactory.initElements(new AppiumFieldDecorator(
				DriverController.driver, 5, TimeUnit.SECONDS), this);
	}

	@SuppressWarnings("unchecked")
	@DataProvider(name = "init")
	public Object[][] injectPage(Method method) throws NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {

		Test test = method.getAnnotation(Test.class);
		Class<? extends Page> clazz = test.page();
		if (clazz.equals(Object.class)) {
			return new Object[][] { {} };
		}

		return new Object[1][1]; 
	}
@BeforeSuite
	
	public static  ExtentReports getReporter() {
		if (extent == null) {
		//	extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/CAMAL.html", true);
			extent = new ExtentReports(System.getProperty("user.dir") +"/extentReports/WAFM.html", true);
			extent
			.addSystemInfo("Host Name", "WAFM")
			.addSystemInfo("Environment", "QA")
			.addSystemInfo("Testapp", "WAF-APP");
		}
		
		 
		return extent;
		
	}
	
@AfterSuite
public void closeextend()
{
	extent.flush();
}
	/*
	 * This method has been defined to take screen shots everytime a test case
	 * fails , The @AfterMethod annotation is called after every test case is
	 * executed and it checks whether is has failed or passed and accordingly
	 * screenShots are taken and saved into the folder
	 */
	 @AfterMethod(alwaysRun = true)
	 public static void takeScreenShotOnFailure(ITestResult testResult,
	 Method method) throws Exception {
	 if (testResult.getStatus() == ITestResult.FAILURE) {
	 System.out.println(testResult.getStatus());
	 RemoteWebDriver driver = DriverController.driver;
	 File scrFile = driver.getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(scrFile,
	 new File("./screenshots/ErrorScreenshot_"+timestamp()+"_"+ method.getName() 
	 + ".png"));
	 // if(helper.getDriverType()==AppStringConstants.Android){
	 // helper.captureLog(driver, method.getName());
	 // }
	
	 // CrashLog cLog=CrashLog.getInstance();
	 // cLog.crashLog(method.getName());
	 }
	 }
	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	}

	/*
	 * The tear down method is used to quit the driver when the execution of
	 * specified number of test cases has been finished the @AfterSuite
	 * annotation is used to indicate a test suit combining of test cases and is
	 * set to alwaysRun=true and is invoked when all the test cases of the suite
	 * have been executed ,which indeed causes the driver to quit
	 */

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		DriverController.driver.quit();
 		DriverController.driver = null;
	}

	public interface Page {
		void setup();
	}
}
