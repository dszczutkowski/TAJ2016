package projekt5;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MealsSteps extends Steps {

	private final Pages pages;
	
	String index;
	String email;
	
	public MealsSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on home page")
	@Alias("u¿ytkownik jest na stronie g³ównej")
    public void userIsOnInteriaPage(){        
        pages.meals().open();
        Assert.assertEquals("http://dszczutkowski-001-site1.ctempurl.com/", pages.meals().getCurrentUrl());
    }
	
	@When("user get login page and enter login and password")
    @Alias("u¿ytkownik przejdzie na stronê logowania i poda login i has³o")
    public void userLoginToInteria(){
    	pages.meals().findElement(By.id("loginLink")).click();
        pages.meals().findElement(By.id("Email")).sendKeys("abc@gmail.com");
        pages.meals().findElement(By.id("Password")).sendKeys("Asd!23");
        pages.meals().findElement(By.xpath("//input[@value='Zaloguj']")).click();
    }
    
    @Then("user is logged in")
    @Alias("u¿ytkownik jest zalogowany")
    public void userIsLoggedInteria(){
    	Assert.assertEquals("Strona G³ówna - Dawid Szczutkowski MVC", pages.meals().getTitle());
    }
}
