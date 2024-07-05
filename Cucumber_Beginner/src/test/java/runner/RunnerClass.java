package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*@RunWith(Cucumber.class)
@CucumberOptions
(features = "featureFiles/DataTableWithHeader.feature" ,
glue = "stepDefinitions",
//stepNotifications = true,
dryRun = true)
*/

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\com\\features",
		glue = {"com.StepDefinition"},
		monochrome=true,
		plugin = {"html:Reports\\HTMLReports",
				"json:Reports\\JsonReports\\Cucumber.json"
		
		},
		dryRun=false
		
		
		
		)
public class RunnerClass {

	//it should combine the feature file and step definition file
	
	
}
