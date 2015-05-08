package com.epam.fw.shop;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.epam.fw.object.MyElement;
import com.epam.fw.object.Options;
import com.epam.fw.services.FieldsServices;
import com.epam.fw.services.MultiServices;
import com.epam.fw.services.WebElementsServices;

public class FieldsShop extends Shop {
	
	private static final Logger log = Logger.getLogger(FieldsShop.class);
	  
    public static void fillFieldByValue(MyElement myElement, String value) {
    	log.info("enter to function fillFieldByValue '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
		options.setText(value);
    	if (WebElementsServices.waitElementIsVisible(options)) {
			log.info("element is visible" );
			switch (myElement.getType()) {
			case "text":
				FieldsServices.sendTextToField(options);
				log.info("Text entered in the textfield");
				break;
			case "dropdown":
				FieldsServices.selectDropdownMenu(options);
				log.info("Dropdown option is selected");
				break;
			case "altdropdown":
				FieldsServices.selectAltDropdownMenu(options);
				log.info("Dropdown option is selected");
				break;
			case "button":
				if (value == "click") {
					WebElementsShop.clickOnElement(myElement);
				}
				log.info("Button is clicked");
				break;
			case "radio":
				FieldsServices.selectRadiobutton(options);
				log.info("Radiobutton is selected");
				break;
			case "checkbox":
				if (value == "click") {
					WebElementsShop.clickOnElement(myElement);
				}
				log.info("Checkbox option is selected");
				break;
			case "datepicker":
				WebElementsShop.clickOnElement(myElement);
				FieldsServices.selectDate(options);
				log.info("Datpicker option is selected");
				break;
			case "autocomplete":
//				Actions actions = new Actions(driver);
				FieldsServices.sendTextToField(options);
//				WebElementsShop.clickOnElement(myElement, driver);
				driver.findElement(options.getSelector()).sendKeys(Keys.ENTER);
//				WebElementsShop.clickOnElement(myElement);
				// for TSM project needs to check on another
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (driver.findElements(By.xpath(myElement.getXpath()+"/following-sibling::div")).size()!=0) {
					WebElementsShop.clickOnElement(myElement);
				}
//				actions.keyDown(autocomplete, Keys.ENTER).keyUp(autocomplete, Keys.ENTER).perform();
				log.info("Text entered in the textfield");
				break;	
			default:
				log.error("element is not field type" );
				options.setErrorMessage("element is not field type");
				MultiServices.errorShutdown(options);
			}
		} else {
			log.error("element is not visible" );
			options.setErrorMessage("element is not visible");
			MultiServices.errorShutdown(options);
		}
    }
    
    public static void fillFormByProfile(LinkedHashMap<MyElement, String> map) {
    	log.info("enter to function fillFormByProfile");
    	options.setDriver(driver);
    	try {
    		for (MyElement element : map.keySet()) {
    			if (element == null || map.get(element) == null) {
    				log.warn("Element or value is wrong");
    			} else {
    				fillFieldByValue(element, map.get(element));
    			}
    		}
    	} catch (Exception e) {
    		log.error("Something wrong with profile " + e.getClass());
    		options.setErrorMessage("Something wrong with profile " + e.getClass());
    		MultiServices.errorShutdown(options);
    	}
    }

}
