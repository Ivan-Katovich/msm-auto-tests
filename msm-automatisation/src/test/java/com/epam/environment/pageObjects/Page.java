package com.epam.environment.pageObjects;

import com.epam.fw.shop.PageShop;
import com.epam.fw.shop.Shop;

import cucumber.api.java.en.When;

public class Page {
	
	public static void startTestComplect(String driverName) {
		Shop.setUpDriver(driverName);
	}
	
	public static void shutdownTestComplect() {
		Shop.shutDownDriver();
	}
	
	public static void waitForPageAbsolutelyLoad() {
		PageShop.waitForPage();
	}

}
