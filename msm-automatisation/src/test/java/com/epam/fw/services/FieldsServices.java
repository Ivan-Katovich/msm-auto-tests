package com.epam.fw.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.epam.fw.object.MyElement;
import com.epam.fw.object.Options;

public class FieldsServices {
	
	private static final Logger log = Logger.getLogger(FieldsServices.class); 
	
	public static void selectDropdownMenu(Options options) {
		log.info("enter to function selectDropdownMenu in fields services with element '" + options.getMyElement().getName() + "'");
		try {
			By valueSelector = By.xpath(options.getMyElement().getXpath() + "//*[text()='" + options.getText() + "']");
			log.info(valueSelector.toString());
			options.setSelector(valueSelector);
			if (!WebElementsServices.waitElementIsPresent(options)) {
				log.error("No such value in this field");
				MultiServices.errorShutdown(options);
			} else {
				options.getDriver().findElement(options.getSelector()).click();
			}
//			Select sel = new Select(options.getDriver().findElement(options.getSelector()));
//			sel.selectByVisibleText(options.getText());
			log.info("Complete field '" + options.getMyElement().getName() + "' with value " + options.getText());
		} catch (Exception e) {
			log.error("Something wrong" + e.getClass());
			MultiServices.errorShutdown(options);
		}
	}
	
	public static void selectRadiobutton(Options options) {
		log.info("enter to function selectRadiobutton in fields services with element '" + options.getMyElement().getName() + "'");
		try {
			By valueSelector = By.xpath(options.getMyElement().getXpath() + "//*[text()='" + options.getText() + "']/preceding-sibling::input");
			options.setSelector(valueSelector);
			if (!WebElementsServices.waitElementIsPresent(options)) {
				log.error("No such radiobutton");
				MultiServices.errorShutdown(options);
			} else {
				options.getDriver().findElement(options.getSelector()).click();
			}
			log.info("Complete field '" + options.getMyElement().getName() + "' with value " + options.getText());
		} catch (Exception e) {
			log.error("Something wrong" + e.getClass());
			MultiServices.errorShutdown(options);
		}
	}
	
	public static void selectDate(Options options) {
		log.info("enter to function selectDate in fields services with element '" + options.getMyElement().getName() + "'");
		try {
			String[] items = options.getText().split(" ");
			String thisXpath = options.getMyElement().getXpath();
			options.getMyElement().setName("year");
			options.getMyElement().setType("dropdown");
			options.getMyElement().setXpath(thisXpath+"/following-sibling::div//select[contains(@class,'year')]");
			options.setText(items[2]);
			selectDropdownMenu(options);
			options.getMyElement().setName("month");
			options.getMyElement().setType("dropdown");
			options.getMyElement().setXpath(thisXpath+"/following-sibling::div//select[contains(@class,'month')]");
			options.setText(items[1]);
			selectDropdownMenu(options);
			By valueSelector = By.xpath(thisXpath+"/following-sibling::div//*[text()='" + items[0] + "']");
			options.setSelector(valueSelector);
			if (!WebElementsServices.waitElementIsPresent(options)) {
				log.error("No such element");
				MultiServices.errorShutdown(options);
			} else {				
				try {
					options.getDriver().findElement(valueSelector).click();
				} catch (Exception e) {
					log.error("Something wrong" + e.getClass());
				}
			}
			log.info("Complete date picker '" + options.getMyElement().getName() + "' with value " + items[0]+" "+items[1]+" "+items[2]);
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
