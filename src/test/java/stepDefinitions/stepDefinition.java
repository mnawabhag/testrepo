package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;

import static org.junit.Assert.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class stepDefinition extends Utils {
	RequestSpecification res;
	
	Response response;
	TestDataBuild data=new TestDataBuild();

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String string, String string2, String string3) throws IOException {
		
	res=given().log().all().spec(requestSpecification())
	.body(data.addPlacePayLoad(string, string2, string3));
	}
	
	@When("user call {string} api with {string} request")
	public void user_call_api_with_request(String string, String string2) {
		
		APIResources resourceapi=APIResources.valueOf(string);
		System.out.println(resourceapi.getResource());
		
		if(string2.equalsIgnoreCase("POST")) {
			response=res.when().post(resourceapi.getResource());	
		}else if(string2.equalsIgnoreCase("GET")){
			response=res.when().get(resourceapi.getResource());	
		}

}
@Then("the api call is success with status code {int}")
public void the_api_call_is_success_with_status_code(Integer int1) {
    assertEquals(response.getStatusCode(),200);
    
}
@And("{string} in response body is {string}")
public void in_response_body_is(String string, String string2) {
 
    assertEquals(getJsonPath(response, string2),string2);
}

@Then("verify place_Id created maps to {string} using {string}")
public void verify_place_id_created_maps_to_using(String expectedname, String string2) throws IOException {
    // Write code here that turns the phrase above into concrete actions
	
	String place_id=getJsonPath(response,"place_Id");
	res=given().log().all().spec(requestSpecification()).queryParam("place_Id",place_id );
	
	user_call_api_with_request(string2,"GET");
	String actualname=getJsonPath(response,"name");
	assertEquals(actualname,expectedname);
	
}


}
