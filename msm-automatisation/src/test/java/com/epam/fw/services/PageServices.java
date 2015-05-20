package com.epam.fw.services;

import static com.epam.fw.data.ConstantData.*;

import java.util.Date;

import org.apache.log4j.Logger;

import com.epam.fw.object.Options;
import com.gargoylesoftware.htmlunit.javascript.host.Console;

import org.openqa.selenium.JavascriptExecutor;


public class PageServices {
	
	private static final Logger log = Logger.getLogger(PageServices.class);
	
	public static boolean waitForPageLoaded(Options options) {
		log.info("enter to function waitForPageLoaded");
		long time = new Date().getTime();
    	long endTime = time+options.getTimeout();
    	int pooling = options.getPooling(); 
		try {
			Thread.sleep(pooling);
    		JavascriptExecutor executor = (JavascriptExecutor) options.getDriver();
    		log.info(" ========= "+executor.executeScript("return document.readyState"));
    		if (executor.executeScript("return document.readyState").equals("complete")) {
    			return true;
    		} else {
    			while (!executor.executeScript("return document.readyState").equals("complete") && time <= endTime) {
					log.info(time + " lower " + endTime );
					try {
						Thread.sleep(pooling);
					} catch (InterruptedException e) {
						log.error(e.getClass());
					}
					time = new Date().getTime();
				}
    			if (time >= endTime) {
					return false;
				} else {
					return true;
				}
    		}
    	} catch (Exception e) {
    		log.error("Something wrong " + e.getClass());
    		return false;
    	}
	}
	
	public static String getPageCurrentUrl(Options options) {
		log.info("enter to function getPageUrl");
		try {
			return options.getDriver().getCurrentUrl();
		} catch (Exception e) {
			log.error(e.getClass());
			return null;
		}
		
	}
	
	public static String urlCreator(Options options) {
		log.info("enter to function getPageUrl");
		String uri;
		try {
			if (options.getItems() == null) {
				uri = BASE_URI+options.getUri();
			} else {
				uri = BASE_URI+options.getUri()+options.getItems();
			}
			return uri;
		} catch (Exception e) {
			log.error(e.getClass());
			return null;
		}
	}
	
	public static boolean isUriChange(Options options) {
		log.info("enter to function isUriChange");
		String oldUri = options.getDriver().getCurrentUrl();
		long time = new Date().getTime();
    	long endTime = time+options.getTimeout();
    	int pooling = options.getPooling(); 
    	
    	System.out.println(time + " lower " + endTime);
    	do {
    		try {
				Thread.sleep(pooling);
			} catch (InterruptedException e) {
				log.error(e.getClass());
			}
    		time = new Date().getTime();
//    		System.out.println(time + " lower " + endTime);
//    		System.out.println(oldUri + " ======= " + options.getDriver().getCurrentUrl());
    	} while (oldUri.equals(options.getDriver().getCurrentUrl()) && time <= endTime);
//    	System.out.println(oldUri + " ======= " + options.getDriver().getCurrentUrl());
//    	System.out.println(time + " lower " + endTime);
    	if (time >= endTime) {
			log.error("URL is not changed ");
			return false;
		} else {
			log.info("URL is changed");
			return true;
		}
    	
	}

}
