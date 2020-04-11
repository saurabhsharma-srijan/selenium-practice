package com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWebsite {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.id("email")).sendKeys("saurabh.sh123@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("srijan@123");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String title = driver.getTitle();
		int titleLength = driver.getTitle().length();
		System.out.println("Successfully logged in website");
		System.out.println("Title of the page is : " + title);
		System.out.println("Length of the title is : " + titleLength);

		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();

	//	driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/p/1/1-home_default.jpg']")).click();
		
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("printed dress");
		
		driver.findElement(By.xpath("//input[@id='search_query_top']")).submit();

		driver.findElement(By.xpath("//span[contains(text(),'saurabh sharma')]")).click();
		driver.findElement(By.xpath("//a[@title='Contact Us']")).click();
		driver.findElement(By.xpath("//a[@class='logout']")).click();

		
	}

}
