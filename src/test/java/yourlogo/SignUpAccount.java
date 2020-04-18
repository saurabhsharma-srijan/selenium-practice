package yourlogo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpAccount {
	static WebDriver driver;

	@Test(priority = 0)
	public void signUp() {

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.id("email_create")).sendKeys("testing110@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		System.out.println("click on createaccount button");

		WebDriverWait wait = new WebDriverWait(driver, 5);   // apply explicit wait here
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_gender1']"))).click();

		System.out.println("select radio button");

		driver.findElement(By.id("customer_firstname")).sendKeys("Saurabh");
		driver.findElement(By.id("customer_lastname")).sendKeys("Atrey");
		driver.findElement(By.id("passwd")).sendKeys("srijan@123");

		String emailId = driver.findElement(By.id("email")).getAttribute("value");
		Assert.assertNotNull(emailId);
		System.out.println("This line is executed because assertNotNull have passed");

		Select day = new Select(driver.findElement(By.id("days")));
		day.selectByValue("20");
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByValue("11");
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue("2000");
		System.out.println("Select DOB");

		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		System.out.println("select checkboxes");

		driver.findElement(By.id("company")).sendKeys("srijan");
		driver.findElement(By.id("address1")).sendKeys("B block, H-123");
		driver.findElement(By.id("city")).sendKeys("California");
		new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("California");
		driver.findElement(By.id("postcode")).sendKeys("00011");
		driver.findElement(By.id("other")).sendKeys("test information");
		driver.findElement(By.id("phone_mobile")).sendKeys("123456789");
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("Home Address123");
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
		System.out.println("Click on Register button");
		String fullName = driver.findElement(By.xpath("//a[@class='account']/span")).getText();
		Assert.assertEquals(fullName, "Saurabh Atrey");
		System.out.println("To Verify user Registered sucessfully, it's showing name on hearder:" + fullName);

		driver.findElement(By.xpath("//a[@class='logout']")).click();
		System.out.println("logout from website");

	}

	@Test(priority = 1)
	public void loginAfterSignup() {

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("testing110@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("srijan@123");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		System.out.println("Logged in with same credentials successfully");
	}

	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Launch the Chrome Browser");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("Close the Chrome Browser");

	}

}
