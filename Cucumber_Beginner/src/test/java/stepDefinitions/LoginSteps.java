package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginSteps {
WebDriver driver;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@When("user enters the valid username and password")
	public void user_enters_the_valid_username_and_password() {
	    driver.findElement(By.name("username")).sendKeys("Admin");
	    driver.findElement(By.name("password")).sendKeys("admin123");
	}
	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("the user should be navigated to homepage")
	public void the_user_should_be_navigated_to_homepage() {
	  Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index","sry,its wrong navigation");
	}	
	
}
