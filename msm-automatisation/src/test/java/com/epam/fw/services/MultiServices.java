package com.epam.fw.services;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.epam.fw.object.Options;

public class MultiServices {
	
	private static final Logger log = Logger.getLogger(MultiServices.class);
	
	public static void errorShutdown(Options options) {
		log.info("enter to function errorShutdown");
		getMyScreenshot(options);
//		options.getDriver().quit();
		Thread.currentThread().stop();;
	}
	
	public static void getMyScreenshot(Options options) {
		log.info("enter to function getScreenshot");
		SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy hh;mm;ss SSS zzz");
		Date date = new Date(); 
		String formattedDate= df.format(date);
		File file = ((TakesScreenshot) options.getDriver()).getScreenshotAs(OutputType.FILE);
		String path = "src/test/resources/screenshots/" + formattedDate + ".png";
		File screen = new File(path);
		try {
			FileUtils.copyFile(file, screen);
			log.error("You can see the screenshot with error on this link " + screen.getAbsolutePath());
		} catch (IOException e) {
			log.error("have an error with get screenshot" + e);
		}
	}

}
