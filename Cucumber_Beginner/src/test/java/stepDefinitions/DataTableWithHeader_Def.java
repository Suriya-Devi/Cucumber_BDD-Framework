package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableWithHeader_Def {
WebDriver driver;
	@Given("go to login page")
	public void go_to_login_page() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@When("enter the below  credentials")
	public void enter_the_below_credentials(io.cucumber.datatable.DataTable dataTable) {
		 List<Map<String, String>> keyValuePair = dataTable.asMaps(String.class,String.class);
		String un= keyValuePair.get(0).get("UserName");
		String pwd = keyValuePair.get(0).get("Password");
		
		driver.findElement(By.name("username")).sendKeys(un);
	    driver.findElement(By.name("password")).sendKeys(pwd);

	}
	@When("click login button")
	public void click_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("user can see the home page")
	public void user_can_see_the_home_page() {
		Assert.assertEquals("sry,its wrong navigation",driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	}

}
