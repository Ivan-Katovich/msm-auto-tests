package com.epam.environment.stepDefinition;


import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.touch.FlickAction;

import com.epam.environment.cucumberTests.TestRunner;
import com.epam.environment.stepDefinition.channels.ChannelPage;
import com.epam.environment.stepDefinition.channels.FlightsResultsPage;
import com.epam.fw.object.MyElement;
import com.epam.fw.services.WebElementsServices;
import com.epam.fw.shop.FieldsShop;
import com.epam.fw.shop.PageShop;
import com.epam.fw.shop.WebElementsShop;

import cucumber.api.java.en.*;

public class SuperHomePage {
	
	private static final Logger log = Logger.getLogger(SuperHomePage.class);
	
	//url items
	protected static final String uri = "/beta/";
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
	protected static final MyElement flyingSearchButton = new MyElement("flyingSearchButton", "(//button[contains(@class,'submit')])[2]", "button");
	
	//car hire search gadget form
	protected static final MyElement pickUpFrom = new MyElement("pickUpFrom", "//input[@id='pickUpLocation_input']", "autocomplete");
	protected static final MyElement pickUptDatePicker = new MyElement("pickUptDatePicker", "//input[@id='pickUpDate']", "datepicker");
	protected static final MyElement dropOffDatePicker = new MyElement("dropOffDatePicker", "//input[@id='dropOffDate']", "datepicker");
	protected static final MyElement pickUpTime = new MyElement("pickUpTime", "//select[@id='pickUpTime']", "altdropdown");
	protected static final MyElement dropOffTime = new MyElement("dropOffTime", "//select[@id='dropOffTime']", "altdropdown");
	protected static final MyElement agePass = new MyElement("agePass", "//label[@for='driverAgeCheckbox']", "checkbox");
	protected static final MyElement driverAge = new MyElement("driverAge", "//select[@id='driverAge']", "altdropdown");
	protected static final MyElement carHireSearchButton = new MyElement("CarHireSearchButton", "(//button[contains(@class,'submit')])[3]", "button");
	
	
	
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
	
	
	public SuperHomePage() {}
	
	
	@Given("^I am on SuperHomePage$")
	public void goToSuperHomePage() {
		PageShop.goToPage(uri, items, Hooks.driver);
	}
	
	@Then("^I sould see elements: search gadget, main logo$")
	public void checkTheSuperHomePageMainElementsVisibility() {
		WebElementsShop.assertElementVisible(searchGadgetForm, Hooks.driver);
		WebElementsShop.assertElementVisible(mainLogo, Hooks.driver);
	}
	
	@Then("^I sould see following text of the SuperHomePage main title: '(.+)'$")
	public void checkTheSuperHomePageMainTitleText(String text) throws Throwable {
		WebElementsShop.assertElementHasText(mainTitle, text, Hooks.driver);
	}
	
	@Then("^I sould see following search gadget buttons: '(.+)', '(.+)', '(.+)', '(.+)', '(.+)'$")
	public void checkTheSuperHomePageElementsText(String text1, String text2, String text3, String text4, String text5) throws Throwable {
		WebElementsShop.assertElementHasText(holidaysFormButton, text1, Hooks.driver);
		WebElementsShop.assertElementHasText(flightsFormButton, text2, Hooks.driver);
		WebElementsShop.assertElementHasText(carHireFormButton, text3, Hooks.driver);
		WebElementsShop.assertElementHasText(hotelsFormButton, text4, Hooks.driver);
		WebElementsShop.assertElementHasText(insuranceFormButton, text5, Hooks.driver);	
	}
	
	@When("^I open Flights search gadget$")
	public void openFlightsSearchGadget() {
		WebElementsShop.clickOnElement(flightsFormButton, Hooks.driver);
	}
	
	@When("^I open Car hire search gadget$")
	public void openCarHireSearchGadget() {
		WebElementsShop.clickOnElement(carHireFormButton, Hooks.driver);
	}
	
	@When("^I fill Flights form by minimum profile$")
	public void fillFlightsFormByMinimumProfile() {
		FieldsShop.fillFormByProfile(minimumFlightsProfile, Hooks.driver);
	}
	
	@When("^I fill Car hire form by minimum profile$")
	public void fillCarHireFormByMinimumProfile() {
		FieldsShop.fillFormByProfile(minimumCarHireProfile, Hooks.driver);
	}
	
	@When("^I submit Flying Search gadget form$")
	public void submitFlyingSearchGadgetForm() {
		WebElementsShop.clickOnElement(flyingSearchButton, Hooks.driver);
	}
	
	@When("^I submit Car hire Search gadget form$")
	public void submitCarHireSearchGadgetForm() {
		WebElementsShop.clickOnElement(carHireSearchButton, Hooks.driver);
	}
	
	
	
	
//	public static SuperHomePage goToSuperHomePage(WebDriver driver) {
//		PageShop.goToPage(uri, items, driver);
//		return new SuperHomePage(driver);
//	}
//	
//	public void checkSuperHomePageContentSGF() {
//		WebElementsShop.assertElementVisible(searchGadgetForm, driver);
//		WebElementsShop.assertElementVisible(mainLogo, driver);
//		WebElementsShop.assertElementHasText(mainTitle, "Leave London behind Where do you want to go today?", driver);
//		WebElementsShop.assertElementHasText(carHireFormButton, "Car Hire", driver);
//		WebElementsShop.assertElementHasText(flightsFormButton, "Flights", driver);
//		WebElementsShop.assertElementHasText(holidaysFormButton, "Holidays", driver);
//		WebElementsShop.assertElementHasText(hotelsFormButton, "Hotels", driver);
//		WebElementsShop.assertElementHasText(insuranceFormButton, "Insurance", driver);	
//	}
//	
//	public void fillFlightsFormByMinimumProfile() {
//		WebElementsShop.clickOnElement(flightsFormButton, driver);
//		FieldsShop.fillFormByProfile(minimumFlightsProfile, driver);
//	}
//	
//	public FlightsResultsPage goToFlightsResultsPageWithMinimumProfile() {
//		WebElementsShop.clickOnElement(flyingSearchButton, driver);
//		PageShop.waitForPage(driver);
//		return new FlightsResultsPage(driver);
//	}
	
	

}
