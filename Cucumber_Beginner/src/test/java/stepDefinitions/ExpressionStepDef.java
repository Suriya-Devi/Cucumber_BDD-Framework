package stepDefinitions;

import io.cucumber.java.en.Given;

public class ExpressionStepDef {

	@Given("I have {int} laptop")
	public void I_have_1_laptop(int count) {
		System.out.println("Laptop count is "+count);
		
	}
	@Given("I have {double} CGPA")
	public void i_have_cgpa(double num) {
	   System.out.println("CGPA is "+num);
	    
	}
	@Given("{string} is elder to {string} and {string}")
	public void is_elder_to_and(String name, String name1, String name2) {
	   System.out.println(name +" is elder to "+name1 + " and " +name2);
	  
	}
}
