package com.epam.fw.services;

import static com.epam.onliner.data.ConstantData.*;
import java.util.Date;
import org.apache.log4j.Logger;
import com.epam.fw.object.Options;


public class PageServices {
	
	private static final Logger log = Logger.getLogger(PageServices.class);
	
	public static boolean waitForPageLoaded(Options options) {
		log.info("enter to function waitForPageLoaded");
    	options.setMyElement(TOP_LOGO);
    	return WebElementsServices.waitElementIsVisible(options);
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

}
