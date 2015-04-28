package com.epam.environment.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.fw.object.MyElement;

public class SuperHomePage extends Page {
	
	private static final Logger log = Logger.getLogger(SuperHomePage.class);
	
	protected static final MyElement mobilePhonesLink = new MyElement("mobilePhonesLink", "//div[@class='b-catalogmain']/ul[2]/li[1]//a[2]", "WebElement");
	protected static final MyElement photoCamerasLink = new MyElement("photoCamerasLink", "//div[@class='b-catalogmain']/ul[3]/li[1]//a[2]", "WebElement");
	
	public SuperHomePage(WebDriver driver) {
		super(driver);
	}

}
