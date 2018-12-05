package Runner;		

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(
		features="E:\\Study\\CucumberWS\\freeCRM\\Features\\login.feature",
		glue={"StepDefinitions"},
		//tags = {"~@Smoke", "~@Reg", "@scenario"},
		//strict = true,
		format = {"pretty", "html:html-output", "json:json-output/report.json", "junit:junit-output/report.xml"},
		monochrome = true,
		dryRun = false
		)
public class Runner 				
{		

}