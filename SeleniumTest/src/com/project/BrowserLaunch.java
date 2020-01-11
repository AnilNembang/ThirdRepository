package com.project;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserLaunch {
	
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jasta\\Desktop\\jars\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.partialLinkText("Element on page that is hidden")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) div:nth-child(6) > h4:nth-child(1)")));
		String actualText=driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) div:nth-child(6) > h4:nth-child(1)")).getText();
		String expectedText="Hello World!";
		if(actualText.equals(expectedText)) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
		
	/*	System.setProperty("webdriver.gecko.driver", "C:\\Users\\jasta\\Desktop\\jars\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.bestbuy.com/");*/
		
	}

}
