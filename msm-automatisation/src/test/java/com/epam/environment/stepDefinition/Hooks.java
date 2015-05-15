package com.epam.environment.stepDefinition;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;





import com.epam.environment.pageObjects.Page;
import com.epam.fw.shop.Shop;

import static com.epam.fw.data.ConstantData.*;

public class Hooks {
	
	public Hooks() {
	}
	
	@Before
	public void startTestComplect() throws Exception{
		Page.startTestComplect("RemoteChrome");
		
	}
	
	@After
	public void shutdownTestComplect(Scenario scenario) throws Exception{
		Shop.screenInAfter(scenario);
		Page.shutdownTestComplect();
	}


	
	
	

}
