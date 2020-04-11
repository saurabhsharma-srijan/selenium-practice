package com.demo;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


public class Testng_Script {

	static WebDriver driver;

	@Test(priority = 4)
	public void method1() {
		driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
		String title = driver.getTitle();
		int titleLength = driver.getTitle().length();
		System.out.println("Title of the page is : " + title);
		System.out.println("Length of the title is : " + titleLength);
		System.out.println("Redirect to cart page");
	}

	@Test(priority = 3)
	public void method2() {
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
	  //driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/p/1/1-home_default.jpg']")).click();
		System.out.println("Redirect to women category");

	}

	@Test(priority = 1)
	public void method3() {
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("printed dress");
		driver.findElement(By.xpath("//input[@id='search_query_top']")).submit();
		System.out.println("searching item on searh box");
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
