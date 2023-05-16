/**
 * 
 */
package com.saucelabs.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.saucelabs.Utils.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author sunil
 * Purpose of this Base Class is for
 * 1)Load the Properties in the properties file
 * 2)Launch Browser before running the Scripts
 *
 *
 */
public class BaseClass {

	public static Properties prop;
	

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite
	// loadConfig method is to load the configuration
	public void configureLog() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			InputStream ip = new FileInputStream(new File(System.getProperty("user.dir") + "/src/main/resources/Data.properties"));
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//Declare the Driver method for Parallel Execution
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		//Maximize the screen
				getDriver().manage().window().maximize();
				//Delete all the cookies
				//Launching the URL
				getDriver().get(prop.getProperty("url"));

	}
	@AfterSuite
	public void endReport() {
		ExtentManager.endReport();
	}
}
