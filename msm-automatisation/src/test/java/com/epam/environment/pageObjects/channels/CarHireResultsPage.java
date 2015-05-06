package com.epam.environment.pageObjects.channels;

import com.epam.fw.shop.PageShop;

import cucumber.api.java.en.Then;

public class CarHireResultsPage extends ChannelPage{
	
	//url items
	protected static final String uri = "/beta/c/carhire/results/";
	protected static final String items = "?searchGadgetForm=true";
	
	
	
	public static void assertOnCarHirePage() {
		PageShop.assertOnPageWithUrl(uri);
	}

}
