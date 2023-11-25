package com;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class LocalAPITest {
	@Test
	public void test_Get() {
		baseURI= "http://localhost:3000/";
		
		given().
		   param("subject", "Automation").when().
		   get("/subjects").andReturn().
		then().
			statusCode(200).
		    log().all();
		
	}
	
	@Test(enabled=false)
	public void test_Post() {
		baseURI= "http://localhost:3000/";
		JSONObject request=new JSONObject();
		request.put("firstname", "Mamatha");
		request.put("lastname", "Kutagula");
		request.put("subjectId", 1);
		
		
		given().
		  contentType(ContentType.JSON).accept(ContentType.JSON).
		  header("Content-Type", "application/json").
		  body(request.toJSONString()).when().
		  post("/users").
		then().
			statusCode(201).
		    log().all();
		
	}
	
	@Test
	public void test_Patch() {
		baseURI= "http://localhost:3000/";
		JSONObject request=new JSONObject();
		
		request.put("lastname", "Thatikonda");
		
		
		given().
		  contentType(ContentType.JSON).accept(ContentType.JSON).
		  header("Content-Type", "application/json").
		  body(request.toJSONString()).when().
		  patch("/users/1").
		then().
			statusCode(200).
		    log().all();
		
	}
	
	@Test
	public void test_Put() {
		baseURI= "http://localhost:3000/";
		JSONObject request=new JSONObject();
		
		request.put("firstname", "Supriya");
		request.put("lastname", "Thatikonda");
		request.put("subjectId", 3);
		
		
		given().
		  contentType(ContentType.JSON).accept(ContentType.JSON).
		  header("Content-Type", "application/json").
		  body(request.toJSONString()).
		  when().
		  patch("/users/1").
		then().
			statusCode(200).
		    log().all();
		
	}
	
	@Test
	public void test_Delete() {
		baseURI= "http://localhost:3000/";
		
		
		given().
	   when().
		 
		  delete("/users/5").
		then().
			statusCode(200).
		    log().all();
		
	}
	

}
