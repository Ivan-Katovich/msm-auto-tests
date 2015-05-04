package com.epam.environment.cucumberTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features"
		,glue="com/epam/environment/stepDefinition"
		,monochrome = true
		,tags = {"@run"}
		,format = {"pretty","html:reports"}
//		,dryRun = true
		)
 
public class TestRunner {
	
	protected static WebDriver driver;
//	protected static Page page;
	
	@BeforeClass
	public static void startTestComplect() throws Exception{
//		URL gridHost = new URL("http://"+SELENIUM_HOST_HOME+":"+SELENIUM_PORT+"/wd/hub");
//		URL gridHost = new URL("http://localhost:4444/wd/hub");
//		URL gridHost = new URL("http://192.168.0.101:4444/wd/hub");
//		DesiredCapabilities capability = DesiredCapabilities.firefox();
//		driver = new RemoteWebDriver(gridHost, capability);
		driver = new FirefoxDriver();
//	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	    driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void shutdownTestComplect() throws Exception{
		driver.close();
//		Thread.sleep(1000); 
	    driver.quit();
//	    Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
//	    Thread.sleep(5000);
//	    Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
//	    Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
	}
 
}
