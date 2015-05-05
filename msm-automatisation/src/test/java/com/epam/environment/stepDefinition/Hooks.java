package com.epam.environment.stepDefinition;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static WebDriver driver;
//	protected static Page page;
	public Hooks() {
	}
	
	@Before
	public void startTestComplect() throws Exception{
//		URL gridHost = new URL("http://"+SELENIUM_HOST_HOME+":"+SELENIUM_PORT+"/wd/hub");
//		URL gridHost = new URL("http://localhost:4444/wd/hub");
//		URL gridHost = new URL("http://192.168.0.101:4444/wd/hub");
//		DesiredCapabilities capability = DesiredCapabilities.firefox();
//		driver = new RemoteWebDriver(gridHost, capability);
		driver = new FirefoxDriver();
//	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	    driver.manage().window().maximize();
//		return new SuperHomePage(driver);
		
	}
	
	@After
	public void shutdownTestComplect() throws Exception{
		driver.close();
//		Thread.sleep(1000); 
	    driver.quit();
//	    Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
//	    Thread.sleep(5000);
//	    Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
//	    Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	

}
