package com;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test_01_Get {
	
	@Test
	void Test1() {
		given().
		when().
		get("https://reqres.in/api/users?page=2").
		then()
		.statusCode(200).body("data.id[1]", equalTo(8))
		.body("data.first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"));
	}

}
