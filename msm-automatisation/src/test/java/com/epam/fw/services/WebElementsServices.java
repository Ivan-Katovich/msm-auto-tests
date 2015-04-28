package com.epam.fw.services;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.epam.fw.object.Options;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class WebElementsServices {
	
	private static final Logger log = Logger.getLogger(WebElementsServices.class); 
    
    public static boolean waitElementIsVisible(Options options) {
    	log.info("enter to function waitElementIsVisible with element '" + options.getMyElement().getName() + "'");
    	long time = new Date().getTime();
    	long endTime = time+options.getTimeout();
    	int pooling = options.getPooling(); 
    	
    	if (time>=endTime) {
    		log.error("Timeout is not correct ");
    		return false;
    	} else {
    		try {
    			WebElement element = options.getWebElement();
    			if (element.isDisplayed()) {
    				log.info("element '" + options.getMyElement().getName() + "' is displayed ");
    				return true;
    			} else {
    				log.warn("element '" + options.getMyElement().getName() + "'is not displayed now ");
    				while (!element.isDisplayed() && time <= endTime) {
    					log.info(time + " lower " + endTime );
    					try {
    						Thread.sleep(pooling);
    					} catch (InterruptedException e) {
    						log.error(e.getClass());
    					}
    					time = new Date().getTime();
    				}
    				if (time >= endTime) {
    					log.error("Element '" + options.getMyElement().getName() + "' is not displayed ");
    					return false;
    				} else {
    					log.info("element '" + options.getMyElement().getName() + "' is displayed now ");
    					return true;
    				}
    			}
    		}
    		catch (NoSuchElementException e) {
    			log.error(e.getClass());
    			return false;
    		}
    	}
    }
    
    public static boolean waitElementIsPresent(Options options) {
    	log.info("enter to function waitElementIsPresent with element '" + options.getMyElement().getName() + "'");
    	
    	long time = new Date().getTime();
    	long endTime = time+options.getTimeout();
    	int pooling = options.getPooling(); 
    	
    	if (time>=endTime) {
    		log.error("Timeout is not correct ");
    		return false;
    	} else {
    		try {
    			if (options.getDriver().findElements(options.getSelector()).size()>0) {
    				log.info("element '" + options.getMyElement().getName() + "' is present ");
    				return true;
    			} else {
    				log.warn("element '" + options.getMyElement().getName() + "' is not present now ");
    				while (options.getDriver().findElements(options.getSelector()).size()<1 && time <= endTime) {
    					log.info(time + " lower " + endTime );
    					try {
    						Thread.sleep(pooling);
    					} catch (InterruptedException e) {
    						log.error(e.getClass());
    					}
    					time = new Date().getTime();
    				}
    				if (time >= endTime) {
    					log.error("Element '" + options.getMyElement().getName() + "' is not present ");
    					return false;
    				} else {
    					log.info("element '" + options.getMyElement().getName() + "' is present now ");
    					return true;
    				}
    			}
    		}
    		catch (Exception e) {
    			log.error(e.getClass());
    			return false;
    		}
    	}
    }
    
    public static boolean waitElementIsNotVisible(Options options) {
    	log.info("enter to function waitElementIsNotVisible with element '" + options.getMyElement().getName() + "'");
    	long time = new Date().getTime();
    	long endTime = time+options.getTimeout();
    	int pooling = options.getPooling(); 
    	
    	if (time>=endTime) {
    		log.error("Timeout is not correct ");
    		return false;
    	} else {
    		try {
    			WebElement element = options.getWebElement();
    			if (!element.isDisplayed()) {
    				log.info("element '" + options.getMyElement().getName() + "' is not displayed ");
    				return true;
    			} else {
    				log.warn("element '" + options.getMyElement().getName() + "' is displayed now ");
    				while (element.isDisplayed() && time <= endTime) {
    					log.info(time + " lower " + endTime );
    					try {
    						Thread.sleep(pooling);
    					} catch (InterruptedException e) {
    						log.error(e.getClass());
    					}
    					time = new Date().getTime();
    				}
    				if (time >= endTime) {
    					log.error("Element '" + options.getMyElement().getName() + "' is displayed ");
    					return false;
    				} else {
    					log.info("element '" + options.getMyElement().getName() + "' is not displayed now ");
    					return true;
    				}
    			}
    		}
    		catch (NoSuchElementException e) {
    			log.error(e.getClass());
    			return false;
    		}
    	}
    }
    
    public static String getAttributeValue(Options options) {
    	log.info("enter to function getAttributeValue with element '" + options.getMyElement().getName() + "'");
    	try {
    		return options.getWebElement().getAttribute(options.getName());
    	} catch (Exception e) {
    		log.error("Something wrong " + e.getClass());
    		return null;
    	}
    }
    
    public static String getElementText(Options options) {
    	log.info("enter to function getText with element '" + options.getMyElement().getName() + "'");
    	try {
    		return options.getWebElement().getText();
    	} catch (Exception e) {
    		log.error("Something wrong " + e.getClass());
    		return null;
    	}
    }
    
    public static boolean setAttributeValue(Options options) {
    	log.info("enter to function setAttributeValue with element '" + options.getMyElement().getName() + "'");
    	String xpath = options.getMyElement().getXpath();
    	try {
    		JavascriptExecutor executor = (JavascriptExecutor) options.getDriver();
    		log.info("Try to execute script: document.getElementByXPath = function(sValue) { var a = this.evaluate(sValue, this, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null); if (a.snapshotLength > 0) { return a.snapshotItem(0); } };" +
    				"document.getElementByXPath(\"" + xpath + "\").setAttribute(\"" + options.getName() + "\", \"" + options.getText() +"\")");
    		executor.executeScript(
    				"document.getElementByXPath = function(sValue) { var a = this.evaluate(sValue, this, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null); if (a.snapshotLength > 0) { return a.snapshotItem(0); } };" +
    				"document.getElementByXPath(\"" + xpath + "\").setAttribute(\"" + options.getName() + "\", \"" + options.getText() +"\")"
    				);
    		return true;
    	} catch (Exception e) {
    		log.error("Something wrong " + e.getClass());
    		return false;
    	}
    }
    
    public static int getElementsNumber(Options options) {
    	log.info("enter to function getElementsNumber with elements '" + options.getMyElement().getName() + "'");
    	String itemType = options.getMyElement().getType();
    	if (itemType == "groupOfElements") {
    		return options.getDriver().findElements(By.xpath(options.getMyElement().getXpath())).size();
    	} else {
    		log.info("Item type is " + itemType + " but needed groupOfElements ");
    		return -1;
    	}
    }
    
    public static int getElementWithTextPosition(Options options) {
    	log.info("enter to function getElementWithTextPosition ");
    	int matchNumber = 0;
    	int position = 0;
    	ArrayList<WebElement> list = getArrayOfElements(options);
    	if (list == null) {
    		log.info("Item type is " + options.getMyElement().getType() + " but needed groupOfElements ");
    		return -1;
    	} else {
    		for (WebElement element : list) {
    			if (options.getText().equals(element.getText())) {
    				position = list.indexOf(element) + 1;
    				matchNumber =+ 1;
    			}
    		}
    		if (matchNumber == 0) {
    			return 0;
    		} else {
    			if (matchNumber > 1) {
    				return -2;
    			} else {
    				return position;
    			}
    		}
		}
    }
    
    public static int getElementContainsTextPosition(Options options) {
    	log.info("enter to function getElementContainsTextPosition ");
    	int matchNumber = 0;
    	int position = 0;
    	ArrayList<WebElement> list = getArrayOfElements(options);
    	if (list == null) {
    		log.info("Item type is " + options.getMyElement().getType() + " but needed groupOfElements ");
    		return -1;
    	} else { 
    		for (WebElement element : list) {
    			if (element.getText().indexOf(options.getText()) != -1) {
    				position = list.indexOf(element) + 1;
    				matchNumber =+ 1;
    			}
    		}
    		if (matchNumber == 0) {
    			return 0;
    		} else {
    			if (matchNumber > 1) {
    				return -2;
    			} else {
    				return position;
    			}
    		}
		}
    }
    
    public static Float getNumberFromElementText(Options options) {
    	log.info("enter to function getNumberFromElementText with elements '" + options.getMyElement().getName() + "'");
    	String text = getElementText(options);
    	if (text.equals(null)) {
    		return null;
    	} else {
    		Pattern pat = Pattern.compile("[0-9]+[.]?[0-9]*");
    		Matcher mat = pat.matcher(text);
    		if (mat.find()) {
    			Float numberInText = Float.parseFloat(mat.group());
    			return numberInText;
    		} else {
    			log.warn("No numbers in this text ");
    			return null;
    		}
    	}
    }
    
    public static ArrayList<WebElement> getArrayOfElements(Options options) {
    	log.info("enter to function getArrayOfElements with group of elements '" + options.getMyElement().getName() + "'");
    	ArrayList<WebElement> list;
    	String itemType = options.getMyElement().getType();
    	if (itemType == "groupOfElements") {
    		list = (ArrayList<WebElement>)options.getDriver().findElements(By.xpath(options.getMyElement().getXpath()));
    		return list;
    	} else {
    		log.warn("Item type is '" + itemType + "' but needed 'groupOfElements' ");
    		return null;
    	}
    }
     
}
