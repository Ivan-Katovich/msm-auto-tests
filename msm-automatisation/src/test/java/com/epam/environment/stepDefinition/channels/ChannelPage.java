package com.epam.environment.stepDefinition.channels;

import org.openqa.selenium.WebDriver;

import com.epam.environment.cucumberTests.TestRunner;
import com.epam.environment.stepDefinition.Page;
import com.epam.fw.object.MyElement;
import com.epam.fw.shop.PageShop;
import com.epam.fw.shop.WebElementsShop;

import cucumber.api.java.en.When;

public class ChannelPage extends TestRunner{
	
	//multi channel elements
	protected static final MyElement searchProgressCircle = new MyElement("searchProgressCircle", "//span[contains(@class,'search-progress__percentage')]", "webElement");
	
	@When("^I wait for all providers load$")
	public void waitForProviders() {
		WebElementsShop.assertElementDynamicTextBecame(searchProgressCircle, "100 %", driver);
	    // see whi it shows '' (empty)
	}

	

}
