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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FormTest {
	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void login()
	{
		driver.get("http://dszczutkowski-001-site1.ctempurl.com/Account/Login");
		Login login = new Login(driver);
		login.login("abc@gmail.com", "Asd!23");
	}
	
	@Test
	public void addSthWithoutLoginTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://dszczutkowski-001-site1.ctempurl.com/Posilki");
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/Meals/Create']")));
		e.click();
		assertEquals("Logowanie - Dawid Szczutkowski MVC", driver.getTitle());
		
	}
	
	@Test
	public void loginAndAddSthTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		login();
		driver.get("http://dszczutkowski-001-site1.ctempurl.com/Zamowienia");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/Orders/Create']")));
		element.click();
		Select droplist = new Select(driver.findElement(By.id("MealID")));   
		droplist.selectByVisibleText("test Name");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("SeatNumber")));
		element.sendKeys("11");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("PaymentMethod")));
		element.sendKeys("testowy");
		element.findElement(By.xpath("//input[@value='Utwórz']")).click();
        element = driver.findElement(By.xpath("//table/tbody/tr[last()]"));
        assertEquals(element.getText(), "test Name testowy");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Log")));
		element.click();
	}
	
	@Test
	public void newWindowLoginTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String parentWindow;
		driver.get("http://dszczutkowski-001-site1.ctempurl.com/");
		parentWindow = driver.getWindowHandle(); 
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		driver.get("http://dszczutkowski-001-site1.ctempurl.com/");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginLink")));
		element.click();
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("Email")));
		element.sendKeys("blablabla");
		element.findElement(By.xpath("//input[@value='Zaloguj']")).click();
		assertEquals("Logowanie - Dawid Szczutkowski MVC", driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		assertEquals("Strona G³ówna - Dawid Szczutkowski MVC", driver.getTitle());

	}

	@AfterClass
	public static void cleanup() {
		driver.quit();
	}

}
