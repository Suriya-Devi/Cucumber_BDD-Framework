package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DataTableWithExamples_Def {
WebDriver driver;	
	@Given("proceed to login page")
	public void proceed_to_login_page() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@When("user enters {string} and {string}")
	public void user_enters_and(String un, String pwd) {
		driver.findElement(By.name("username")).sendKeys(un);
	    driver.findElement(By.name("password")).sendKeys(pwd);
	}
	@When("clicked login button")
	public void clicked_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}


}
