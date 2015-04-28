package com.epam.fw.shop;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.epam.fw.object.MyImage;
import com.epam.fw.services.ImageServices;
import com.epam.fw.services.MultiServices;

import static com.epam.onliner.data.ConstantData.*;

public class ImageShop extends Shop {
	
	private static final Logger log = Logger.getLogger(ImageShop.class);
	
	public static void assertImageOnPage(MyImage image, WebDriver driver) {
		log.info("enter to function assertImageOnPage " + image.getName() + "'");
		options.setDriver(driver);
		options.setMyImage(image);
		if (ImageServices.waitImageIsVisible(options)) {
			log.info("image '" + image.getName() + "' was found ");
		} else {
			log.error("can't find image " + image.getName() + "'");
			MultiServices.errorShutdown(options);
		}
	}

}
