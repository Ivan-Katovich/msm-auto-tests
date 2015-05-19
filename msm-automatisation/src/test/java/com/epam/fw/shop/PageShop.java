package com.epam.fw.shop;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.fw.object.Options;
import com.epam.fw.services.MultiServices;
import com.epam.fw.services.PageServices;
import com.epam.environment.stepDefinition.*;

import static com.epam.fw.data.ConstantData.*;

public class PageShop extends Shop{
	
	private static final Logger log = Logger.getLogger(PageShop.class);
	
	public static void goToPage(String uri) {
		options.setDriver(driver);
		options.setUri(uri);
		String fullUri = PageServices.urlCreator(options);
		if (fullUri == null) {
			log.error("URL is not defined");
			options.setErrorMessage("URL is not defined");
			MultiServices.errorShutdown(options);
		}
		log.info("enter to function goToPage with URL '" +fullUri + "'");
		driver.get(fullUri);
		if (PageServices.waitForPageLoaded(options)) {
			log.info("Page was loaded");
		} else {
			log.error("page didn't load");
			options.setErrorMessage("page didn't load");
			MultiServices.errorShutdown(options);
		}
	}
	
	public static void goToPage(String uri, String items) {
		options.setDriver(driver);
		options.setUri(uri);
		options.setItems(items);
		log.info("enter to function goToPage with URL '" + PageServices.urlCreator(options) + "'");
		driver.get(PageServices.urlCreator(options));
		if (PageServices.waitForPageLoaded(options)) {
			log.info("Page was loaded");
		} else {
			log.error("page didn't load");
			options.setErrorMessage("page didn't load");
			MultiServices.errorShutdown(options);
		}
	}
	
	public static void waitForPage() {
		options.setDriver(driver);		
		String actualUri = PageServices.getPageCurrentUrl(options);
		options.setUri(actualUri);
		if (PageServices.waitForPageLoaded(options)) {
			log.info("Page was loaded");
		} else {
			log.error("page didn't load");
			options.setErrorMessage("page didn't load");
			MultiServices.errorShutdown(options);
		}
	}
	
	public static void assertOnPageWithUrl(String expectedUri) {
		log.info("enter to function assertOnPageWithUrl with URL '" + expectedUri + "'");
		options.setDriver(driver);
		String actualUri = PageServices.getPageCurrentUrl(options);
		if (actualUri.indexOf(expectedUri) == -1 || actualUri.equals(null)) {
			log.error("Page loaded with uri '" + actualUri + "' but expected uri was '" + expectedUri + "'");
			options.setErrorMessage("Page loaded with uri '" + actualUri + "' but expected uri was '" + expectedUri + "'");
			MultiServices.errorShutdown(options);
		} else {
			log.info("actual and expected uri are the same and equal '" + expectedUri + "'");
		}
	}
	
	public static void assertCurrentUrlContainsStringItem(String stringItem) {
		log.info("enter to function assertOnPageWithUrl with URL '" + stringItem + "'");
		options.setDriver(driver);
		String actualUri = PageServices.getPageCurrentUrl(options);
		if (actualUri.indexOf(stringItem) == -1 || actualUri.equals(null)) {
			log.error("Page loaded with uri '" + actualUri + "' doesn't contain string item '" + stringItem + "'");
			options.setErrorMessage("Page loaded with uri '" + actualUri + "' doesn't contain string item '" + stringItem + "'");
			MultiServices.errorShutdown(options);
		} else {
			log.info("actual uri is '" + actualUri + "' contains string item '" + stringItem + "'");
		}
	}
	
	public static void assertURLChange() {
		log.info("enter to function assertURLChange");
		options.setDriver(driver);
		if (!PageServices.isUriChange(options)) {
			log.error("URL is not changed over time");
			options.setErrorMessage("URL is not changed over time");
			MultiServices.errorShutdown(options);
		} else {
			log.info("URL is changed");
		}
	    	
	}
	
	public static void switchToAnotherHandle() {
		log.info("enter to function switchToAnotherHandle");
		options.setDriver(driver);
		try {
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
		} catch (Exception e) {
			log.error("Can't switch to another handle");
			options.setErrorMessage("Can't switch to another handle");
			MultiServices.errorShutdown(options);
		}
	}
	
	
	
	
	

}
