package com.epam.environment.pages;


import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.environment.pages.channels.ChannelPage;
import com.epam.fw.object.MyElement;
import com.epam.fw.services.WebElementsServices;
import com.epam.fw.shop.FieldsShop;
import com.epam.fw.shop.PageShop;
import com.epam.fw.shop.WebElementsShop;

public class SuperHomePage extends Page {
	
	private static final Logger log = Logger.getLogger(SuperHomePage.class);
	
	//url items
	protected static final String uri = "/beta/content/travelsupermarket/en_gb/superhomepage/";
	protected static final String items = "?searchGadgetForm=true";
	
	//elements
	//page elements
	protected static final MyElement mainLogo = new MyElement("mainLogo", "//a[contains(@class,'site-logo-link')]", "webElement");
	protected static final MyElement mainMenu = new MyElement("mainMenu", "//button[@id='navigation-screen-toggle-area']", "button");
	protected static final MyElement mainTitle = new MyElement("mainTitle", "//div[@id='hero']", "webElement");
	
	//old search gadget
	protected static final MyElement searchGadget = new MyElement("searchGadget", "//ol[contains(@class,'sG__channelOptionWrap')]", "webElement");
	protected static final MyElement carHireButton = new MyElement("carHireButton", "//button[contains(@ng-class,'carHire')]", "button");
	protected static final MyElement flightsButton = new MyElement("flightsButton", "//button[contains(@ng-class,'flights')]", "button");
	protected static final MyElement holidaysButton = new MyElement("holidaysButton", "//button[contains(@ng-class,'holidays')]", "button");
	protected static final MyElement hotelsButton = new MyElement("hotelsButton", "//button[contains(@ng-class,'hotels')]", "button");
	protected static final MyElement insuranceButton = new MyElement("insuranceButton", "//button[contains(@ng-click,'Insurance')]", "button");
	
	//new search gadget
	protected static final MyElement searchGadgetForm = new MyElement("searchGadgetForm", "//div[contains(@class,'searchGadgetForm__form-wrap')]", "webElement");
	protected static final MyElement carHireFormButton = new MyElement("carHireFormButton", "(//button[contains(@class,'searchGadgetForm__channelOption')])[3]", "button");
	protected static final MyElement flightsFormButton = new MyElement("flightsFormButton", "(//button[contains(@class,'searchGadgetForm__channelOption')])[2]", "button");
	protected static final MyElement holidaysFormButton = new MyElement("holidaysFormButton", "(//button[contains(@class,'searchGadgetForm__channelOption')])[1]", "button");
	protected static final MyElement hotelsFormButton = new MyElement("hotelsFormButton", "(//button[contains(@class,'searchGadgetForm__channelOption')])[4]", "button");
	protected static final MyElement insuranceFormButton = new MyElement("insuranceFormButton", "(//button[contains(@class,'searchGadgetForm__channelOption')])[5]", "button");
	
	//flights search gadget form
	protected static final MyElement airportFlyingFromField = new MyElement("airportFlyingFromField", "//input[@id='flyingFromField_input']", "autocomplete");
	protected static final MyElement airportFlyingToField = new MyElement("airportFlyingToField", "//input[@id='flyingToField_input']", "autocomplete");
	protected static final MyElement returnOneWayRadio = new MyElement("returnOneWayRadio", "//ul[@class='searchGadgetForm__list--radio']", "radio");
	protected static final MyElement directFlightsOnlyCheckbox = new MyElement("directFlightsOnlyCheckbox", "//label[@for='isDirectOnly']", "checkbox");
	protected static final MyElement departDatePicker = new MyElement("departDatePicker", "//input[@id='departureDate']", "datepicker");
	protected static final MyElement returnDatePicker = new MyElement("returnDatePicker", "//input[@id='returnDate']", "datepicker");
	protected static final MyElement adultsSelector = new MyElement("adultsSelector", "//select[@id='flightsAdults']", "altdropdown");
	protected static final MyElement childrenSelector = new MyElement("childrenSelector", "//select[@id='flightsChildren']", "altdropdown");
	protected static final MyElement infantsSelector = new MyElement("infantsSelector", "//select[@id='flightsInfants']", "altdropdown");
	protected static final MyElement flyingSearchButton = new MyElement("searchButton", "(//button[contains(@class,'submit')])[2]", "button");
	
	//search gadget profiles
	protected static final LinkedHashMap<MyElement, String> minimumFlightsProfile = new LinkedHashMap<MyElement, String>(){{
		put(airportFlyingFromField, "Manchester");
		put(airportFlyingToField, "Paris");
		put(departDatePicker, "20 June 2015");
		put(returnDatePicker, "10 July 2015");
	}};
	
	
	
	public SuperHomePage(WebDriver driver) {
		super(driver);
	}
	
	public static SuperHomePage goToSuperHomePage(WebDriver driver) {
		PageShop.goToPage(uri, items, driver);
		return new SuperHomePage(driver);
	}
	
	public void checkSuperHomePageContentSGF() {
		WebElementsShop.assertElementVisible(searchGadgetForm, driver);
		WebElementsShop.assertElementVisible(mainLogo, driver);
		WebElementsShop.assertElementHasText(mainTitle, "Leave London behind Where do you want to go today?", driver);
		WebElementsShop.assertElementHasText(carHireFormButton, "Car Hire", driver);
		WebElementsShop.assertElementHasText(flightsFormButton, "Flights", driver);
		WebElementsShop.assertElementHasText(holidaysFormButton, "Holidays", driver);
		WebElementsShop.assertElementHasText(hotelsFormButton, "Hotels", driver);
		WebElementsShop.assertElementHasText(insuranceFormButton, "Insurance", driver);	
	}
	
	public void fillFlightsFormByMinimumProfile() {
		WebElementsShop.clickOnElement(flightsFormButton, driver);
		FieldsShop.fillFormByProfile(minimumFlightsProfile, driver);
	}
	
	public ChannelPage goToFlightsResultsPageWithMinimumProfile() {
		WebElementsShop.clickOnElement(flyingSearchButton, driver);
		PageShop.waitForPage(driver);
		return new ChannelPage(driver);
	}
	
	

}
