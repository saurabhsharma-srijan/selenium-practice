package yourlogo;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Header {
	static WebDriver driver;

	@Test
	public void headerLinks() {
		driver.findElement(By.xpath("//span[contains(text(),'saurabh sharma')]")).click();
		driver.findElement(By.xpath("//a[@title='Contact Us']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Redirect to myaccount & contactus pages");

		// Instantiate Action Class
		Actions actions = new Actions(driver);

		WebElement women = driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]"));

		actions.moveToElement(women).perform();
		System.out.println("Done Mouse hover on women category");
		
		WebElement tshirt = driver.findElement(By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'T-shirts')]"));
		tshirt.click();
		System.out.println(" going to tshirt subcategory");

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
