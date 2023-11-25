package com;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {
	
	@Test
	public void test_Get() {
		baseURI= "http://localhost:3000/";
		
		given().
		   
		   get("https://reqres.in/api/users").andReturn().
		then().assertThat().body(matchesJsonSchemaInClasspath("C:\\Users\\BSR\\OneDrive\\Desktop\\SeleniumJava\\RestAssuredPractice\\target\\classes\\schema.json")).
			statusCode(200).
		    log().all();
		
	}
	

}
