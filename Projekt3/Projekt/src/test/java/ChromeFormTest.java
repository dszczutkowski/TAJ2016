import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChromeFormTest {
	private static WebDriver driver;
	WebElement element;
	int timeToWait = 10;

	@BeforeClass
	public static void driverSetup() {
		File file = new File("C:/Users/Dawid/seleniumdriver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
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
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		driver.get("http://dszczutkowski-001-site1.ctempurl.com/Posilki");
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/Meals/Create']")));
		e.click();
		assertEquals("Logowanie - Dawid Szczutkowski MVC", driver.getTitle());
		
	}
	
	@Test
	public void loginAddDeleteTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
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
        assertTrue(element.getText().contains("test Name"));
        assertTrue(element.getText().contains("testowy"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        element = driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a[3]"));
        element.click();
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Delete']")));
        element.click();
        element = driver.findElement(By.xpath("//table/tbody/tr[last()]"));
        assertFalse(element.getText().contains("test Name"));
        assertFalse(element.getText().contains("testowy"));
		element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Log")));
		element.click();
	}
	
	@Test
	public void loginWrongAddSthTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		login();
		driver.get("http://dszczutkowski-001-site1.ctempurl.com/Zamowienia");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/Orders/Create']")));
		element.click();
		Select droplist = new Select(driver.findElement(By.id("MealID")));   
		droplist.selectByVisibleText("test Name");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("SeatNumber")));
		element.sendKeys("okokoko");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("PaymentMethod")));
		element.sendKeys("testowy");
		element.findElement(By.xpath("//input[@value='Utwórz']")).click();
		assertEquals(driver.getTitle(), "Create - Dawid Szczutkowski MVC");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Log")));
		element.click();
	}
	
	@Test
	public void newWindowLoginTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
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
