package com.epam.environment.stepDefinition.channels;

import org.openqa.selenium.WebDriver;

import com.epam.environment.cucumberTests.FirstTestRunner;
import com.epam.environment.pageObjects.channels.ChannelPage;
import com.epam.environment.stepDefinition.Hooks;
import com.epam.environment.stepDefinition.PageSteps;
import com.epam.fw.object.MyElement;
import com.epam.fw.shop.PageShop;
import com.epam.fw.shop.WebElementsShop;

import cucumber.api.java.en.When;

public class ChannelPageSteps {
	
	
	public ChannelPageSteps() {}
	
	@When("^I wait for all providers load$")
	public void waitForProviders() {
		ChannelPage.waitForProviders();
	}

	

}
