package com.epam.fw.services;

import static com.epam.onliner.data.ConstantData.TIME_OUT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.sikuli.script.FindFailed;

import com.epam.fw.object.Options;

public class ImageServices {
	
	private static final Logger log = Logger.getLogger(ImageServices.class); 
	
	public static boolean isImagePathCorrect(Options options) {
		log.info("enter to function isImagePathCorrect with element '" + options.getMyImage().getName() + "'");
		Pattern pat = Pattern.compile("src/test/resources/imgs/\\w+.png");
		Matcher mat = pat.matcher(options.getMyImage().getPath());
		return mat.matches();
	}
	
	public static boolean waitImageIsVisible(Options options) {
		log.info("enter to function waitImageIsVisible with element '" + options.getMyImage().getName() + "'");
		try {
			options.getScreen().wait(options.getPattern(), TIME_OUT/1000);
			log.info("image '" + options.getMyImage().getName() + "' was found ");
			return true;
		} catch (FindFailed e) {
			log.error("can't find image " + options.getMyImage().getName() + "'");
			return false;
		}
	}

}
