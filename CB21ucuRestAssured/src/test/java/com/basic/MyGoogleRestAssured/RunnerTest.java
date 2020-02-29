package com.basic.MyGoogleRestAssured;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/resources/com/basic/MyGoogleRestAssured/MyFeatureFile.feature",
				"src/test/resources/com/basic/MyGoogle22/MyFeatureFile.feature"},
		glue	= {"com/basic/MyGoogleRestAssured/"},
		monochrome=true
		
		
		
		)
public class RunnerTest {
	
	
			

}
