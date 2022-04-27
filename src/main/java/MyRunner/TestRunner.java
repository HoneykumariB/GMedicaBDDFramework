package MyRunner;


import io.cucumber.testng.CucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;




// @RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/main/java/Features/Gerimedicaa.feature",
	    glue= {"StepDefination"},
	    		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
	    				"junit:target/cucumber-reports/Cucumber.xml",
	    				"html:target/cucumbers"},
	    monochrome = true
        )
    
public class TestRunner extends AbstractTestNGCucumberTests{
  
}
