package com.chartlab.testcase;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.chartlab.utils.ListUtils;
import com.chartlab.utils.login;

public class OverviewPage {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://www.chartlabpro.com";
	}

	@Test
	public void testOverview() throws Exception {
		login.startLogin(driver, baseUrl);

		List<WebElement> indicesList = driver.findElements(By.xpath("//*[@id='indicesListView']/li/a/div[1]"));

		List<String> indicesNameList = ListUtils.getNames(indicesList);
		// System.out.println(indicesNameList);

		Map<String, String> indicesMap = ListUtils.listToMap(indicesNameList);
		// System.out.println(indicesMap);

		for (String value : indicesMap.values()) {
			Double newValue = Double.parseDouble(value);
			Double minValue = (newValue) * (1 - 0.01);
			Double maxValue = (newValue) * (1 + 0.01);
			// System.out.println(newValue);

			if (newValue > minValue && newValue < maxValue) {
				System.out.println("Correct Price");

			} else {
				System.out.println("Incorrect Price");

			}
		}

	}

}