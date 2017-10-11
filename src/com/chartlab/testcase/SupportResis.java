package com.chartlab.testcase;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.chartlab.utils.ListUtils;
import com.chartlab.utils.login;

public class SupportResis{
	private WebDriver driver;
	private String baseUrl;
		
	@Before
	public void setUp() throws Exception{
		driver= new ChromeDriver();
		baseUrl = "http://www.chartlabpro.com";	
	}
	
	@Test
	public void testCharts() throws Exception{
		
		login.startLogin(driver, baseUrl);
		
		driver.findElement(By.xpath(".//*[@id='yw0']/li[3]/a")).click();
		Thread.sleep(2000);
		
		WebElement symbolInput = driver.findElement(By.id("chartViewSymbolSearch"));
		symbolInput.clear();
		symbolInput.sendKeys("AAPL");
		symbolInput.sendKeys(Keys.ENTER);	
		Thread.sleep(4000);
		
		String symbolText = driver.findElement(By.id("symbolLivePrice_MyChart")).getText();
		String symbolPrice = symbolText.substring(19, 27);
		Double price = Double.parseDouble(symbolPrice);
		//System.out.println(symbolPrice);
		
		//Scrolling the page downs
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,1000);");
		
		// Finding minimum of Support values
		List<WebElement> supportElements = driver.findElements(By.cssSelector(".support>td"));
		List<String> supportList = ListUtils.getNames(supportElements);
		String minSupport = Collections.min(supportList);
		Double support = Double.parseDouble(minSupport);
		Double minSupportPrice = (price)*(1-0.05);
		
		
		// Finding maximum of Resistance values
		List<WebElement> resistanceElements = driver.findElements(By.cssSelector(".resistance>td"));
		List<String> resistanceList = ListUtils.getNames(resistanceElements);
		String maxResistance = Collections.max(resistanceList);
		Double resistance = Double.parseDouble(maxResistance);
		Double maxResistancePrice = (price)*(1+0.05);
		
		if (support > minSupportPrice  && resistance < maxResistancePrice)
			{
				System.out.println("Support Resistance not Correct");
			}
		else{
			System.out.println("Support Resistance are Correct.");
		}
	
    }
}