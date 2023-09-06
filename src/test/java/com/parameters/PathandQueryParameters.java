package com.parameters;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathandQueryParameters {

	@Test
	public void testPathQueryParameters()
	{
		given()
		   .pathParam("mypath", "users")
		   .queryParam("page",2)
		   .queryParam("id",5)
		
		.when()
		    .get("https://reqres.in/api/{mypath}")
		
		.then()
		   .statusCode(200)
		   .log().all();
	}
}
