package com.epam.environment.pageObjects.channels;

import com.epam.fw.shop.PageShop;

import cucumber.api.java.en.Then;

public class FlightsResultsPage extends ChannelPage{
	
	//url items
	protected static final String uri = "/beta/c/flight/results/";
	protected static final String items = "?searchGadgetForm=true";
		
		
		
	public static void AssertOnFlightsResultsPage() {
		PageShop.assertOnPageWithUrl(uri);
	}

}
