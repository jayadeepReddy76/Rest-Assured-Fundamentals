package com.APIChains;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	@Test
	public void test_deleteUser(ITestContext context)
	{
		String bearerToken = "e36d260ce801aa842f39c44103df45efea461c9638cd5ed9c8b633bb8ea2debc";
		
		//int id = (int) context.getAttribute("user_id");
		int id = (int) context.getSuite().getAttribute("user_id");

		
		given()
		   .headers("Authorization","Bearer "+bearerToken)
		   .pathParam("id",id)
		.when()
		   .delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204)
		.log().all();
	}

}
