package com.epam.fw.data;

import java.util.ResourceBundle;

import com.epam.fw.object.MyElement;

public final class ConstantData {
	
	//property file
//	private static ResourceBundle dataFile = ResourceBundle.getBundle("prop");
	
	//uri
	public static final String BASE_URI = "http://www.sit1.gb.travelsupermarket.com";
	
	//seleniun grid
	public static final String SELENIUM_HOST_WORKST = "10.6.205.25";
	public static final String SELENIUM_HOST_WORKNOTE = "10.6.169.248";
	public static final String SELENIUM_HOST_LOCAL = "localhost";
	public static final String SELENIUM_HOST_HOME = "192.168.0.101";
	public static final String SELENIUM_HOST_TSM = "services.ci1-cms.gb.travelsupermarket.com";
	public static final String SELENIUM_HOST_TSMJENKINS = "selenium-hub1.inf1.gb.tsm.internal";
	public static final String SELENIUM_PORT = "4444";
	
	//elements
//	public static final MyElement TOP_LOGO = new MyElement("topLogo", "//img[@class='onliner_logo retina-off']", "webelement");
	
	//timeout
	public static final int TIME_OUT = 40000;
	public static final int POOLING = 2000;
	

}
