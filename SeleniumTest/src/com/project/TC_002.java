package com.project;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class TC_002 extends BaseTest{
	
	private static final Logger log=Logger.getLogger(TC_002.class.getName());
	
	public static void main(String[] args) throws IOException {
		
		test=reports.startTest("TC_002"); 
		
		
		init();
		log.info("initializing the properties files...");
		test.log(LogStatus.PASS, "initializing the properties files");
		
		launch("chromebrowser");
		log.info("Opened the browser: " +p.getProperty("chromebrowser"));
		test.log(LogStatus.PASS, "Opened the browser: \" +p.getProperty(\"chromebrowser");
		
		navigateUrl("amazonurl");
		log.info("navigated url: " + or.getProperty("amazonurl"));
		test.log(LogStatus.PASS, "navigated url: \" + or.getProperty(\"amazonurl");
		
		selectOption("amazondropbox_id", "amazondroptext");
		log.info("selected "+or.getProperty("amazondropbox_id") + " and entered text: "+or.getProperty("amazondroptext"));
		test.log(LogStatus.PASS, "selected \"+or.getProperty(\"amazondropbox_id\") + \" and entered text: \"+or.getProperty(\"amazondroptext\")");
		
		typeValue("amazonsearchtext_id","amazonsearchtext");
		log.info("moved control to: " + or.getProperty("amazonsearchtext_id")+ "and typed text: "+"'"+or.getProperty("amazonsearchtext")+"'");
		test.log(LogStatus.PASS, "moved control to: \" + or.getProperty(\"amazonsearchtext_id\")+ \"and typed text: \"+\"'\"+or.getProperty(\"amazonsearchtext\")+\"'\"");
		
		reports.endTest(test);
		reports.flush();
		/*clickElement("amazonsearchbutton_xpath");
		clickElement("globalstorelink_linktext");*/
		
		

	
		/*driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Porter");
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
		*/
	
	}



}
