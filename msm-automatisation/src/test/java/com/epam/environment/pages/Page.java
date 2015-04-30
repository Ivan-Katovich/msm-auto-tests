package com.epam.environment.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;

import com.epam.fw.object.MyElement;
import com.epam.fw.object.MyImage;

public class Page {
	
	
	protected final WebDriver driver;
	
	public Page(WebDriver driver) {
        this.driver = driver;
    }

	public WebDriver getDriver() {
		return this.driver;
	}

}
