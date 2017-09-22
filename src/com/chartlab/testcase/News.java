package com.chartlab.testcase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class News {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://www.chartlabpro.com";
	}

	@Test
	public void testNews() throws Exception {
		driver.get(baseUrl);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.id("LoginForm_username")).sendKeys("vinodnayal");
		driver.findElement(By.id("LoginForm_password")).sendKeys("p0o9i8u7");
		driver.findElement(By.xpath("//*[@id='login-form']/table/tbody/tr[3]/td[1]/input")).click();
		driver.findElement(By.xpath(".//*[@id='yw0']/li[8]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("MarketWatch")).click();

		checkNewscount("#tab_CNBC .news-left>table", 10);
		checkNewscount("#tab_CNBC .news-right>table", 10);
		checkNewscount(".news-left>table", 80);
		checkNewscount(".news-right>table", 80);
		// Total News on the leftside
		List<WebElement> MarketWatch = driver.findElements(By.cssSelector("#tab_MarketWatch .news-left>table"));
		List<Date> newsDates = new ArrayList<Date>();
		for (WebElement newsElement : MarketWatch) {
			WebElement dateElement = newsElement.findElement(By.cssSelector("tbody>tr>td>h4"));
			// print(dateElement.getText());
			DateFormat newsDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
			Date newsDate = newsDateFormat.parse(dateElement.getText());
			// print(newsDate);
			newsDates.add(newsDate);
		}
		Collections.sort(newsDates);
		int lastIndex = newsDates.size() - 1;
		String latestNewsDate = new SimpleDateFormat("yyyyMMdd").format(newsDates.get(lastIndex));
		newsDates.get(newsDates.size() - 1);
		String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		print(latestNewsDate);
		print(currentDate);
		assertEquals(latestNewsDate, currentDate);
	}

	private void print(Object data) {
		System.out.println(data);
	}

	private void checkNewscount(String css, int minCount) {
		assertTrue(driver.findElements(By.cssSelector(css)).size() > minCount);
	}

}