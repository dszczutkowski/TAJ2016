import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObjectTest {
	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void testPageObject()
	{
		driver.get("http://dszczutkowski-001-site1.ctempurl.com/Account/Login");
		Login login = new Login(driver);
		login.login("abc", "abcd123");
		assertEquals("Logowanie - Dawid Szczutkowski MVC", driver.getTitle());
	}

	@AfterClass
	public static void cleanup() {
		driver.quit();
	}

}
