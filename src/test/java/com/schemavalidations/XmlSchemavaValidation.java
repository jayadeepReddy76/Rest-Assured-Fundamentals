package com.schemavalidations;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XmlSchemavaValidation {
	
	@Test
	public void xmlSchemavalidation()
	{
		given()
		.when()
		  .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		   .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveler.xsd"));
	}

}
