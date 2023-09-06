package com.Authentications;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {

	@Test(priority=1)
   public void testBasicAuthentications()
   {
	   given()
	      .auth().basic("postman", "password")
	   .when()
	      .get("https://postman-echo.com/basic-auth")
	   .then()
	      .statusCode(200)
	      .body("authenticated", equalTo(true))
	     .log().all();
   }
	@Test(priority=2)
	public void testDigsetAuthentication()
	{
		given()
		    .auth().digest("postman", "password")
		.when()
		    .get("https://postman-echo.com/basic-auth")
		.then()
		   .body("authenticated", equalTo(true))
		  .log().all();
	}
	
	@Test(priority=3)
	public void testPreemptiveAuthentication()
	{
		given()
		   .auth().preemptive().basic("postman", "password")
		.when()
		    .get("https://postman-echo.com/basic-auth")
		.then()
		  .body("authenticated", equalTo(true))
		  .log().all();
	}
	
	@Test(priority=4)
	public void testBearerTokenAuthentication()
	{
		String bearerToken = "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";
		
		given()
		   .headers("Authoization", "Bearer "+bearerToken)
		.when()
		    .get("https://api.github.com/users/repos")
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	@Test(priority=5)
	public void OAuth1Authentication()
	{
		given()
		   .auth().oauth("consumerKey", "consumerSccreat", "accessToekn", "tokenSecreat")
		.when()
		   .get("URL")
		.then()
		 .statusCode(200)
		  .log().all();
	}
	
	@Test(priority=6)
	public void OAuth2Authentication()
	{
		given()
		    .auth().oauth2("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")
		.when()
		   .get("https://api.github.com/users/repos")
		.then()
		   .statusCode(200)
		   .log().all();
	}
	//check the API key genaration
	@Test(priority=6)
	public void APIKeyAuthentication()
	
	{
		
		given()
		    .queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
		.when()
		    .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		.then()
		   .statusCode(200)
		   .log().all();
	}
}
