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
	
	//remote drivers
	private static final String remoteChrome = "RemoteChrome";
	private static final String remoteFirefox = "RemoteFirefox";
	
	//drivers
	private static final String chrome = "Chrome";
	private static final String firefox = "Firefox";
	
	//grid hosts
	private static final String tsmGrid = "TSMGrid";
	private static final String tsmJenkinsGrid = "TSMJenkinsGrid";
	private static final String localGrid = "LocalGrid";
	private static final String homeGrid = "HomeGrid";
	private static final String workGrid = "WorkGrid";
	
	
	public Hooks() {
	}
	
	@Before
	public void startTestComplect() {
		try {
			Page.startTestComplect(remoteFirefox, tsmGrid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@After
	public void shutdownTestComplect(Scenario scenario) throws Exception{
		Shop.screenInAfter(scenario);
		Page.shutdownTestComplect();
	}


	
	
	

}
