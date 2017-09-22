package com.chartlab.testcase;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Watchlist{
	private WebDriver driver;
	private String baseUrl;
	
	
	@Before
	public void setUp() throws Exception{
		driver = new ChromeDriver();
		baseUrl = "http://www.chartlabpro.com";		
	}
	
	@Test
	public void testWatchlist() throws Exception{
		BasicConfigurator.configure();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.id("LoginForm_username")).sendKeys("vinodnayal");
		driver.findElement(By.id("LoginForm_password")).sendKeys("p0o9i8u7");
		Thread.sleep(200);
		
		driver.findElement(By.xpath("//*[@id='login-form']/table/tbody/tr[3]/td[1]/input")).click();
		Thread.sleep(800);
		driver.findElement(By.xpath("//*[@id='yw0']/li[2]/a")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(".//*[@id='allPortfolioTabView']/button")).click();
		
		driver.findElement(By.xpath(".//*[@id='watchlistNameEnter']")).sendKeys("nreportfolio");
		driver.findElement(By.xpath(".//*[@id='addWatchlist']")).click();
		
		driver.findElement(By.xpath(".//*[@id='tabNav']/li[4]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(".//*[@id='yw0']/li[3]/a")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(".//*[@id='yw0']/li[8]/a")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.className(".create-btn")));
		
		element.click();
		driver.findElement(By.className(".create-btn")).click();
		driver.findElement(By.id("watchlistNameEnter")).sendKeys("Automation_test");
		driver.findElement(By.id("addWatchlist")).click();
		
		
	}
		
}