package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableWithoutHeader_Def {
WebDriver driver;
	@Given("user on  the login page")
	public void user_on_the_login_page() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@When("you enter the below  credentials")
	public void you_enter_the_below_credentials(DataTable dataTable) {
		List<List<String>> credentials = dataTable.asLists(String.class);
		String UserName = credentials. get(0). get(0);
		String passwrd = credentials. get(0). get(1);
		
		 driver.findElement(By.name("username")).sendKeys(UserName);
		    driver.findElement(By.name("password")).sendKeys(passwrd);
	
	 
	}
	@When("click the login button")
	public void click_the_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("you should see the home page")
	public void you_should_see_the_homepage() {
		Assert.assertEquals("sry,its wrong navigation",driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	}

}
