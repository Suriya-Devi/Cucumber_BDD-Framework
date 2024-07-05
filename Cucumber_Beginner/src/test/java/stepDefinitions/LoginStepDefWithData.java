package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefWithData {
	WebDriver driver;
	@Given("user is on  the login page")
	public void user_is_on_the_login_page() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@When("user enters the valid credentials {string} and {string}")
	public void user_enters_the_valid_credentials_and(String username, String password) {
		 driver.findElement(By.name("username")).sendKeys(username);
		    driver.findElement(By.name("password")).sendKeys(password);
	}
	@When("clicks the login button")
	public void clicks_the_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("the user should see the homepage")
	public void the_user_should_see_the_homepage() {
		Assert.assertEquals("sry,its wrong navigation",driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	}

}
