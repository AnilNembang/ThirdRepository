package com.project;

import java.io.IOException;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest{
	private static final Logger log=Logger.getLogger(TC_003.class.getName());
	public static void main(String[] args) throws IOException {
		
		init();
		log.info("initializing properties...");
		
		launch("firefoxbrowser");
		log.info("launching "+p.getProperty("firefoxbrowser"));
		
		navigateUrl("bestbuyurl");
		log.info("navigating "+p.getProperty("bestbuyurl"));
		
	}
}
