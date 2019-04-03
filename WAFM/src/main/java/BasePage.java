package main.java;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by saad on 24/8/16.
 */
public class BasePage extends DriverController{
	static String imagesDirectory = "";
	static String relativePathforImage = "";
	
	public BasePage() {
		try {

			// AppiumDriver<MobileElement> driver= AppiumController.driver;
			DriverController.instance.start();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		/*
		 * This is used to initliase the driver so that it can be used in the
		 * pageFactory enviroment Default decorator for use with PageFactory.
		 * Will decorate 1) all of the WebElement fields and 2) List of
		 * WebElement that have @AndroidFindBy, @AndroidFindBys, or
		 * 
		 * @iOSFindBy/@iOSFindBys annotation with a proxy that locates the
		 * elements using the passed in ElementLocatorFactory.
		 */
		PageFactory.initElements(new AppiumFieldDecorator(
				DriverController.driver, 5, TimeUnit.SECONDS), this);

	}
	public static void createDirectory(String classname) 
	{

		//classname = classname.substring(4);

		imagesDirectory = System.getProperty("user.dir") +"/extentReports"
				+ "/" + classname + "/";

		relativePathforImage = classname + "/";

		File file = new File(imagesDirectory);
		if (!file.exists()) {
			file.mkdir();
		} else {
			try {
				FileUtils.cleanDirectory(file);
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out
			.println("Either directory is already prersent or Failed to create directory.");
		}
	}

	
	public static String captureScreenShot(WebDriver driver,
			String screenshotName) 
	{
		try {
			Calendar calander = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat(
					"dd_MM_yy_hh_mm_ss");
			File src = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			String filename = screenshotName + "-"
					+ formater.format(calander.getTime()) + ".png";
			String dest = imagesDirectory + filename;
			File destination = new File(dest);
			FileUtils.copyFile(src, destination);
			String finaldest = relativePathforImage + filename;
			return finaldest;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot"
					+ e.getMessage());
			return e.getMessage();
		}
	}

	

}
