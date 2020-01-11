package com.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BaseTest {
	public static WebDriver driver;
	//public means it can be used anywhere
	//static means can be used repeatedly without allocating memory
	public static String projectPath=System.getProperty("user.dir");
	public static Properties p;
	public static Properties or;
	public static FileInputStream fis;
	public static ExtentReports reports=ExtentManager.getInstance();
	public static ExtentTest test;
	
	public static void init() throws IOException {
		fis=new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectPath+"//or.properties");
		or=new Properties();
		or.load(fis);
		
		PropertyConfigurator.configure(projectPath+"//log4j.properties");
		
	}
	
	public static void launch(String browser) {
		if(p.getProperty(browser).equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}else if(p.getProperty(browser).equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}

	}
	

	public static void navigateUrl(String url) {
			driver.get(p.getProperty(url));
		
	}
	
	public static WebElement getElement(String locatorKey) {
		WebElement element=null;
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element=driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element=driver.findElement(By.partialLinkText(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_tagname")) {
			element=driver.findElement(By.tagName(or.getProperty(locatorKey)));
		}
		
		return element;
	}

	public static void selectOption(String locatorKey, String option) {
		getElement(locatorKey).sendKeys(or.getProperty(option));
		
	}
	public static void typeValue(String locatorKey, String value) {
		getElement(locatorKey).sendKeys(or.getProperty(value));
		
	}
	
	public static void clickElement(String locatorKey) {
		getElement(locatorKey).click();
		
	}
	
/*	public static void verifyElement(String value, String locatorKey) {
		String actualValue=getElement(locatorKey).getText();
		if(actualValue.equalsIgnoreCase(or.getProperty(value))){
			System.out.println("Both links are equal");
		}else {
			System.out.println("Both links are not equal");
		
	}*/
	public static boolean verifyElement(String value, String locatorKey) {
		String actualValue=getElement(locatorKey).getText();
		if(actualValue.equalsIgnoreCase(or.getProperty(value))){
			return true;
			//System.out.println("Both links are equal");
		}else 
			return false;
			//System.out.println("Both links are not equal");

	}
	
	private static void takeScreenshot() throws IOException {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\sel\\screenshot" + (new Random().nextInt())+".jpg"));
		test.log(LogStatus.INFO, "Screenshot --> "+ test.addScreenCapture(projectPath+"\\failure\\"+"screenshots"+(new Random().nextInt())+".jpg"));
	}
	
	public static void reportSuccess(String msg) {
		test.log(LogStatus.PASS, msg);
		
	}
	
	public static void reportFailure(String msg) throws IOException {
		test.log(LogStatus.FAIL, msg);
		takeScreenshot();
		
	}

}
