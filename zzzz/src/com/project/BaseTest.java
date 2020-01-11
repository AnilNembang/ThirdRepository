package com.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {
		public static WebDriver driver;
		public static String projectPath=System.getProperty("user.dir");
		public static Properties p;
		public static Properties or;
		public static FileInputStream fis;
		public static ExtentReports reports=ExtentManager.getInstance();
		public static ExtentTest test;
		
		public static void init() throws IOException{
		fis = new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectPath+"//or.properties");
		or=new Properties();
		or.load(fis);
		
		PropertyConfigurator.configure(projectPath+"//log4j.properties");
		}
		
		public static void launch(String browser) {
			if(p.getProperty(browser).equals("chromebrowser")) {
				System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
				driver=new ChromeDriver();
			}else if(p.getProperty(browser).equals("firefoxbrowser")) {
				System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
				driver=new FirefoxDriver();
			}
			
		}
		
		public static void navigateUrl(String url) {
			driver.get(p.getProperty(url));


	}

}
