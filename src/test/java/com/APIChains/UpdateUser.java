package com.APIChains;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test
	public void test_updateuser(ITestContext context)
	{
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name",faker.name().fullName());
		data.put("gender","Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status", "Active");
		
		String bearerToken = "e36d260ce801aa842f39c44103df45efea461c9638cd5ed9c8b633bb8ea2debc";
		
		//int id = (int) context.getAttribute("user_id");
		int id = (int) context.getSuite().getAttribute("user_id");
		
		given()
		   .headers("Authorization","Bearer "+bearerToken)
		   .contentType("application/json")
		   .body(data.toString())
		   .pathParam("id",id)
		.when()
		   .put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		  .statusCode(200)
		  .log().all();
		
	}

}
