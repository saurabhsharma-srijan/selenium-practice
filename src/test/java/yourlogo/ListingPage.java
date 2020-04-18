package yourlogo;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ListingPage {
	static WebDriver driver;
	
	  @Test public void method1() throws InterruptedException {
	  driver.findElement(By.xpath(
	  "//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
	  
	  WebElement item1 = driver.findElement(By.xpath(
	  "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//div[@class='product-image-container']"
	  ));
	  
	  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(item1));  // Explicit wait applied here 
	  
	  item1.click();
	  
	  WebElement iframeElement =
	  driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
	  
	  driver.switchTo().frame(iframeElement);
	  System.out.println("switching to iframe window");
	  
	  driver.findElement(By.xpath("//a[@id='color_14']")).click();
	  System.out.println("choose the other colour");
	  
	  driver.findElement(By.
	  xpath("//a[@class='btn btn-default button-plus product_quantity_up']//span"))
	  .click(); 
	  System.out.println("select the 2 quantity");
	  
	  
		/*
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).
		 * click(); System.out.println("closing iframe window");
		 */
	  
	  driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click(); 
	  System.out.println("added to cart");
	  
	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath("//span[@class='cross']")).click();
	  System.out.println("closing the popup");
	  
	  }

	@Test
	public void method2() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Best sellers')]")).click();

		String actual1 = driver.findElement(By.xpath("//h1[@class='page-heading product-listing']")).getText();
		Assert.assertEquals(actual1, "BEST SELLERS");
		System.out.println("Page heading is:" + actual1);

		Select sorting = new Select(driver.findElement(By.xpath("//select[@id='selectProductSort']")));

		sorting.selectByVisibleText("Product Name: A to Z");
		System.out.println("select page sorting");

		driver.findElement(By.xpath("//i[@class='icon-th-list']")).click();
		System.out.println("select list view");
		Thread.sleep(8000);

		driver.findElement(By.xpath("//i[@class='icon-th-large']")).click();
		System.out.println("select grid view back");

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
