package com.JsonFiles;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllPrice {
	
	@Test
	public void getAllPrice()
	{
		Response res = RestAssured.given()
		      .contentType(ContentType.JSON)
		   .when()
		      .get("http://localhost:3000/store");
		
		JSONObject jo = new JSONObject(res.asString());
		
		double totalPrice = 0;
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			totalPrice= totalPrice+Double.parseDouble(price);
		}
		
		System.out.println("total price of book is :"+totalPrice);
		Assert.assertEquals(totalPrice,53.92);
		
	}

}
