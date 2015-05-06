package com.epam.fw.shop;

import static com.epam.fw.data.ConstantData.SELENIUM_HOST_LOCAL;
import static com.epam.fw.data.ConstantData.SELENIUM_PORT;

import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.epam.fw.object.Options;

public abstract class Shop {
	
	protected static Options options = new Options();	
	protected static WebDriver driver;
	
	private static final Logger log = Logger.getLogger(MultiShop.class);
	
	public static void setUpDriver(String driverType) {
		try {
			switch (driverType) {
			case "Firefox":
				driver = new FirefoxDriver();
				break;
			case "RemoteFirefox":
				URL gridHost = new URL("http://"+SELENIUM_HOST_LOCAL+":"+SELENIUM_PORT+"/wd/hub");
				DesiredCapabilities capability = DesiredCapabilities.firefox();
				driver = new RemoteWebDriver(gridHost, capability);
				break;
			default:
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void shutDownDriver() {
		driver.close();
	    driver.quit();
	}

}
