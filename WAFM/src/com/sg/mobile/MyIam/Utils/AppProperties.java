package com.sg.mobile.MyIam.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by saad on 14/9/16.
 */

public class AppProperties {

	// TODO configure logger for this class

	/*
	 * AppProperties is basically used to get configuration inputs from the user
	 * before running the automation process the app.properties file is loaded
	 * into the project using this and it consist of various parameters like
	 * deviceName,deviceID ,PlatformType etc.
	 */
	private static AppProperties appProperties;
	
	public static final String PROPERTY_FILE_NAME = "app.properties";

	private static Properties properties = new Properties();

	/*
	 * This method is used to load the properties file from the system
	 * properties.load(is) is used in this method to load the actual file
	 */
	private AppProperties() {

		InputStream is = null;
		try {
			is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(PROPERTY_FILE_NAME);
			properties.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static AppProperties getInstance() {
		if (appProperties == null) {
			appProperties = new AppProperties();
		}
		return appProperties;
	}

	/*
	 * The getProperty() method of java is used here to pass the key and default
	 * value ,in order to set the parameters sepcified by the endUser if the key
	 * value has not been defined into the property files,the application then
	 * starts to work with the deafult values specified in the programme code
	 */
	public static String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	// TODO add other methods to get individual datatype properties like
	// getInteger, etc

}
