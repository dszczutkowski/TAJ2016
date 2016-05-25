package projekt5;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Meals extends WebDriverPage {

	public Meals(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://dszczutkowski-001-site1.ctempurl.com/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}

