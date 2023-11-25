package com;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples extends TestDataProviderClass{
	

	@Test(enabled=false, dataProvider = "DataForPost")
	public void test_Post(String firstName, String lastName, int subjectId) {
		baseURI= "http://localhost:3000/";
		
		JSONObject request=new JSONObject();
		request.put("firstname", firstName);
		request.put("lastname", lastName);
		request.put("subjectId", subjectId);
		
		
		given().
		  contentType(ContentType.JSON).accept(ContentType.JSON).
		  header("Content-Type", "application/json").
		  body(request.toJSONString()).when().
		  post("/users").
		then().
			statusCode(201).
		    log().all();
		
	}

	
	@Test(dataProvider = "DataForDelete")
	public void test_Delete(int id) {
		baseURI= "http://localhost:3000/";
		
		
		given().
	   when().
		 
		  delete("/users/"+id).
		then().
			statusCode(200).
		    log().all();
		
	}

}
