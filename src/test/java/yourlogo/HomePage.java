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
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HomePage {
	static WebDriver driver;

	@Test
	public void isDisplayed() {
		driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
		WebElement item = driver.findElement(By.xpath("//ul[@id='homefeatured']//img[@title='Blouse']"));

		if (item.isDisplayed()) {
			item.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("click on displayed item");
		} else {
			driver.findElement(By.xpath("//span[contains(text(),'saurabh sharma')]")).click();
		}
	}

	@Test
	public void assertEquals() {
		driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();

		String fullName = driver.findElement(By.xpath("//span[contains(text(),'saurabh sharma')]")).getText();
		Assert.assertEquals(fullName, "saurabh sharma");
		System.out.println("To Verify user logged In it's showing on hearder:" + fullName);

		String actual1 = driver.findElement(By.xpath("//h3[contains(text(),'Come Visit Us')]")).getText();
		Assert.assertEquals(actual1, "Come Visit Us");
		System.out.println("Verify Come Visit Us text on home pages");

		String actual2 = driver.findElement(By.xpath("//h3[contains(text(),'Call Us')]")).getText();
		Assert.assertEquals(actual2, "Call Us");
		System.out.println("Verfify Call Us text on home pages");

		String actual3 = driver.findElement(By.xpath("//h3[contains(text(),'How to Pay dues')]")).getText();
		Assert.assertEquals(actual3, "How to Pay dues");
		System.out.println("Verfify How to Pay dues text on home pages");

		String actual4 = driver.findElement(By.xpath("//h3[contains(text(),'Custom Block')]")).getText();
		Assert.assertEquals(actual4, "Custom Block");
		System.out.println("Verfify Custom Block text on home pages");

		String actual5 = driver.findElement(By.xpath("//h1[contains(text(),'Automation Practice Website')]")).getText();
		Assert.assertEquals(actual5, "Automation Practice Website");
		System.out.println("Verfify Automation Practice Website text on home pages");
	}

	@Test
	public void assertNotEquals() {
		driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
		String actual1 = driver.findElement(By.xpath("//h4[contains(text(),'Follow us on Facebook')]")).getText();
		Assert.assertNotEquals(actual1, "Follow us on Instagram",
				"it is passed since expected and actual result do not match");
		System.out.println("Verfify facebook texts are not same on home page");
	}

	/*
	 * @Test public void assertTrue() { Assert.assertTrue(3 < 5);
	 * System.out.println( "This line will be executed as assertTrue will" +
	 * " pass because the 3<5(which will return true)"); }
	 * 
	 * @Test public void assertFalse() { Assert.assertFalse(3 > 5);
	 * System.out.println("This line is executed because assertFalse" +
	 * "assertion passes as the given condition will return false"); }
	 * 
	 * @Test public void assertNull() { Assert.assertNull(null);
	 * System.out.println("Since we we set null in the condition, the assertion " +
	 * "assertNull will pass"); }
	 * 
	 * @Test public void assertNotNull() {
	 * Assert.assertNotNull("This assertion will pass because this " +
	 * "string don't returns a null value"); System.out.
	 * println("This line is executed because assertNotNull have have passed"); }
	 */

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("saurabh.sh123@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("srijan@123");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
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
