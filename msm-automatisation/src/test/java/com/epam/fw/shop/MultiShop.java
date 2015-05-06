package com.epam.fw.shop;

import org.apache.log4j.Logger;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.LinkedHashMap;

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



public class MultiShop extends Shop{
	
	private static final Logger log = Logger.getLogger(MultiShop.class);
	
	public static MyElement getMyElementByName(LinkedHashMap<String, MyElement> map, String elementName) {
    	log.info("enter to function getElementByName");
    	options.setDriver(driver);
    	try {
    		return map.get(elementName);
    	} catch (Exception e) {
    		log.error("Something wrong with profile " + e.getClass());
    		options.setErrorMessage("Something wrong with profile " + e.getClass());
    		MultiServices.errorShutdown(options);
    		return null;
    	}
    }

}
