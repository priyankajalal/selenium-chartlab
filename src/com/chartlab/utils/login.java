package com.chartlab.utils;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login{
	
	public static void startLogin(WebDriver driver,String baseUrl) throws InterruptedException{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.id("LoginForm_username")).sendKeys("vinodnayal");
		driver.findElement(By.id("LoginForm_password")).sendKeys("p0o9i8u7");
		driver.findElement(By.xpath("//*[@id='login-form']/table/tbody/tr[3]/td[1]/input")).click();
		Thread.sleep(6000);
		
		
	}
}