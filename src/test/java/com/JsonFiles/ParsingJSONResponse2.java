package com.JsonFiles;

import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponse2 {
	
	@Test
	public void jsonResponse()
	{
		Response res = RestAssured.given()
		       .contentType(ContentType.JSON)
		.when()
		    .get("http://localhost:3000/store");
		
		Assert.assertEquals(res.statusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		
		String bookname = res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "The Lord of the Rings");
		
	}

}
