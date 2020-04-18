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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class DetailPage {
	static WebDriver driver;

	@Test
	public void method1() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("blouse");
		WebElement searchterm = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		String ss = searchterm.getAttribute("value");
		System.out.println("search term is:" + ss);

		searchterm.submit();
		System.out.println("perform searching an item on searh box");
		driver.findElement(By.xpath("//a[@class='product_img_link']//img[@title='Blouse']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("5");
		System.out.println("select the 5 quantity");

		Select size = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
		size.selectByVisibleText("L");
		System.out.println("select the large size");

		driver.findElement(By.xpath("//a[@id='color_8']")).click();
		System.out.println("choose the other colour");

		driver.findElement(By.id("wishlist_button")).click();
		driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).click();
		System.out.println("added to wishlist");

		driver.findElement(By.xpath("//a[@class='open-comment-form']")).click();
		System.out.println("Open Review section");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),'5')]")).click();

		driver.findElement(By.xpath("//input[@id='comment_title']")).sendKeys("test title");
		driver.findElement(By.xpath("//textarea[@id='content']")).sendKeys("test comment : nice product");
		driver.findElement(By.xpath("//button[@id='submitNewMessage']//span[contains(text(),'Send')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
		System.out.println("submit Review on product");

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
