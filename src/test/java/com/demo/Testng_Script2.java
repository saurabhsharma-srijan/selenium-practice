package com.demo;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Testng_Script2 {
	static WebDriver driver;

	@Test
	public void method1() {
		driver.findElement(By.xpath("//span[contains(text(),'saurabh sharma')]")).click();
		driver.findElement(By.xpath("//a[@title='Contact Us']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Redirect to myaccount & contactus pages");
	}

	@Test
	public void method2() {
		driver.findElement(By.xpath("//li[@class='item']//a[contains(text(),'Specials')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New products')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Redirect to Special  & NewProduct pages");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.id("email")).sendKeys("saurabh.sh123@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("srijan@123");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("enter url and Logged in the website successfully");
	}

	@AfterMethod
	public void afterMethod() {
		driver.findElement(By.xpath("//a[@class='logout']")).click();
		System.out.println("Logout from the website successfully");
	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Starting Test On Chrome Browser");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		System.out.println("Finished and closed Test On Chrome Browser");
	}

}
