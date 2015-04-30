package com.epam.environment.tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.epam.environment.pages.SuperHomePage;
import com.epam.environment.pages.channels.ChannelPage;
import com.epam.environment.pages.channels.FlightsResultsPage;
import com.epam.environment.tests.BaseTestShell;


public class OpenMSMTest extends BaseTestShell{
	
	private static final Logger log = Logger.getLogger(OpenMSMTest.class);
	private static SuperHomePage superHomePage;
	private static FlightsResultsPage flightsResultsPage;
	
	@Before
	public void startTest() {
//		http://adeptqa.blogspot.com/2012/12/seleniumtestng-20.html
//		DOMConfigurator.configure("./log4j.xml");
		log.info("\n \n === Open test starts === \n");
	}
	
	@Test
	public void fillFilterFormTest() {
		superHomePage = SuperHomePage.goToSuperHomePage(driver);
		log.info("SuperhomePage was created");
		superHomePage.checkSuperHomePageContentSGF();
		superHomePage.fillFlightsFormByMinimumProfile();
		flightsResultsPage = superHomePage.goToFlightsResultsPageWithMinimumProfile();
	}
	
	
	
	@After
	public void endTest() {
		log.info("\n \n === Open test ends === \n");
	}

}
