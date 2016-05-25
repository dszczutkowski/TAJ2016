package projekt5;

import org.jbehave.web.selenium.WebDriverProvider;

public class Pages {

	private WebDriverProvider driverProvider;
	
	private Meals meals;

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Meals meals() {
		if (meals == null) {
			meals = new Meals(driverProvider);
		}
		return meals;
	}
}
