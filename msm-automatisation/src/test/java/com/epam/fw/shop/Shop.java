package com.epam.fw.shop;

import static com.epam.fw.data.ConstantData.SELENIUM_HOST_LOCAL;
import static com.epam.fw.data.ConstantData.SELENIUM_PORT;

import java.net.URL;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.epam.fw.object.MyElement;
import com.epam.fw.object.Options;
import com.epam.fw.services.MultiServices;

public abstract class Shop {
	
	protected static Options options = new Options();	
	protected static WebDriver driver;
	
	private static final Logger log = Logger.getLogger(Shop.class);
	
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
	
	public static MyElement getMyElementByName(LinkedHashMap<String, MyElement> map, String elementName) {
    	log.info("enter to function getElementByName");
    	options.setDriver(driver);
    	try {
    		MyElement myEl = map.get(elementName);
    		myEl.setName(elementName);
    		return myEl;
    	} catch (Exception e) {
    		log.error("Something wrong with profile " + e.getClass());
    		options.setErrorMessage("Something wrong with profile " + e.getClass());
    		MultiServices.errorShutdown(options);
    		return null;
    	}
    }

}
