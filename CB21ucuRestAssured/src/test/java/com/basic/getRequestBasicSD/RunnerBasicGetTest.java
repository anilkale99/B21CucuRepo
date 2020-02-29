package com.basic.getRequestBasicSD;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/resources/com/basic/getRequestBasicFF/"},
		glue	= {"com/basic/getRequestBasicSD/"},
		monochrome=true
		
		
		
		)
public class RunnerBasicGetTest {
	
	
			

}
