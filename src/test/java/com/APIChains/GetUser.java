package com.APIChains;
import static io.restassured.RestAssured.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test
	public void test_getUser(ITestContext context)
	{
		//int id = (int) context.getAttribute("user_id");
		int id = (int) context.getSuite().getAttribute("user_id");

		String bearerToken = "e36d260ce801aa842f39c44103df45efea461c9638cd5ed9c8b633bb8ea2debc";
		
		given()
		   .headers("Authorization","Bearer "+bearerToken)
		   .pathParam("id", id)
		.when()
		    .get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		  .log().all();
	}

}
