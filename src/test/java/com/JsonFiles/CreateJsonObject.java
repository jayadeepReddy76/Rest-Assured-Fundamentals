package com.JsonFiles;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateJsonObject {
	
	@Test
	public void createJsonObject()
	{
		Response res = RestAssured.given()
		     .contentType(ContentType.JSON)
		
		.when()
		   .get("http://localhost:3000/store");
		
		JSONObject jo = new JSONObject(res.asString());
		
		boolean status = false;
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookTitle);
			
			if(bookTitle.equals("Moby Dick"))
			{
				System.out.println("Selected Book Name: "+bookTitle);
				status = true;
				break;
			}
			
		}
		Assert.assertEquals(status, true);
	}

}
