package com.epam.environment.stepDefinition;


import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.touch.FlickAction;

import com.epam.environment.cucumberTests.FirstTestRunner;
import com.epam.environment.pageObjects.SuperHomePage;
import com.epam.environment.stepDefinition.channels.ChannelPageSteps;
import com.epam.environment.stepDefinition.channels.FlightsResultsPageSteps;
import com.epam.fw.object.MyElement;
import com.epam.fw.services.WebElementsServices;
import com.epam.fw.shop.FieldsShop;
import com.epam.fw.shop.PageShop;
import com.epam.fw.shop.WebElementsShop;

import cucumber.api.java.en.*;

public class SuperHomePageSteps {
	
	
	public SuperHomePageSteps() {}
	
	
	@Given("^I am on SuperHomePage$")
	public void goToSuperHomePage() {
		SuperHomePage.goToSuperHomePage();
	}
	
	@Then("^the superHomePage element '(.+)' is visible$")
	public void checkTheSuperHomePageElementIsVisibile(String elementName) {
		SuperHomePage.checkTheSuperHomePageElementIsVisibile(elementName);
	}
	
	@Then("^the superHomePage element '(.+)' has the text '(.+)'$")
	public void checkTheSuperHomePageElementHasTheText(String elementName, String text) throws Throwable {
		SuperHomePage.checkTheSuperHomePageElementHasTheText(elementName, text);
	}
	
	@When("^I click on the superHomePageElement '(.+)'$")
	public void clickOnSuperHomePageElement(String elementName) {
		SuperHomePage.clickOnSuperHomePageElement(elementName);
	}
	
	
	@When("^I fill superHomePage form by '(.+)' profile$")
	public void fillSuperHomePageFormByProfile(String profileName) {
		SuperHomePage.fillSuperHomePageFormByProfile(profileName);
	}
	
	
	
	
	
//	public static SuperHomePage goToSuperHomePage(WebgetDriver() getDriver()) {
//		PageShop.goToPage(uri, items, getDriver());
//		return new SuperHomePage(getDriver());
//	}
//	
//	public void checkSuperHomePageContentSGF() {
//		WebElementsShop.assertElementVisible(searchGadgetForm, getDriver());
//		WebElementsShop.assertElementVisible(mainLogo, getDriver());
//		WebElementsShop.assertElementHasText(mainTitle, "Leave London behind Where do you want to go today?", getDriver());
//		WebElementsShop.assertElementHasText(carHireFormButton, "Car Hire", getDriver());
//		WebElementsShop.assertElementHasText(flightsFormButton, "Flights", getDriver());
//		WebElementsShop.assertElementHasText(holidaysFormButton, "Holidays", getDriver());
//		WebElementsShop.assertElementHasText(hotelsFormButton, "Hotels", getDriver());
//		WebElementsShop.assertElementHasText(insuranceFormButton, "Insurance", getDriver());	
//	}
//	
//	public void fillFlightsFormByMinimumProfile() {
//		WebElementsShop.clickOnElement(flightsFormButton, getDriver());
//		FieldsShop.fillFormByProfile(minimumFlightsProfile, getDriver());
//	}
//	
//	public FlightsResultsPage goToFlightsResultsPageWithMinimumProfile() {
//		WebElementsShop.clickOnElement(flyingSearchButton, getDriver());
//		PageShop.waitForPage(getDriver());
//		return new FlightsResultsPage(getDriver());
//	}
	
	

}
