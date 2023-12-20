package stepDefinitions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTable.*;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class incidentManagement extends baseAPI{
 
	@Given("enable logs")
	public void setUp(){ 
		
		request = given().log().all();
	}	
	
	@And("short description is {string}")
	public void shortDescriptionIsAdded(String short_description) {
		
		request = request.when().body("{\"short_description\" : \""+short_description+"\"}");		
	}
	
	@When("new incident is created")
	public void newIncidentCreated(){
		
		response = request.when().contentType(ContentType.JSON).post("incident");
		response.prettyPrint();
	}
	
	@Then("verify the status code is {int}")
	public void checkTheStatusCode(Integer statusCode){
		
		response.then().assertThat().statusCode(statusCode);
		
	}
	
	@And("response includes the following")
	public void responseIncludesTheFollowing(Map<String,String> responseFields){
		
		for(Entry<String,String> eachEntry: responseFields.entrySet()){
			response
			.then()
			.body(eachEntry.getKey(), equalTo(eachEntry.getValue()));
		}
	}
	
	@And("add the query parameters")
	public void addTheQueryParameters(DataTable dt){
		
		Map<String,String> paramsMap= dt.asMap(String.class, String.class);
		request.queryParams(paramsMap).contentType(ContentType.JSON);
	}
		
	@When("get all incident request")
	public void getAllIncidentRequest() {
		
        response = request.get("incident");
        response.prettyPrint();
	}
	
	@When("update the incident with {string} as {string}")
	public void updatetheIncident(String shortDescription,String value){

		response = request.body("{shortDescrpition: value}").put("incident");		
	}
	
	@And("validate the response")
	public void validateResponse(Map<String,String> responseFields){
		
		for(Entry<String, String>eachEntry : responseFields.entrySet()){
			response.then().body(eachEntry.getKey(),Matchers.hasItem(eachEntry.getValue()));
		}
	}

}
