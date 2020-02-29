package com.basic.getRequestBasicSD;



import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestBasicSD {
	Response res;
	
	@Given("^race ciricute application is running$")
	public void race_ciricute_application_is_running()  {
	    System.out.println("application ready to use");
	}

	@When("^I hit get request to get response$")
	public void i_hit_get_request_to_get_response()  {
		
		res = RestAssured.given().get("http://ergast.com/api/f1/2017/circuits.json");
		String actualData = res.getBody().asString();
		System.out.println("Data =    "+actualData);
	}

	@Then("^I validate circuite \"([^\"]*)\" value as \"([^\"]*)\" present$")
	public void i_validate_circuite_value_as_present(String jPath, String valueTobevalidated)  {
	    String attrValue = res.body().jsonPath().getString(jPath);
	    Assert.assertTrue(attrValue.equals(valueTobevalidated));
	}
	
	@Then("^I validate circuite id value$")
	public void i_validate_circuite_id_value()  {
		String totalValue = res.body().jsonPath().getString("MRData.total");
		int totalIntV = Integer.parseInt(totalValue);
		
		for (int i = 0; i < totalIntV; i++) {
			String idValue = res.body().jsonPath().getString("MRData.CircuitTable.Circuits["+i+"].circuitId");
		    if(idValue.equals("americas")){
		    	Assert.assertTrue(idValue.equals("americas"));
		    	break;
		    }else{
		    	if(i==totalIntV-1){
		    		Assert.assertTrue(false);
		    	}
		    }
		}
	}
}
