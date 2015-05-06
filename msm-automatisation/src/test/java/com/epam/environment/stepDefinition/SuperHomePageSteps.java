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
	
	@Then("^I sould see elements: search gadget, main logo$")
	public void checkTheSuperHomePageMainElementsVisibility() {
		SuperHomePage.checkTheSuperHomePageMainElementsVisibility();
	}
	
	@Then("^I sould see following text of the SuperHomePage main title: '(.+)'$")
	public void checkTheSuperHomePageMainTitleText(String text) throws Throwable {
		SuperHomePage.checkTheSuperHomePageMainTitleText(text);
	}
	
	@Then("^I sould see following search gadget buttons: '(.+)', '(.+)', '(.+)', '(.+)', '(.+)'$")
	public void checkTheSuperHomePageElementsText(String text1, String text2, String text3, String text4, String text5) throws Throwable {
		SuperHomePage.checkTheSuperHomePageElementsText(text1, text2, text3, text4, text5);
	}
	
	@When("^I open Flights search gadget$")
	public void openFlightsSearchGadget() {
		SuperHomePage.openFlightsSearchGadget();
	}
	
	@When("^I open Car hire search gadget$")
	public void openCarHireSearchGadget() {
		SuperHomePage.openCarHireSearchGadget();
	}
	
	@When("^I fill Flights form by minimum profile$")
	public void fillFlightsFormByMinimumProfile() {
		SuperHomePage.fillFlightsFormByMinimumProfile();
	}
	
	@When("^I fill Car hire form by minimum profile$")
	public void fillCarHireFormByMinimumProfile() {
		SuperHomePage.fillCarHireFormByMinimumProfile();
	}
	
	@When("^I submit Flying Search gadget form$")
	public void submitFlyingSearchGadgetForm() {
		SuperHomePage.submitFlyingSearchGadgetForm();
	}
	
	@When("^I submit Car hire Search gadget form$")
	public void submitCarHireSearchGadgetForm() {
		SuperHomePage.submitCarHireSearchGadgetForm();
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
