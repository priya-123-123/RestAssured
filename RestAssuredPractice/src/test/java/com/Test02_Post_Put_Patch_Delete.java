package com;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Test02_Post_Put_Patch_Delete {
	
	@Test(priority=1)
	void TC02_POST() {
		JSONObject request=new JSONObject();
		request.put("name", "Ramesh");
		request.put("job", "Teacher");
		request.toJSONString();
		
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().
		statusCode(201).
		log().all();
		
	}
	
	@Test
	void TC03_PUT() {
		JSONObject request=new JSONObject();
		request.put("name", "Ramesh");
		request.put("job", "Doctor");
		request.toJSONString();
		
		
		given().
		body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();
		
	}
	
	@Test
	void TC04_Patch() {
		JSONObject request=new JSONObject();
		request.put("name", "Ramesh");
		request.put("job", "Lawyer");
		request.toJSONString();
		
		
		given().
		body(request.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();
		
	}
	
	@Test
	void TC05_delete() {
		
		when().
		delete("https://reqres.in/api/users/2").
		then().
		statusCode(204).
		log().all();
		
	}

}
