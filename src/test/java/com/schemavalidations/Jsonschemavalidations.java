package com.schemavalidations;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class Jsonschemavalidations {
	
	@Test
	public void schamaValidations()
	{
		given()
		
		.when()
		   .get("http://localhost:3000/store")
		.then()
		 .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeschama.json"));
		}
	

}
