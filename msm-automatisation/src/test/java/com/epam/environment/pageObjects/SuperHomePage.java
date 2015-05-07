package com.epam.environment.pageObjects;

import java.util.LinkedHashMap;

import org.apache.log4j.Logger;

import com.epam.environment.stepDefinition.Hooks;
import com.epam.environment.stepDefinition.SuperHomePageSteps;
import com.epam.fw.object.MyElement;
import com.epam.fw.shop.FieldsShop;
import com.epam.fw.shop.PageShop;
import com.epam.fw.shop.Shop;
import com.epam.fw.shop.WebElementsShop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SuperHomePage extends Page{
	
private static final Logger log = Logger.getLogger(SuperHomePageSteps.class);
	
	//url items
	protected static final String uri = "/beta/";
	protected static final String items = "?searchGadgetForm=true";
	
	//elements
	protected static final LinkedHashMap<String, MyElement> superHomePageElements = new LinkedHashMap<String, MyElement>(){{
		//page elements
		put("mainLogo", new MyElement("//a[contains(@class,'site-logo-link')]", "webElement"));
		put("mainMenu", new MyElement("//button[@id='navigation-screen-toggle-area']", "button"));
		put("mainTitle", new MyElement("//div[@id='hero']", "webElement"));
		
		//new search gadget
		put("searchGadgetForm", new MyElement("//div[contains(@class,'searchGadgetForm__form-wrap')]", "webElement"));
		put("carHireFormButton", new MyElement("(//button[contains(@class,'searchGadgetForm__channelOption')])[3]", "button"));
		put("flightsFormButton", new MyElement("(//button[contains(@class,'searchGadgetForm__channelOption')])[2]", "button"));
		put("holidaysFormButton", new MyElement("(//button[contains(@class,'searchGadgetForm__channelOption')])[1]", "button"));
		put("hotelsFormButton", new MyElement("(//button[contains(@class,'searchGadgetForm__channelOption')])[4]", "button"));
		put("insuranceFormButton", new MyElement("(//button[contains(@class,'searchGadgetForm__channelOption')])[5]", "button"));
		
		//flights search gadget form
		put("airportFlyingFromField", new MyElement("//input[@id='flyingFromField_input']", "autocomplete"));
		put("airportFlyingToField", new MyElement("//input[@id='flyingToField_input']", "autocomplete"));
		put("returnOneWayRadio", new MyElement("//ul[@class='searchGadgetForm__list--radio']", "radio"));
		put("directFlightsOnlyCheckbox", new MyElement("//label[@for='isDirectOnly']", "checkbox"));
		put("departDatePicker", new MyElement("//input[@id='departureDate']", "datepicker"));
		put("returnDatePicker", new MyElement("//input[@id='returnDate']", "datepicker"));
		put("adultsSelector", new MyElement("//select[@id='flightsAdults']", "altdropdown"));
		put("childrenSelector", new MyElement("//select[@id='flightsChildren']", "altdropdown"));
		put("infantsSelector", new MyElement("//select[@id='flightsInfants']", "altdropdown"));
		put("flyingSearchButton", new MyElement("(//button[contains(@class,'submit')])[2]", "button"));
		
		//car hire search gadget form
		put("pickUpFrom", new MyElement("//input[@id='pickUpLocation_input']", "autocomplete"));
		put("pickUptDatePicker", new MyElement("//input[@id='pickUpDate']", "datepicker"));
		put("dropOffDatePicker", new MyElement("//input[@id='dropOffDate']", "datepicker"));
		put("pickUpTime", new MyElement("//select[@id='pickUpTime']", "altdropdown"));
		put("dropOffTime", new MyElement("//select[@id='dropOffTime']", "altdropdown"));
		put("agePass", new MyElement("//label[@for='getDriver()AgeCheckbox']", "checkbox"));
		put("driverAge", new MyElement("//select[@id='getDriver()Age']", "altdropdown"));
		put("carHireSearchButton", new MyElement("(//button[contains(@class,'submit')])[3]", "button"));
	}};
	
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
	protected static final MyElement flyingSearchButton = new MyElement("flyingSearchButton", "(//button[contains(@class,'submit')])[2]", "button");
	
	//car hire search gadget form
	protected static final MyElement pickUpFrom = new MyElement("pickUpFrom", "//input[@id='pickUpLocation_input']", "autocomplete");
	protected static final MyElement pickUptDatePicker = new MyElement("pickUptDatePicker", "//input[@id='pickUpDate']", "datepicker");
	protected static final MyElement dropOffDatePicker = new MyElement("dropOffDatePicker", "//input[@id='dropOffDate']", "datepicker");
	protected static final MyElement pickUpTime = new MyElement("pickUpTime", "//select[@id='pickUpTime']", "altdropdown");
	protected static final MyElement dropOffTime = new MyElement("dropOffTime", "//select[@id='dropOffTime']", "altdropdown");
	protected static final MyElement agePass = new MyElement("agePass", "//label[@for='getDriver()AgeCheckbox']", "checkbox");
	protected static final MyElement driverAge = new MyElement("driverAge", "//select[@id='getDriver()Age']", "altdropdown");
	protected static final MyElement carHireSearchButton = new MyElement("CarHireSearchButton", "(//button[contains(@class,'submit')])[3]", "button");
	
	
	
	protected static final LinkedHashMap<String, LinkedHashMap<MyElement, String>> superHomePageProfiles = new LinkedHashMap<String, LinkedHashMap<MyElement, String>>(){{
		
		put("minimumFlightsProfile", new LinkedHashMap<MyElement, String>(){{
										put(Shop.getMyElementByName(superHomePageElements,"airportFlyingFromField"), "Manchester");
										put(Shop.getMyElementByName(superHomePageElements,"airportFlyingToField"), "Paris");
										put(Shop.getMyElementByName(superHomePageElements,"departDatePicker"), "20 June 2015");
										put(Shop.getMyElementByName(superHomePageElements,"returnDatePicker"), "10 July 2015");
		}});
		put("minimumCarHireProfile", new LinkedHashMap<MyElement, String>(){{
										put(Shop.getMyElementByName(superHomePageElements,"pickUpFrom"), "Manchester");
										put(Shop.getMyElementByName(superHomePageElements,"pickUptDatePicker"), "20 June 2015");
										put(Shop.getMyElementByName(superHomePageElements,"dropOffDatePicker"), "10 July 2015");
		}});
		
	}};
	
	//search gadget profiles
	protected static final LinkedHashMap<MyElement, String> minimumFlightsProfile = new LinkedHashMap<MyElement, String>(){{
		put(airportFlyingFromField, "Manchester");
		put(airportFlyingToField, "Paris");
		put(departDatePicker, "20 June 2015");
		put(returnDatePicker, "10 July 2015");
	}};
	
	protected static final LinkedHashMap<MyElement, String> minimumCarHireProfile = new LinkedHashMap<MyElement, String>(){{
		put(pickUpFrom, "Manchester");
		put(pickUptDatePicker, "20 June 2015");
		put(dropOffDatePicker, "10 July 2015");
	}};
	
	
	public static void goToSuperHomePage() {
		PageShop.goToPage(uri);
	}
	
	public static void checkTheSuperHomePageElementIsVisibile(String elementName) {
		WebElementsShop.assertElementVisible(Shop.getMyElementByName(superHomePageElements, elementName));
	}
	
	public static void checkTheSuperHomePageElementHasTheText(String elementName, String text) throws Throwable {
		WebElementsShop.assertElementHasText(Shop.getMyElementByName(superHomePageElements, elementName), text);
	}
	
	public static void clickOnSuperHomePageElement(String elementName) {
		WebElementsShop.clickOnElement(Shop.getMyElementByName(superHomePageElements, elementName));
	}
	
	public static void fillSuperHomePageFormByProfile(String profileName) {
		FieldsShop.fillFormByProfile(Shop.getMyProfileByName(superHomePageProfiles,profileName));
	}
	

}
