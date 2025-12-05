package baseLayer;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import Reader.PropertyReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	
	
	public static RequestSpecification getRequestSpecBuilder() throws IOException
	{
		File fileLog=new File(System.getProperty("user.dir")+"\\AllLogs\\employee.log");
		RequestSpecification requestSpec=new RequestSpecBuilder()
			.setBaseUri(PropertyReader.getProperty("EmployeeURI"))
			.addFilter(new RequestLoggingFilter())
			.addFilter(new ResponseLoggingFilter())
			.addFilter(new RequestLoggingFilter(new PrintStream(fileLog)))
			.addFilter(new ResponseLoggingFilter(new PrintStream(fileLog)))
			.addHeader("Content-Type","application/json")
			.build();
		
		return requestSpec;
		
	}
	public static RequestSpecification getRequestSpecBuilder1() throws IOException
	{
		File fileLog=new File(System.getProperty("user.dir")+"\\AllLogs\\customer.log");
		RequestSpecification requestSpec1=new RequestSpecBuilder()
			.setBaseUri(PropertyReader.getProperty("CustomerURI"))
			.addFilter(new RequestLoggingFilter())
			.addFilter(new ResponseLoggingFilter())
			.addFilter(new RequestLoggingFilter(new PrintStream(fileLog)))
			.addFilter(new ResponseLoggingFilter(new PrintStream(fileLog)))
			.addHeader("Content-Type","application/json")
			.build();
		
		return requestSpec1;
	}
}
