package yourlogo;

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

public class Footer {
	static WebDriver driver;

	@Test
	public void footerLinks() {
		driver.findElement(By.xpath("//li[@class='last']//a[contains(text(),'Women')]")).click();
		driver.findElement(By.xpath("//li[@class='item']//a[contains(text(),'Specials')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New products')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Best sellers')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Our stores')]")).click();
		driver.findElement(By.xpath("//li[@class='item']//a[contains(text(),'Contact us')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Terms and conditions of use')]")).click();
		driver.findElement(By.xpath("//a[@title='About us']")).click();
		driver.findElement(By.xpath("//a[@title='Sitemap']")).click();
		System.out.println("check all footer links successfully");

	}

	@Test
	public void myAccountsLinks() {
		driver.findElement(By.xpath("//a[contains(text(),'My orders')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My credit slips')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My addresses')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My personal info')]")).click();
		System.out.println("check my accounts links successfully");

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
		System.out.println("Launch the Chrome Browser");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		System.out.println("Finish and close the Chrome Browser");
	}
}
