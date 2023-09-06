package com.cookies;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class LoggingDemo {
	
	@Test
	public void testLogs()
	{
		RestAssured.given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		   .log().all();
	}
	
	@Test
	public void getBodyLogs()
	{
		RestAssured.given()
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		   .log().body();
	}
   
	@Test
	public void getCookies()
	{
		RestAssured.given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		  .log().cookies();
	}
	
	@Test
	public void getHeaders()
	{
		RestAssured.given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		  .log().headers();
	}
}
