package com.basic.HeadersValidationSD;

import java.util.List;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersValidationSD {
	
	Response res;
	
	@Given("^user start the rest asured test$")
	public void user_start_the_rest_asured_test() throws Throwable {
		System.out.println("Starting of the GET script");
	}

	@When("^user checks headers \"([^\"]*)\" have \"([^\"]*)\" value$")
	public void user_hit_the_get_request(String headerName, String headerValue) throws Throwable {
		res = RestAssured.given().relaxedHTTPSValidation().get("https://ergast.com/api/f1/2017/circuits.json");
		String completeResponse = res.asString();
		System.out.println("================="+completeResponse);
		
		//get all headers
		Headers heds = res.getHeaders();
		String actualHeaderValue = heds.getValue(headerName);
		Assert.assertTrue(actualHeaderValue.equals(headerValue));
	}
	

}
