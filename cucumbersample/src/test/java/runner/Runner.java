package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features=".//cucumberFeature//Sample.feature" , 
glue="stefdefinition",
monochrome=true,
plugin= {"html:target//report.html"})

public class Runner extends AbstractTestNGCucumberTests 
{

}
