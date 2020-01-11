package com.project;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

public class TC_001 extends BaseTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");
		driver.manage().window().maximize();
		System.out.println(	driver.getTitle());
		//Removeing cookies
		/*driver.manage().deleteAllCookies();
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.close();
		driver.quit();*/
		
		//WebElement test=driver.findElement(By.id("twotabsearchtextbox"));
		//test.sendKeys("sony");
		/*Thread.sleep(3000);
		test.clear();
		Thread.sleep(4000);
		test.sendKeys("Mac");
		driver.close();*/
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
		//driver.findElement(By.linkText("New Releases")).click();
		//driver.findElement(By.partialLinkText("lease")).click();
		
		List<WebElement> value = driver.findElements(By.tagName("a"));
		
		for(int i=0; i<value.size();i++) {
			if(!value.get(i).getText().isEmpty()) {
				String toBePrinted=value.get(i).getText();
				System.out.println(toBePrinted);
			}
		}
	}

}
