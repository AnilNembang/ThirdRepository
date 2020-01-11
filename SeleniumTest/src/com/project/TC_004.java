package com.project;

import java.io.IOException;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class TC_004 extends BaseTest{
	
	public static void main(String[] args) throws IOException {

		test=reports.startTest("TC_001");
		
		init();
		//log.info("properties files initializing");
		test.log(LogStatus.PASS,"initializing property files" );
		
		launch("chromebrowser");
		//log.info("Launching: "+ p.getProperty("chromebrowser"));
		test.log(LogStatus.PASS, "Launching Browser: "+p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		//log.info("Navigating url: "+p.getProperty("amazonurl"));
		test.log(LogStatus.PASS, "Navigating url: "+p.getProperty("amazonurl"));
		/*
		//String actutalText=driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(5)")).getText();
		String actualText=driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		System.out.println(actualText);
		String expectedText="customer Service";
		
		if(actualText.equalsIgnoreCase(expectedText)){
			System.out.println("Both links are equal");
		}else {
			System.out.println("Both links are not equal");
		}*/
		
		verifyElement("expectedValue", "customerservice_linktext");
		
		if (!verifyElement("expectedValue", "customerservice_linktext")) {
			reportFailure("Both links are not equal");
		}else
			reportSuccess("Both Links are equal");
		
		reports.endTest(test);
		reports.flush();
		
	}



}
