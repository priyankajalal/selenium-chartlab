package com.chartlab.testcase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.chartlab.utils.*;

public class Charts{
	private WebDriver driver;
	private String baseUrl;
		
	@Before
	public void setUp() throws Exception{
		driver= new ChromeDriver();
		baseUrl = "http://www.chartlabpro.com";	
	}
	
	@Test
	public void testCharts() throws Exception{
		
		//login loginChartlab = new login();
		login.startLogin(driver, baseUrl);
		
		driver.findElement(By.xpath(".//*[@id='yw0']/li[3]/a")).click();
		Thread.sleep(2000);
		
		//Verifying default value of the input box in left which should be "MSFT"
		WebElement symbolInput = driver.findElement(By.id("chartViewSymbolSearch"));
		String inputDefaultValue = symbolInput.getAttribute("value");
		assertEquals(inputDefaultValue,"MSFT");
		
		symbolInput.clear();
		symbolInput.sendKeys("GOOG");
		Thread.sleep(2000);
		symbolInput.sendKeys(Keys.ENTER);
		String newSymbol = symbolInput.getAttribute("value");
		//System.out.println(newSymbol);
		Thread.sleep(2000);
		verifySymbolName(newSymbol);
		
		//Scrolling the page down
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,700);");
		
		//Comparing with Peer symbols
		List<String> expectedPeers = Arrays.asList("AKAM","GOOG","GOOGL","TRIP","YHOO");
		List<WebElement> actualPeers = driver.findElements(By.cssSelector(".greenInfo"));
		
		boolean isSubList=ListUtils.isSubLst(ListUtils.getNames(actualPeers), expectedPeers);
		assertTrue(isSubList);
		
		
		
		
	}
	
	public void verifySymbolName(String symbol) throws InterruptedException{
		//Verifying the full name of the symbol in the middle of the page
		String symbolTextMiddle = driver.findElement(By.id("symbolLivePrice_MyChart")).getText();
		assertTrue(symbolTextMiddle.contains(symbol));
				
		//Verifying the full name of the symbol on the right of the page
		String symbolTextRight = driver.findElement(By.cssSelector(".overview.synopsis_Symbol")).getText();
		assertTrue(symbolTextRight.contains(symbol));
		
	}
}