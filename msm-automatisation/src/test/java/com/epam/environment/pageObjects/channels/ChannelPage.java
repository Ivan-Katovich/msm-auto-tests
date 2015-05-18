package com.epam.environment.pageObjects.channels;

import java.util.LinkedHashMap;

import com.epam.environment.pageObjects.Page;
import com.epam.fw.object.MyElement;
import com.epam.fw.shop.Shop;
import com.epam.fw.shop.WebElementsShop;

import cucumber.api.java.en.When;

public class ChannelPage extends Page{
	
	protected static final LinkedHashMap<String, MyElement> channelPageElements = new LinkedHashMap<String, MyElement>(){{
		//multi channel elements
		put("searchProgressCircle", new MyElement("//*[@class='round-progress']", "webElement"));
	}};
	
	//multi channel elements
	protected static final MyElement searchProgressCircle = new MyElement("searchProgressCircle", "//span[contains(@class,'search-progress__percentage')]", "webElement");
		
		
	public static void waitForProviders() {
		WebElementsShop.assertElementNotVisible(Shop.getMyElementByName(channelPageElements, "searchProgressCircle"));
		   // see why it shows '' (empty)
	}

}
