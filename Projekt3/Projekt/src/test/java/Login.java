
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy(id="Email")
	private WebElement emailField;
	
	@FindBy(id="Password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Zaloguj']")
	private WebElement loginButton;
	
	@FindBy(id="RememberMe")
	private WebElement rememberCheck;
	
	public Login(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}

	public void login(String email, String password) {
	  emailField.sendKeys(email);
	  passwordField.sendKeys(password);
	  rememberCheck.click();
	  loginButton.click();
	}
	
}
