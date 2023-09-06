package com.APIChains;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateUser {
	
	@Test
	public void test_CreateUser(ITestContext context)
	{
		Faker randomdata = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", randomdata.name().fullName());
		data.put("gender", "male");
		data.put("email", randomdata.internet().emailAddress());
		data.put("status", "Inactive");
		
		String bearerToken = "e36d260ce801aa842f39c44103df45efea461c9638cd5ed9c8b633bb8ea2debc";
		
		int id = given()
		  .headers("Authorization","Bearer "+bearerToken)
		  .contentType("application/JSON")
		  .body(data.toString())
		
		.when()
		  .post("https://gorest.co.in/public/v2/users")
		  .jsonPath().getInt("id");
		
		System.out.println("Genarate id is :"+id);
		
		//context.setAttribute("user_id",id);
		context.getSuite().setAttribute("user_id",id);
	}

}
