
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewWindowTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void testNewWindow1()
	{

		WebDriverWait wait = new WebDriverWait(driver, 10);
		String parentWindow;
		String newWindow;
		driver.get("http://dszczutkowski-001-site1.ctempurl.com/");
		parentWindow = driver.getWindowHandle(); 
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
		//driver.findElement(By.id("helpButton")).click();
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		driver.get("http://dszczutkowski-001-site1.ctempurl.com/");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='../Posilki/Nazwy']")));
		//assertEquals("Help window", driver.getTitle());
		element.click();
		assertEquals("Nazwy - Dawid Szczutkowski MVC", driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		assertEquals("Strona G³ówna - Dawid Szczutkowski MVC", driver.getTitle());
		driver.close();

	}
	
	@Test
	public void testNewWindow2()
	{

		WebDriverWait wait = new WebDriverWait(driver, 10);
		String parentWindow;
		driver.get("http://dszczutkowski-001-site1.ctempurl.com/");
		parentWindow = driver.getWindowHandle(); 
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
		//driver.findElement(By.id("helpButton")).click();
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		driver.get("http://dszczutkowski-001-site1.ctempurl.com/");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginLink")));
		//assertEquals("Help window", driver.getTitle());
		element.click();
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("Email")));
		element.sendKeys("blablabla");
		element.findElement(By.xpath("//input[@value='Zaloguj']")).click();
		assertNotNull(element);
		driver.close();
		
		driver.switchTo().window(parentWindow);
		driver.close();

	}
	

	@AfterClass
	public static void cleanup() {
		driver.quit();
	}
}
