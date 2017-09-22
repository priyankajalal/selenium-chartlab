package com.chartlab.testcase;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class login{
	
	public static void main (String[] args){
		ChromeDriver driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.chartlabpro.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.id("LoginForm_username")).sendKeys("golden2424");
		driver.findElement(By.id("LoginForm_password")).sendKeys("riley");
		driver.findElement(By.xpath("//*[@id='login-form']/table/tbody/tr[3]/td[1]/input")).click();
		
		
	}
}