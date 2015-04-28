package com.epam.fw.shop;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.fw.object.MyElement;
import com.epam.fw.object.Options;
import com.epam.fw.services.FieldsServices;
import com.epam.fw.services.MultiServices;
import com.epam.fw.services.WebElementsServices;

public class WebElementsShop extends Shop{
	
	private static final Logger log = Logger.getLogger(WebElementsShop.class);
	
	public static void assertElementVisible(MyElement myElement, WebDriver driver) {
		log.info("enter to function assertElementVisible with element '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
		if (WebElementsServices.waitElementIsVisible(options)) {
			log.info("element '" + myElement.getName() + "' is visible" );
		} else {
			log.error("element '" + myElement.getName() + "' is not visible shutdown" );
			MultiServices.errorShutdown(options);
		}
	}
	
	public static void assertElementPresent(MyElement myElement, WebDriver driver) {
		log.info("enter to function assertElementPresent with element '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
		if (WebElementsServices.waitElementIsPresent(options)) {
			log.info("element '" + myElement.getName() + "' is present" );
		} else {
			log.error("element '" + myElement.getName() + "' is not present shutdown" );
			MultiServices.errorShutdown(options);
		}
	}
    
    public static void clickOnElement(MyElement myElement, WebDriver driver) {
    	log.info("enter to function clickOnElement with element '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
		if (WebElementsServices.waitElementIsVisible(options)) {
			log.info("visible true");
			driver.findElement(options.getSelector()).click();
		} else {
			log.info("visible false shutdown");
			MultiServices.errorShutdown(options);
		}
	}
    
    public static void assertElementHasText(MyElement myElement, String expectedText, WebDriver driver) {
    	log.info("enter to function assertElementHasText with element '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
    	if (!WebElementsServices.waitElementIsVisible(options)) {
    		log.error("Element '" + myElement.getName() + "' is not visible, shutdown" );
    		MultiServices.errorShutdown(options);
    	} else {
    		String text = WebElementsServices.getElementText(options);
    		if (text == null || !text.equals(expectedText)) {
    			log.error("Element '" + myElement.getName() + "' has text '" + text + "' but expexted '" + expectedText + "' shutdown");
    			MultiServices.errorShutdown(options);
    		} else {
    			log.info("Element '" + myElement.getName() + "' has text '" + text + "' expexted '" + expectedText);
    		}
    	}
    }
    
    public static void assertElementContainsText(MyElement myElement, String expectedText, WebDriver driver) {
    	log.info("enter to function assertElementContainsText with element '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
    	if (!WebElementsServices.waitElementIsVisible(options)) {
    		log.error("Element '" + myElement.getName() + "' is not visible, shutdown" );
    		MultiServices.errorShutdown(options);
    	} else {
    		String text = WebElementsServices.getElementText(options);
    		if (text == null || text.indexOf(expectedText) == -1) {
    			log.error("Element '" + myElement.getName() + "' has text '" + text + "' not contains '" + expectedText + "' shutdown");
    			MultiServices.errorShutdown(options);
    		} else {
    			log.info("Element '" + myElement.getName() + "' has text '" + text + "' contains '" + expectedText);
    		}
    	}
    }
    
    public static void assertElementAttributeHasValue(MyElement myElement, String attributeName, String attributeValue, WebDriver driver) {
    	log.info("enter to function assertElementAttributeHasValue with element '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
		options.setName(attributeName);
		if (!WebElementsServices.waitElementIsVisible(options)) {
    		log.error("Element '" + myElement.getName() + "' is not visible, shutdown" );
    		MultiServices.errorShutdown(options);
    	} else {
    		String value = WebElementsServices.getAttributeValue(options);
    		if (value == null || !value.equals(attributeValue)) {
    			log.error("Element '" + myElement.getName() + "' has attribute '" + attributeName + "' with value '" + value + "' but expexted value '" + attributeValue + "' shutdown");
    			MultiServices.errorShutdown(options);
    		} else {
    			log.info("Element '" + myElement.getName() + "' has attribute '" + attributeName + "' with value '" + value + "' expexted value '" + attributeValue);
    		}
    	}
    }
    
    public static void setElementAttributeValue(MyElement myElement, String attributeName, String attributeValue, WebDriver driver) {
    	log.info("enter to function setElementAttributeValue with element '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
		options.setName(attributeName);
		options.setText(attributeValue);
		if (!WebElementsServices.waitElementIsVisible(options)) {
    		log.error("Element " + myElement.getName() + " is not visible shutdown" );
    		MultiServices.errorShutdown(options);
		} else {
			if (WebElementsServices.setAttributeValue(options)) {
				if (WebElementsServices.getAttributeValue(options).equals(attributeValue)) {
					log.info("element's '" + myElement.getName() + "' attribute '" + attributeName + "' value is seted to '" + attributeValue + "'");
				} else {
					log.info("element's '" + myElement.getName() + "' attribute '" + attributeName + "' value isn't seted to '" + attributeValue + "'");
					MultiServices.errorShutdown(options);
				}
			} else {
				log.error("can't set value '" + attributeValue + "' in element's '" + myElement.getName() + "' attribute '" + attributeName + "'" );
	    		MultiServices.errorShutdown(options);
			}
		}
    }
    
    public static void assertElementsNumber(MyElement myElement, String compareType, int expectedNumber, WebDriver driver) {
    	log.info("enter to function assertElementsNumber with elements '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
    	int itemNumber = WebElementsServices.getElementsNumber(options);
    	if (itemNumber == -1) {
    		log.error("Element '" + myElement.getName() + "' has not right type " );
    		MultiServices.errorShutdown(options);
    	} else {
    		switch (compareType) {
			case "equal":
				if (itemNumber != expectedNumber) {
					log.error("Items '" + myElement.getName() + "' number " + itemNumber + " is not equal to expected number " + expectedNumber);
					MultiServices.errorShutdown(options);
				} else {
					log.info("Items '" + myElement.getName() + "' number " + itemNumber + " is equal to expected number " + expectedNumber);
				}
				break;
			case "more":
				if (itemNumber <= expectedNumber) {
					log.error("Items '" + myElement.getName() + "' number " + itemNumber + " is less or equal to expected number " + expectedNumber);
					MultiServices.errorShutdown(options);
				} else {
					log.info("Items '" + myElement.getName() + "' number " + itemNumber + " is more than expected number " + expectedNumber);
				}
				break;
			case "less":
				if (itemNumber >= expectedNumber) {
					log.error("Items number '" + itemNumber + "' is more or equal to expected number " + expectedNumber);
					MultiServices.errorShutdown(options);
				} else {
					log.info("Items '" + myElement.getName() + "' number " + itemNumber + " is less than expected number " + expectedNumber);
				}
				break;
			case "more or equal":
				if (itemNumber < expectedNumber) {
					log.error("Items '" + myElement.getName() + "' number " + itemNumber + " is less than expected number " + expectedNumber);
					MultiServices.errorShutdown(options);
				} else {
					log.info("Items '" + myElement.getName() + "' number " + itemNumber + " is more or equal to expected number " + expectedNumber);
				}
				break;
			case "less or equal":
				if (itemNumber > expectedNumber) {
					log.error("Items '" + myElement.getName() + "' number " + itemNumber + " is more than expected number " + expectedNumber);
					MultiServices.errorShutdown(options);
				} else {
					log.info("Items '" + myElement.getName() + "' number " + itemNumber + " is less or equal to expected number " + expectedNumber);
				}
				break;
			default:
				log.error("Compare type is wrong. It can be only equal / more / less / more or equal / less or equal " );
				MultiServices.errorShutdown(options);
			}
    	}
    }
    
    public static void assertElementWithTextPosition(MyElement myElement, String elementText, int expectedPosition, WebDriver driver) {
    	log.info("enter to function assertElementWithTextPosition with element '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
		options.setText(elementText);
		int position = WebElementsServices.getElementWithTextPosition(options);
		if (position == -1) {
			log.error("Element '" + myElement.getName() + "' has not right type " );
			MultiServices.errorShutdown(options);
		} else {
			if (position == 0) {
				log.error("Noone element with expected text " );
				MultiServices.errorShutdown(options);
			} else {
				if (position == -2) {
					log.error("More than one element with expected text " );
					MultiServices.errorShutdown(options);
				} else {
					if (position != expectedPosition) {
						log.error("Item with text " + elementText + " position is " + position + " but expected " + expectedPosition);
						MultiServices.errorShutdown(options);
					} else {
						log.info("Item with text " + elementText + " position is " + position + " is equal to expected " + expectedPosition);
					}
				}
			}
		}
    }
    
    public static void assertElementContainsTextPosition(MyElement myElement, String elementText, int expectedPosition, WebDriver driver) {
    	log.info("enter to function assertElementContainsTextPosition with element '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
		options.setText(elementText);
		int position = WebElementsServices.getElementContainsTextPosition(options);
		if (position == -1) {
			log.error("Element has not right type " );
			MultiServices.errorShutdown(options);
		} else {
			if (position == 0) {
				log.error("Noone element contains expected text '" + elementText + "'" );
				MultiServices.errorShutdown(options);
			} else {
				if (position == -2) {
					log.error("More than one element contain expected text '" + elementText + "'" );
					MultiServices.errorShutdown(options);
				} else {
					if (position != expectedPosition) {
						log.error("Item containing text " + elementText + " position is " + position + " but expected " + expectedPosition);
						MultiServices.errorShutdown(options);
					} else {
						log.info("Item containing text " + elementText + " position is " + position + " is equal to expected " + expectedPosition);
					}
				}
			}
		}
    }
    
    public static void assertElementContainsNumber(MyElement myElement, WebDriver driver) {
    	log.info("enter to function assertElementContainsNumber with element '" + myElement.getName() + "'");
		options.setDriver(driver);
		options.setMyElement(myElement);
		if (!WebElementsServices.waitElementIsVisible(options)) {
			log.error("element '" + myElement.getName() + "' is not visible shutdown" );
			MultiServices.errorShutdown(options);
		} else {
			Float numberInText = WebElementsServices.getNumberFromElementText(options);
			if (numberInText == null) {
				log.error("element '" + myElement.getName() + "' hasn't got a number in text " );
				MultiServices.errorShutdown(options);
			} else {
				log.info("element '" + myElement.getName() + "' has te text which contains number '" + numberInText + "' " );
			}
		}
    }
    
    public static void assertOrderOfElementsNumbers(MyElement myElement, String compareType, WebDriver driver) {
    	log.info("enter to function assertOrderOfElementsNumbers with element '" + myElement.getName() + "'");
    	options.setDriver(driver);
		options.setMyElement(myElement);
		ArrayList<WebElement> list = WebElementsServices.getArrayOfElements(options);
		if (list == null) {
			log.error("can't create array with '" + myElement.getName() + "'" );
			MultiServices.errorShutdown(options);
		} else {
			switch (compareType) {
			case "equal":
				for (int i = 1; i < list.size(); i++) {
					options.setWebElement(list.get(i));
					float num = WebElementsServices.getNumberFromElementText(options);
					options.setWebElement(list.get(i-1));
					float preNum = WebElementsServices.getNumberFromElementText(options);
					if (num != preNum) {
						log.error("Numbers in elements '" + myElement.getName() + "' is not equal ");
						MultiServices.errorShutdown(options);
					}
					log.info("Items '" + myElement.getName() + "' have equal numbers " );
				}
				break;
			case "more":
				for (int i = 1; i < list.size(); i++) {
					options.setWebElement(list.get(i));
					float num = WebElementsServices.getNumberFromElementText(options);
					options.setWebElement(list.get(i-1));
					float preNum = WebElementsServices.getNumberFromElementText(options);
					if (num <= preNum) {
						log.error("Numbers in elements '" + myElement.getName() + "' don't increase ");
						MultiServices.errorShutdown(options);
					}
					log.info("Numbers in elements '" + myElement.getName() + "' increase " );
				}
				break;
			case "less":
				for (int i = 1; i < list.size(); i++) {
					options.setWebElement(list.get(i));
					float num = WebElementsServices.getNumberFromElementText(options);
					options.setWebElement(list.get(i-1));
					float preNum = WebElementsServices.getNumberFromElementText(options);
					if (num >= preNum) {
						log.error("Numbers in elements '" + myElement.getName() + "' don't decrease ");
						MultiServices.errorShutdown(options);
					}
					log.info("Numbers in elements '" + myElement.getName() + "' decrease " );
				}
				break;
			case "more or equal":
				for (int i = 1; i < list.size(); i++) {
					options.setWebElement(list.get(i));
					float num = WebElementsServices.getNumberFromElementText(options);
					options.setWebElement(list.get(i-1));
					float preNum = WebElementsServices.getNumberFromElementText(options);
					if (num < preNum) {
						log.error("Numbers in elements '" + myElement.getName() + "' don't increase and are not the same ");
						MultiServices.errorShutdown(options);
					}
					log.info("Numbers in elements '" + myElement.getName() + "' increase or the same" );
				}
				break;
			case "less or equal":
				for (int i = 1; i < list.size(); i++) {
					options.setWebElement(list.get(i));
					float num = WebElementsServices.getNumberFromElementText(options);
					options.setWebElement(list.get(i-1));
					float preNum = WebElementsServices.getNumberFromElementText(options);
					if (num > preNum) {
						log.error("Numbers in elements '" + myElement.getName() + "' don't decrease and are not the same ");
						MultiServices.errorShutdown(options);
					}
					log.info("Numbers in elements '" + myElement.getName() + "' decrease or the same" );
				}
				break;
			default:
				log.error("Compare type is wrong. It can be only equal / more / less / more or equal / less or equal " );
				MultiServices.errorShutdown(options);
			}
		}
    }
 

}
