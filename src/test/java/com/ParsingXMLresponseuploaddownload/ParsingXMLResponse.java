package com.ParsingXMLresponseuploaddownload;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingXMLResponse {
	
	@Test
	public void parsingXMLResponse()
	{
	     given()
		.contentType(ContentType.XML)
	    .when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")
	    .body("TravelerinformationResponse.page", equalTo("1"))
	    .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));

	                  
	}

}
