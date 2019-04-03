package main.java;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import com.sg.mobile.MyIam.Utils.AppProperties;
import com.sg.mobile.MyIam.Utils.AppStringConstants;
import com.sg.mobile.MyIam.Utils.UserProperty;

public class DriverController {

	/**
	 * Created by S6989325 on 2/10/2017.
	 */

	// This class is defined to set the driver for iOS and Android Platform

	private String appActivity, appPackage, bundleId, buildName, buildExtn;
	public static String appName, platform;
	public static DriverController instance = new DriverController();
	public static AppiumDriver<MobileElement> driver;

	// private AppProperties appProperties = AppProperties.getInstance();

	// the start function is used to create an instance of the driver,depending
	// upon the inputs taken from the app.properties file
	@BeforeClass(alwaysRun = true)
	public void start() throws MalformedURLException {

		if (driver != null) {
			return;
		}

		setTestExecutionPlatform();
		setApplicationPackage();

		try {
			// set the desired capabilities of the driver's that will be used to
			// execute the automation process
			switch (platform) {
			case AppStringConstants.Android:
				File appDir = new File("");
				File app = new File(appDir.getAbsolutePath(),
						(AppProperties.getProperty(UserProperty.APP_BUILD_PATH,
								"")));
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.PLATFORM,
						(AppProperties.getProperty(
								UserProperty.APP_PLATFORM_NAME, "Android")));
				capabilities
						.setCapability("deviceName", (AppProperties
								.getProperty(UserProperty.APP_DEVICE_NAME, "emulator")));
				capabilities.setCapability("platformVersion", (AppProperties
						.getProperty(UserProperty.APP_VERSION, "4.3")));
				// this is the package name of the app
				setApplicationPackage();
				capabilities.setCapability("appPackage", appPackage);
				capabilities.setCapability("appActivity", appActivity);
				capabilities.setCapability("automationName", "UiAutomator2");
				capabilities.setCapability("allowTestPackages", true);
				capabilities.setCapability("app", app.getAbsolutePath());
				// capabilities.setCapability("fullReset", "false");
				// it will launch the app using the configuration specified in
				// the Desired capabilities
				driver = new AndroidDriver<MobileElement>(new URL(
						"http://127.0.0.1:4725/wd/hub"), capabilities);
				break;

			case AppStringConstants.iOS:
				File appDir1 = new File("");
				File iosApp = new File(appDir1.getAbsolutePath(),
						(AppProperties.getProperty(UserProperty.APP_BUILD_PATH,
								"")));
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("platformName", (AppProperties
						.getProperty(UserProperty.APP_IOS_PLATFORM, "iOS")));
				capabilities.setCapability("automationName", "XCUITest");
				capabilities.setCapability("showXcodeLog", "true");
				capabilities.setCapability("deviceName", (AppProperties
						.getProperty(UserProperty.APP_IOS_DEVICE_NAME,
								"iPhone 6s")));
				capabilities.setCapability("platformVersion", (AppProperties
						.getProperty(UserProperty.APP_IOS_VERSION, "")));
				capabilities
						.setCapability(
								"xcodeConfigFile",
								"/Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/Config.xcconfig");
				capabilities.setCapability("udid", (AppProperties.getProperty(
						UserProperty.APP_IOS_UDID, "")));

				capabilities.setCapability("bundleId", bundleId);
				capabilities.setCapability("updatedWDABundleId",
						"io.appium.WebDriverAgentRunner");
				// capabilities.setCapability("fullReset", "true");
				capabilities.setCapability("app", iosApp.getAbsolutePath());
				driver = new IOSDriver<MobileElement>(new URL(
						"http://127.0.0.1:4724/wd/hub"), capabilities);
				break;

			}
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		} catch (Exception e) {
			// LOGGER.error("Cannot initialise driver!!:"+e.getMessage());
			e.printStackTrace();
		}
	}

	private void setApplicationPackage() {
		switch (platform) {
		case AppStringConstants.Android:
			appPackage = AppStringConstants.MyIamPackage;
			appActivity = AppStringConstants.MyIamActivity;
			break;

		case AppStringConstants.iOS:

			break;

		}

	}

	private void setTestExecutionPlatform() {
		AppProperties.getInstance();
		String buildPath = AppProperties.getProperty(
				UserProperty.APP_BUILD_PATH, null);

		if (buildPath.contains("/")) {
			String[] Build = buildPath.split("/");
			buildName = Build[1];

			if (buildName.contains(".")) {
				String[] Extn = buildName.split("\\.");
				appName = Extn[0];
				buildExtn = Extn[1];
			}

			if (buildExtn.equals("ipa") || buildExtn.equals("app")) {
				platform = AppStringConstants.iOS;

			} else {
				platform = AppStringConstants.Android;
			}
		}
	}

	public void stop() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
