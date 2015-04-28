package com.epam.onliner.data;

import java.util.ResourceBundle;

import com.epam.fw.object.MyElement;

public final class ConstantData {
	
	//property file
//	private static ResourceBundle dataFile = ResourceBundle.getBundle("prop");
	
	//uri
	public static final String MAIN_PAGE_URI = "http://www.onliner.by/";
	public static final String CATALOG_AND_PRICE_PAGE_URI = "http://catalog.onliner.by/";
	public static final String TECHNOLOGY_PAGE_URI = "http://tech.onliner.by/";
	public static final String AUTO_PAGE_URI = "http://auto.onliner.by/";
	public static final String AUTO_FLEA_MAEKET_PAGE_URI = "http://ab.onliner.by/";
	public static final String PEOPLE_PAGE_URI = "http://people.onliner.by/";
	public static final String REALTY_URI = "http://realt.onliner.by/";
	public static final String FLEA_MAEKET_PAGE_URI = "http://baraholka.onliner.by/";
	public static final String FORUM_PAGE_URI = "http://forum.onliner.by/";
	
	//seleniun grid
	public static final String SELENIUM_HOST_MOSVM = "10.6.131.33";
	public static final String SELENIUM_HOST_LOCAL = "localhost";
	public static final String SELENIUM_HOST_HOME = "192.168.0.101";
	public static final String SELENIUM_PORT = "4444";
	
	//elements
	public static final MyElement TOP_LOGO = new MyElement("topLogo", "//img[@class='onliner_logo retina-off']", "webelement");
	
	//timeout
	public static final int TIME_OUT = 15000;
	public static final int POOLING = 2000;
	

}
