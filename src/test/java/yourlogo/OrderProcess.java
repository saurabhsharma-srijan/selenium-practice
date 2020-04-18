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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class OrderProcess {
	static WebDriver driver;

	@Test
	public void method() throws InterruptedException {		

		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("blouse");
		driver.findElement(By.xpath("//input[@id='search_query_top']")).submit();
		System.out.println("searching item on searh box");
		driver.findElement(By.xpath("//a[@class='product_img_link']//img[@title='Blouse']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']//span")).click();
		driver.findElement(By.xpath("//select[@id='group_1']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'L')]")).click();
		driver.findElement(By.xpath("//a[@id='color_8']")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		System.out.println("added to cart");

WebElement proceedButton  = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));

new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(proceedButton));  // Explicit wait applied here
proceedButton.click();

		System.out.println("proceed to checkout");
				
		driver.findElement(By.xpath(
				"//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]"))
				.click();
		System.out.println("Redirecting to Address tab");

		WebElement checkbox = driver.findElement(By.xpath("//input[@id='addressesAreEquals']"));
		Boolean result = checkbox.isSelected();
		System.out.println("Is checkbox selected for same address :" + result);

		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Order should be delivered asap");

		driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
		System.out.println("Redirecting to Shipping tab");
		
		String addTitle = driver.findElement(By.xpath("//p[contains(text(),'Choose a shipping option for this address: My Home')]")).getText();
		Assert.assertEquals(addTitle, "Choose a shipping option for this address: My Home Address123");
		System.out.println("Verify shipping address title on page");

		driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
				
		driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).click();
		driver.findElement(By.xpath("//a[@class='iframe']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).click();
		System.out.println("open and closed the terms and condition");
        driver.findElement(By.id("cgv")).click();
		System.out.println("select checkbox for terms and condition");
		driver.findElement(By.name("processCarrier")).click();
		System.out.println("Redirecting to Payment tab");
		
		String totalPrice = driver.findElement(By.xpath("//td[@id='total_price_container']")).getText();
		System.out.println("Total order price is : " + totalPrice);
		WebElement checkOption = driver.findElement(By.xpath("//a[@class='cheque']"));
		if (checkOption.isDisplayed());
		{ 
			checkOption.click();
			System.out.println("Select the check payment option");
		}
		
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
		System.out.println("Confirm the order");
		
		String ordersuccess = driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
		Assert.assertEquals(ordersuccess, "Your order on My Store is complete.");
		System.out.println("Order is placed successfully");	
		
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
	
	  @AfterMethod public void afterMethod() {
	  driver.findElement(By.xpath("//a[@class='logout']")).click();
	  System.out.println("Logout from the website successfully"); 
	  }
	 

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Launch the Chrome Browser");
	}

	  @AfterClass public void afterClass() { 
	  driver.close();
	  System.out.println("Finish and close the Chrome Browser");
	  
	  }
	 

}
