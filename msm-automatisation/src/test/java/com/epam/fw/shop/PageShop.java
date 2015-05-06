package com.epam.fw.shop;

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
		log.info("enter to function assertOnPageWithUrl with URL '" + BASE_URI + expectedUri + "'");
		options.setDriver(driver);
		String actualUri = PageServices.getPageCurrentUrl(options);
		if (actualUri.indexOf(BASE_URI+expectedUri) == -1 || actualUri.equals(null)) {
			log.error("Page loaded with uri '" + actualUri + "' but expected uri was '" + BASE_URI + expectedUri + "'");
			options.setErrorMessage("Page loaded with uri '" + actualUri + "' but expected uri was '" + BASE_URI + expectedUri + "'");
			MultiServices.errorShutdown(options);
		} else {
			log.info("actual and expected uri are the same and equal '" + BASE_URI + expectedUri + "'");
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
	
//	public static Page goToPage(Options options) {
//		log.info("enter to function goToPage in shop");
//		Page page;
//		try {
//			switch (options.getUri()) {
//			case MAIN_PAGE_URI:
//				options.getDriver().get(MAIN_PAGE_URI);
//				page = new MainPage(options.getDriver());
//				break;
//			case CATALOG_AND_PRICE_PAGE_URI:
//				options.getDriver().get(CATALOG_AND_PRICE_PAGE_URI);
//				page = new CatalogPage(options.getDriver());
//				break;
//			case AUTO_PAGE_URI:
//				options.getDriver().get(AUTO_PAGE_URI);
//				page = new AutoPage(options.getDriver());
//				break;
//			case AUTO_FLEA_MAEKET_PAGE_URI:
//				options.getDriver().get(AUTO_FLEA_MAEKET_PAGE_URI);
//				page = new AutoFleaMarketPage(options.getDriver());
//				break;
//			case PEOPLE_PAGE_URI:
//				options.getDriver().get(PEOPLE_PAGE_URI);
//				page = new PeoplePage(options.getDriver());
//				break;
//			case REALTY_URI:
//				options.getDriver().get(REALTY_URI);
//				page = new RealtyPage(options.getDriver());
//				break;
//			case FLEA_MAEKET_PAGE_URI:
//				options.getDriver().get(FLEA_MAEKET_PAGE_URI);
//				page = new FleaMarketPage(options.getDriver());
//				break;
//			case FORUM_PAGE_URI:
//				options.getDriver().get(FORUM_PAGE_URI);
//				page = new ForumPage(options.getDriver());
//				break;
//			default:
//				page = null;
//			}
//			return page;
//		} catch (Exception e) {
//			log.error("cant get uri");
//			options.getDriver().quit();
//			return null;
//		}
//	}
	
	

}
