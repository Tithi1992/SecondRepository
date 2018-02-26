package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumGridSample {

	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() throws MalformedURLException{
		DesiredCapabilities DesiredCapability=new DesiredCapabilities().chrome();
		DesiredCapability.setPlatform(Platform.VISTA);
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapability);
	}

	@Test(description = "To check Login with valid credentials.", priority = 1)
	public void TC1() {
		try {
			// Taking Driver and Open URL
			driver.manage().window().maximize();
			driver.get("https://cygnet.hrinnova.com/login");

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			// Entering UserName
			driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tyshah");

			// Entering Password
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("October@2017");

			// clicking on Login Button
			driver.findElement(By.xpath("//button[contains(@class,'login-btn')]")).click();

			// Performing Logout
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='navbar']/ul/li[1]/a")).click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
			Thread.sleep(2000);

			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
