package com.project;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;


public class TC_001 extends BaseTest{
	public static Logger log=Logger.getLogger(TC_001.class.getName());
	
	
	public static void main(String[] args) throws IOException {
		test=reports.startTest("TC_001");
		
		init();
		log.info("properties files initializing");
		test.log(LogStatus.PASS,"initializing property files" );
		
		launch("chrome");
		log.info("Launching: "+ p.getProperty("chrome"));
		test.log(LogStatus.PASS, "Launching Browser: "+p.getProperty("chrome"));
		
		navigateUrl("amazonurl");
		log.info("Navigating url: "+p.getProperty("amazonurl"));
		test.log(LogStatus.PASS, "Navigating url: "+p.getProperty("amazonurl"));
		
		reports.endTest(test);
		reports.flush();
	}

}
