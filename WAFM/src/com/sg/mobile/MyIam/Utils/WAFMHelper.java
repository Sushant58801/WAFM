package com.sg.mobile.MyIam.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import main.java.DriverController;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;





public class WAFMHelper 
{
	
	
	public static AppiumDriver<MobileElement> driver;
	public  String filePath;
	public WebDriverWait wait = new WebDriverWait(DriverController.driver, 10);
	static String imagesDirectory = "";
	static String relativePathforImage="";
	public static String baseUrl="";
	protected static ExtentReports extent;
	
	
	public boolean isElementPresent(MobileElement mobileElement) {
		try {
			mobileElement.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;

		} catch (StaleElementReferenceException e){
			// TODO: handle exception
			System.out.println("Element is not visible due to transition time");
			return false;
		}

	}


	
	
	public int generateIndex(int size) {
		Random rand = new Random();
		int index = rand.nextInt(size - 1); // -1 because index
											// will start from 0
		return index;
	}

	public void swipeScreen() {
		(new TouchAction((MobileDriver<MobileElement>) DriverController.driver))
				.press(835, 183).moveTo(-389, 18).release().perform();
	}

	public boolean waitForElementLoad(MobileElement elementName) {
		boolean setElementVisibility;
		try {
			wait.until(ExpectedConditions.visibilityOf(elementName));
			setElementVisibility = true;

		} catch (NoSuchElementException e) {
			setElementVisibility = false;
		}
		return setElementVisibility;
	}

	public boolean equalLists(List<String> one, List<String> two)
			throws InterruptedException {
		if (one == null && two == null) {
			Assert.assertEquals(one, two, "The two list are NotEqual");
			return true;
		}

		if ((one == null && two != null) || one != null && two == null
				|| one.size() != two.size()) {
			Assert.assertEquals(one, two, "The two list are Not Equal");
			return false;
		}

		// to avoid messing the order of the lists we will use a copy
		one = new ArrayList<String>(one);
		two = new ArrayList<String>(two);

		Thread.sleep(3000);
		Collections.sort(one);
		Thread.sleep(2000);
		Collections.sort(two);
		Thread.sleep(2000);
		Assert.assertEquals(one, two, "The two list are Equal");
		return one.equals(two);

	}
	
	
	
	 public boolean scrollTo(String selector) {
		boolean flag;
		try {

			AndroidDriver<MobileElement> androidDriver = (AndroidDriver<MobileElement>) DriverController.driver;
			androidDriver
					.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ selector + "\").instance(0))");
			flag = true;
		} catch (NoSuchElementException e) {

			System.out.println(selector + "  "
					+ " Element with this name not found");
			flag = false;
		}
		return flag;

	}
	 
	 public void swaipverticle(AppiumDriver<MobileElement> driver,double startpersentage,double finalpercentage){
			Dimension dim = driver.manage().window().getSize();
			int width = (int) (dim.width/2);
			int startPoint = (int) (dim.getHeight() * startpersentage);
			int endPoint = (int) (dim.getHeight() * finalpercentage);
			new TouchAction(driver).press(width,startPoint).moveTo(width, endPoint).release().perform();
				
			
		}
	 
	 public boolean isFileDownloaded(String downloadPath, String fileName) {
			boolean flag = false;
		    File dir = new File(downloadPath);
		    File[] dir_contents = dir.listFiles();
		  	    
		    for (int i = 0; i < dir_contents.length; i++) {
		        if (dir_contents[i].getName().contains(fileName))
		            return flag=true;
		            }

		    return flag;
		}




	
}
