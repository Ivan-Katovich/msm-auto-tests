package com.epam.fw.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.epam.fw.object.Options;

public class FieldsServices {
	
	private static final Logger log = Logger.getLogger(FieldsServices.class); 
	
	public static void selectDropdownMenu(Options options) {
		log.info("enter to function selectDropdownMenu in fields services with element '" + options.getMyElement().getName() + "'");
		try {
			if (!WebElementsServices.waitElementIsVisible(options)) {
				log.error("No such field on this page");
				MultiServices.errorShutdown(options);
			} else {
				By valueSelector = By.xpath(options.getMyElement().getXpath() + "//*[text()='" + options.getText() + "']");
				options.setSelector(valueSelector);
				if (!WebElementsServices.waitElementIsPresent(options)) {
					log.error("No such value in this field");
					MultiServices.errorShutdown(options);
				} else {
					options.getDriver().findElement(options.getSelector()).click();
				}
			}
//			Select sel = new Select(options.getDriver().findElement(options.getSelector()));
//			sel.selectByVisibleText(options.getText());
			log.info("Complete field '" + options.getMyElement().getName() + "' with value " + options.getText());
		} catch (Exception e) {
			log.error("Something wrong" + e.getClass());
			MultiServices.errorShutdown(options);
		}
	}
	
	public static void sendTextToField(Options options) {
		log.info("enter to function sendTextToField in fields services");
		if (options.getText().equals("")) {
			log.warn("Text is not entered");
			MultiServices.errorShutdown(options);
		} else {
			try {
				options.getDriver().findElement(options.getSelector()).clear();
				options.getDriver().findElement(options.getSelector()).sendKeys(options.getText());
				log.info("Complete field '" + options.getMyElement().getName() + "' with value " + options.getText());
			} catch (NoSuchElementException e) {
				log.error("Something wrong " + e.getClass());
				MultiServices.errorShutdown(options);
			}
			
		}
	}

}
