package com.StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps_HRM {
WebDriver driver;

	@Given("user is on loginpage")
	public void user_is_on_loginpage() {
		System.out.println("Step 1: Given user is on Login Page");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("Step 1: User enters username and password");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
	}

	@And("click on login button")
	public void click_on_login_button() {
		System.out.println("Step 1: User is clicking on Login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	
	  @Then("user should lands on homepage") 
	  public void user_should_lands_on_homepage() {
		  Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"); 
		  //driver.close();
		  }
	 
}
