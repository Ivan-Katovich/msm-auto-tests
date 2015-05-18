package com.epam.environment.pageObjects.channels;

import java.util.LinkedHashMap;

import com.epam.fw.object.MyElement;
import com.epam.fw.shop.PageShop;
import com.epam.fw.shop.Shop;
import com.epam.fw.shop.WebElementsShop;

import cucumber.api.java.en.Then;

public class CarHireResultsPage extends ChannelPage{
	
	//url items
	protected static final String uri = "/beta/c/carhire/results/";
	protected static final String items = "?searchGadgetForm=true";
	
	protected static final LinkedHashMap<String, MyElement> carHireResultsElements = new LinkedHashMap<String, MyElement>(){{
		//multi channel elements
		put("viewDealButtons", new MyElement("//span[@class='card__view-deal-btn-text']", "groupOfElements"));
	}};
	
	
	
	public static void assertOnCarHirePage() {
		PageShop.assertOnPageWithUrl(uri);
	}
	
	public static void clickOnCarHireResultsMultiElement(String elementName, int number) {
		WebElementsShop.clickOnElement(WebElementsShop.getMyElementFromGroup(Shop.getMyElementByName(carHireResultsElements, elementName), number));
	}

}
