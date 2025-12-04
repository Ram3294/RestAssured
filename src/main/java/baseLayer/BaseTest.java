package baseLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	
	
	public static RequestSpecification getRequestSpecBuilder() throws FileNotFoundException
	{
		File fileLog=new File(System.getProperty("user.dir")+"\\AllLogs\\abc.log");
		RequestSpecification requestSpec=new RequestSpecBuilder()
			.setBaseUri("http://localhost:3000")
			.addFilter(new RequestLoggingFilter())
			.addFilter(new ResponseLoggingFilter())
			.addFilter(new RequestLoggingFilter(new PrintStream(fileLog)))
			.addFilter(new ResponseLoggingFilter(new PrintStream(fileLog)))
			.addHeader("Content-Type","application/json")
			.build();
		
		return requestSpec;
		
	}

}
