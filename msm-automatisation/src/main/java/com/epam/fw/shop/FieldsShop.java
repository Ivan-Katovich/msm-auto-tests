package com.epam.fw.shop;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.fw.object.MyElement;
import com.epam.fw.object.Options;
import com.epam.fw.services.FieldsServices;
import com.epam.fw.services.MultiServices;
import com.epam.fw.services.WebElementsServices;

public class FieldsShop extends Shop {
	
	private static final Logger log = Logger.getLogger(FieldsShop.class);
	  
    public static void fillFieldByValue(MyElement myElement, String value, WebDriver driver) {
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
			default:
				log.error("element is not field type" );
			}
		} else {
			log.error("element is not visible" );
			MultiServices.errorShutdown(options);
		}
    }
    
    public static void fillFormByProfile(LinkedHashMap<MyElement, String> map, WebDriver driver) {
    	log.info("enter to function fillFormByProfile");
    	options.setDriver(driver);
    	try {
    		for (MyElement element : map.keySet()) {
    			if (element == null || map.get(element) == null) {
    				log.warn("Element or value is wrong");
    			} else {
    				fillFieldByValue(element, map.get(element), driver);
    			}
    		}
    	} catch (Exception e) {
    		log.error("Something wrong with profile " + e.getClass());
    		MultiServices.errorShutdown(options);
    	}
    }

}
