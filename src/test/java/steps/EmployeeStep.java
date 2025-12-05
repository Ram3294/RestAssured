package steps;

import java.io.FileReader;
import java.io.IOException;

import org.hamcrest.Matchers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import baseLayer.BaseTest;
import endpoints.EmployeeEndpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pojo.Employee;

public class EmployeeStep extends BaseTest{

	RequestSpecification requestSpec;
	Response response;
	static String Id;
	ValidatableResponse validResponse;
	@Given("user add Reuest spec builder with all http request")
	public void user_add_reuest_spec_builder_with_all_http_request() throws IOException {
		 requestSpec=RestAssured.given();
		requestSpec.spec(getRequestSpecBuilder());
	}

	@Given("user add post requestPayload")
	public void user_add_post_request_payload() throws IOException {
		
		FileReader f=new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\requestPayload\\employeePayload.json");
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=mapper.readTree(f);
		Employee emp=mapper.treeToValue(node.get("PostRequest"), Employee.class);
		String requestPayload=mapper.writeValueAsString(emp);
		requestSpec.body(requestPayload);
		
	}

	@When("user select post request")
	public void user_select_post_request() {
	    response=requestSpec.post(EmployeeEndpoints.CREATE_EMPLOYEE);
	}

	@Then("user get employee id frome response payload")
	public void user_get_employee_id_frome_response_payload() {
		 Id =response.jsonPath().getString("id");
		
		
	}

	@Then("user validate status code  {int}")
	public void user_validate_status_code(Integer code) {
		validResponse=response.then().assertThat().statusCode(Matchers.equalTo(code));
		
	}

	@Then("user validate status line {string}")
	public void user_validate_status_line(String line) {
	    validResponse.statusLine(Matchers.containsString(line));

	}

	@Then("user validate response time should be below {int} milliseonds")
	public void user_validate_response_time_should_be_below_milliseonds(Integer time) {
		validResponse.time(Matchers.lessThan((long)time));
	}

	@Then("user validate firstname should not be null")
	public void user_validate_firstname_should_not_be_null() {
		validResponse.body("firstname", Matchers.notNullValue());
	}

	@Then("user validate city should not be null")
	public void user_validate_city_should_not_be_null() {
		validResponse.body("city", Matchers.notNullValue());
	}

	@Then("user validate email contains {string} domain")
	public void user_validate_email_contains_domain(String domain) {
		validResponse.body("email", Matchers.containsString(domain));
	}

	@Then("user validate content type header")
	public void user_validate_content_type_header() {
		validResponse.header("Content-Type", Matchers.containsString("application/json"));
	}

@Given("user add path parameter")
public void user_add_path_parameter() {
	requestSpec.pathParam("id", Id);
}

@When("user select get request")
public void user_select_get_request() {
	response =requestSpec.get(EmployeeEndpoints.GET_EMPLOYEE_AS_PER_ID);
}

@Given("user add put requestPayload")
public void user_add_put_request_payload() throws IllegalArgumentException, IOException {
	FileReader f=new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\requestPayload\\employeePayload.json");

	ObjectMapper mapper=new ObjectMapper();
	JsonNode node=mapper.readTree(f);
	Employee emp=mapper.treeToValue(node.get("PutRequest"), Employee.class);
	String requestPayload=mapper.writeValueAsString(emp);
	requestSpec.body(requestPayload);
}

@When("user select put request")
public void user_select_put_request() {
	response =requestSpec.put(EmployeeEndpoints.UPDATE_EMPLOYEE_AS_PER_ID);
}

@When("user select delete request")
public void user_select_delete_request() {
	response=requestSpec.delete(EmployeeEndpoints.DELETE_EMPLOYEE_AS_PER_ID);
}


}
