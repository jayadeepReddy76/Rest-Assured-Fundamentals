package com.JsonFiles;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsonJsonResponseData {
	
	
	@Test
	public void testJsonResponse()
	{
		given()
		   .contentType(ContentType.JSON)
		
		.when()
		  .get("http://localhost:3000/store")
		
		.then()
		   .statusCode(200)
		   .header("Content-Type","application/json; charset=utf-8")
		   .body("book[3].title", equalTo("The Lord of the Rings"));
		   
		
	}

}
