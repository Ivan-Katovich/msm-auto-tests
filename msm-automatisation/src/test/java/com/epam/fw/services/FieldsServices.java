package com.epam.fw.services;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.epam.fw.object.MyElement;
import com.epam.fw.object.Options;

public class FieldsServices {
	
	
	public static void selectDropdownMenu(Options options) {
		try {
//			options.getDriver().findElement(By.xpath(options.getMyElement().getXpath())).click();
//			options.getDriver().findElement(By.xpath(options.getMyElement().getXpath())).sendKeys(options.getText());
//			options.getDriver().findElement(By.xpath(options.getMyElement().getXpath())).click();
//			Thread.sleep(1000);
			By valueSelector = By.xpath(options.getMyElement().getXpath() + "//option[text()='" + options.getText() + "']");
			options.setSelector(valueSelector);
			if (!WebElementsServices.waitElementIsPresent(options)) {
				options.setErrorMessage("No such value in this field");
				MultiServices.errorShutdown(options);
			} else {
				options.getDriver().findElement(options.getSelector()).click();
			}
//			Select sel = new Select(options.getDriver().findElement(By.xpath(options.getMyElement().getXpath())));
//			sel.deselectAll();
//			sel.selectByVisibleText(options.getText());
			
		} catch (Exception e) {
			options.setErrorMessage("Something wrong" + e.getClass());
			MultiServices.errorShutdown(options);
		}
	}
	
	public static void selectAltDropdownMenu(Options options) {
		try {
//			options.getDriver().findElement(By.xpath(options.getMyElement().getXpath())).click();
			options.getDriver().findElement(options.getSelector()).sendKeys(options.getText());
//			options.getDriver().findElement(By.xpath(options.getMyElement().getXpath())).click();
//			Thread.sleep(1000);
		} catch (Exception e) {
			options.setErrorMessage("Something wrong" + e.getClass());
			MultiServices.errorShutdown(options);
		}
	}
	
	public static void selectRadiobutton(Options options) {
		try {
			By valueSelector = By.xpath(options.getMyElement().getXpath() + "//*[text()='" + options.getText() + "']");
			options.setSelector(valueSelector);
			if (!WebElementsServices.waitElementIsPresent(options)) {
				options.setErrorMessage("No such radiobutton");
				MultiServices.errorShutdown(options);
			} else {
				options.getDriver().findElement(options.getSelector()).click();
			}
		} catch (Exception e) {
			options.setErrorMessage("Something wrong" + e.getClass());
			MultiServices.errorShutdown(options);
		}
	}
	
	public static void selectDate(Options options) {
		try {
			String[] items = options.getText().split(" ");
			String thisXpath = options.getMyElement().getXpath();
			options.getMyElement().setName("year");
			options.getMyElement().setType("dropdown");
			options.getMyElement().setXpath(thisXpath+"/following-sibling::div//select[contains(@class,'year')]");
			options.setText(items[2]);
//			log.info(thisXpath+"/following-sibling::div//select[contains(@class,'year')]");
			selectDropdownMenu(options);
			options.getMyElement().setName("month");
			options.getMyElement().setType("dropdown");
			options.getMyElement().setXpath(thisXpath+"/following-sibling::div//select[contains(@class,'month')]");
			options.setText(items[1]);
			selectDropdownMenu(options);
			options.getMyElement().setName("day");
			By valueSelector = By.xpath(thisXpath+"/following-sibling::div//*[text()='" + items[0] + "']");
			options.setSelector(valueSelector);
			if (!WebElementsServices.waitElementIsPresent(options)) {
//				log.error("No such element");
				options.setErrorMessage("No such element");
				MultiServices.errorShutdown(options);
			} else {				
				try {
					options.getDriver().findElement(valueSelector).click();
				} catch (Exception e) {
//					log.error("Something wrong" + e.getClass());
				}
			}
//			log.info("Complete date picker '" + options.getMyElement().getName() + "' with value " + items[0]+" "+items[1]+" "+items[2]);
		} catch (Exception e) {
//			log.error("Something wrong" + e.getClass());
			options.setErrorMessage("Something wrong" + e.getClass());
			MultiServices.errorShutdown(options);
		}
		
		
	}
	
	public static void sendTextToField(Options options) {
//		log.info("enter to function sendTextToField in fields services");
		if (options.getText().equals("")) {
//			log.warn("Text is not entered");
			options.setErrorMessage("Text is not entered");
			MultiServices.errorShutdown(options);
		} else {
			try {
				options.getDriver().findElement(options.getSelector()).clear();
				options.getDriver().findElement(options.getSelector()).sendKeys(options.getText());
//				log.info("Complete field '" + options.getMyElement().getName() + "' with value " + options.getText());
			} catch (NoSuchElementException e) {
//				log.error("Something wrong " + e.getClass());
				options.setErrorMessage("Something wrong " + e.getClass());
				MultiServices.errorShutdown(options);
			}
			
		}
	}

}
