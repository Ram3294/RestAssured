package steps;

import java.io.File;
import java.io.IOException;

import org.hamcrest.Matchers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import baseLayer.BaseTest;
import endpoints.CustomerEndpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pojo.Customer;

public class CustomerStep extends BaseTest{

	RequestSpecification requestSpec;
	Response response;
	static String Id;
	ValidatableResponse validResponse;
	@Given("user add request Spec builder to http request")
	public void user_add_request_spec_builder_to_http_request() throws IOException {
		 requestSpec=RestAssured.given().spec(getRequestSpecBuilder1());
		
	}

	@Given("user add request payload")
	public void user_add_request_payload() throws IOException {
		 File f=new File("C:\\Users\\Pratik Gadekar\\git\\RestAssured\\src\\test\\resources\\requestPayload\\customerPayload.json");
		 ObjectMapper mapper=new ObjectMapper();
		 JsonNode node=mapper.readTree(f);
		 Customer cust=mapper.treeToValue(node.get("PostRequest"),Customer.class );
		 String requestPayload=mapper.writeValueAsString(cust);
		 requestSpec.body(requestPayload);
	}
	@When("user select a post request")
	public void user_select_a_post_request() {
		 response=requestSpec.post(CustomerEndpoints.CREATE_CUSTOMER);
	}


	@Then("user capture id frome response Payload")
	public void user_capture_id_frome_response_payload() {
		 Id=response.body().jsonPath().getString("id");
	}

	@Then("user validate a status code {int}")
	public void user_validate_a_status_code(Integer code) {
		 validResponse=response.then().assertThat().statusCode(Matchers.equalTo(code));
	}

	@Then("user validate a status line {string}")
	public void user_validate_a_status_line(String line) {
		validResponse.statusLine(Matchers.containsString(line));
	}

	@Then("user validate a content type header")
	public void user_validate_a_content_type_header() {
		validResponse.header("Content-Type", Matchers.containsString("application/json"));
	}
}
