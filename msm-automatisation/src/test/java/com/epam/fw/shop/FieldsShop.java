package com.epam.fw.shop;

import java.awt.RenderingHints.Key;
import java.util.Date;
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
				long time = new Date().getTime();
		    	long endTime = time+options.getTimeout();
		    	int pooling = options.getPooling();
		    	
				FieldsServices.sendTextToField(options);
				
				if (driver.findElements(By.xpath(myElement.getXpath()+"/following-sibling::div")).size() == 0) {
//					log.error(" ===== in if");
					do {
//						log.error(" ===== in while");
						try {
							Thread.sleep(pooling);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						time = new Date().getTime();
					} while (driver.findElements(By.xpath(myElement.getXpath()+"/following-sibling::div")).size() == 0 && time <= endTime);
					if (time >= endTime) {
						log.error("autocomplete dropdown is not defined" );
						options.setErrorMessage("autocomplete dropdown is not defined");
						MultiServices.errorShutdown(options);
					}
				}
				driver.findElement(options.getSelector()).sendKeys(Keys.ENTER);
				// for TSM project needs to check on another
				if (driver.findElements(By.xpath(myElement.getXpath()+"/following-sibling::div")).size()!=0) {
//					log.error(" ===== in if");
					do {
//						log.error(" ===== in while");
						try {
							Thread.sleep(pooling);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
//						log.error(" ===== after sleep");
						WebElementsShop.clickOnElement(myElement);
//						log.error(" ===== after click");
						time = new Date().getTime();
					} while (driver.findElements(By.xpath(myElement.getXpath()+"/following-sibling::div")).size()!=0);
					if (time >= endTime) {
						log.error("autocomplete dropdown is not closed" );
						options.setErrorMessage("autocomplete dropdown is not closed");
						MultiServices.errorShutdown(options);
					}
				}
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
