package com.project;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotExp {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jasta\\Desktop\\jars\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://newtours.demoaut.com/");
			driver.findElement(By.name("userName")).sendKeys("mercury1");
			driver.findElement(By.name("password")).sendKeys("mercury");
			driver.findElement(By.name("login")).click();
			driver.findElement(By.name("findFlights")).click();
			driver.findElement(By.name("reserveFlights")).click();
			driver.findElement(By.name("passFirst0")).sendKeys("John");
			driver.findElement(By.name("passLast0")).sendKeys("Smith");
			driver.findElement(By.name("creditnumber")).sendKeys("535323535355");
			driver.findElement(By.name("buyFlights")).click();
			String actualText=driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p > font > b > font:nth-child(2)")).getText();
			String expectedText="Your itinerary has been booked!";
			
			if(actualText.equals(expectedText)) {
				System.out.println("Test case passed");
			}else {
				System.out.println("Test case failed");
			}
		}
		catch(Exception ex) {
			takeScreenshot();
		}


	}
	
	private static void takeScreenshot() throws IOException {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\sel\\screenshot" + (new Random().nextInt())+".jpg"));
	}

}
