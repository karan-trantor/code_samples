package com.cucumber.stepdefinition;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;

import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)


@CucumberOptions(plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "rerun:target/rerun.txt",
        "usage:target/cucumber-usage.json",
        "junit:target/cucumber-results.xml"
        },
		strict = false,
		features = {"src/test/java"},
        glue = {"com.cucumber.stepdefinition","adbeat.qa.automation","adbeat.api.automation"},
        tags="@search",
        
        
        		format = { "pretty",
        			    "html:target/site/cucumber-pretty",
        			    "json:target/cucumber.json",
						"junit:target/cucumber.xml"}
         )



public class RunCukeTest {//extends AbstractTestNGCucumberTests{
	
	
    /*@AfterSuite
	public  void mainFinal() {
		CucumberResultsOverview results = new CucumberResultsOverview();
		results.setOutputDirectory("target");
		results.setOutputName("cucumber-results");
		results.setSourceFile("C:\\Users\\harpreet2.singh\\workspace\\qa.automation\\target\\cucumber.json");
		try {
			results.executeFeaturesOverviewReport();
		} catch (Exception e) {
			System.out.println("No file found");
			e.printStackTrace();
		}
	}*/
}


