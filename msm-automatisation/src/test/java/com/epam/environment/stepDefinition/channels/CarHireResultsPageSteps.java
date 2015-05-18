package com.epam.environment.stepDefinition.channels;

import org.openqa.selenium.WebDriver;

import com.epam.environment.cucumberTests.FirstTestRunner;
import com.epam.environment.pageObjects.channels.CarHireResultsPage;
import com.epam.environment.stepDefinition.Hooks;
import com.epam.fw.shop.PageShop;

import cucumber.api.java.en.Then;

public class CarHireResultsPageSteps {
	
	
	
	public CarHireResultsPageSteps() {}
	
	@Then("^I am taken to the CarHireResults page$")
	public void assertOnCarHirePage() {
		CarHireResultsPage.assertOnCarHirePage();
	}
	
	@Then("^I click on the '(.+)'(?:st|th|nd) element of '(.+)' group$")
	public void clickOnCarHireResultsMultiElement(String number,String elementName) {
		int i = Integer.parseInt(number);
		CarHireResultsPage.clickOnCarHireResultsMultiElement(elementName,i);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	

}