package com.runner.sample;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features=".//Features//Login.feature" , glue="com.stepDef.example" , monochrome=true)
public class Runner extends AbstractTestNGCucumberTests {

}
