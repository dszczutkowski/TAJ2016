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
    public void userIsOnHomePage(){        
        pages.meals().open();
        Assert.assertEquals("http://dszczutkowski-001-site1.ctempurl.com/", pages.meals().getCurrentUrl());
    }
	
	@When("user get login page and enter login and password")
    @Alias("u¿ytkownik przejdzie na stronê logowania i poda login i has³o")
    public void userLogin(){
    	pages.meals().findElement(By.id("loginLink")).click();
        pages.meals().findElement(By.id("Email")).sendKeys("abc@gmail.com");
        pages.meals().findElement(By.id("Password")).sendKeys("Asd!23");
        pages.meals().findElement(By.xpath("//input[@value='Zaloguj']")).click();
    }
    
    @Then("user is logged in")
    @Alias("u¿ytkownik jest zalogowany")
    public void userLoggedIn(){
    	Assert.assertEquals("Strona G³ówna - Dawid Szczutkowski MVC", pages.meals().getTitle());
    }
    
    @When("user get on meals page and add new meal")
    @Alias("u¿ytkownik przejdzie na stronê posi³ków doda nowy posi³ek")
    public void userIsAddingMeal(){        
        pages.meals().findElement(By.xpath("//a[@href='/Posilki']")).click();
        pages.meals().findElement(By.xpath("//a[@href='/Meals/Create']")).click();
        pages.meals().findElement(By.id("Name")).sendKeys("test Name");
        pages.meals().findElement(By.id("Price")).sendKeys("12345");
        pages.meals().findElement(By.xpath("//input[@value='Create']")).click();

    	Assert.assertEquals("Posi³ki - Dawid Szczutkowski MVC", pages.meals().getTitle());
    }
    
    @Then("meal is added")
    @Alias("posi³ek jest dodany")
    public void userAddedMeal(){

        String result = pages.meals().findElement(By.xpath("//table/tbody/tr[last()]")).getText();
        Assert.assertTrue(result.contains("test Name $12345"));
        
        pages.meals().close();
    }
    
}    
