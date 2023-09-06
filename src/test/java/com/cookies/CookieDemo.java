package com.cookies;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookieDemo {
	
	@Test(priority=1)
	public void testCookie()
	{
		given()
		
		.when()
		  .get("https://www.google.com/")
		
		.then()
		.cookies("AEC","Ad49MVF5lLF52aEW2WRqGUM1DhprQnFj79ZuwOFm0G1ZzfmFbpgmyoZwsA")
		.log().all();
	}
	
	@Test(priority=2)
	public void getCookieInfo()
	{
		Response res=given()
		
		.when()
		  .get("https://www.google.com/");
		
		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of Cookie is ==> "+cookie_value);
        
		//To store response validation then is not using 
		// if validation purpose use the value then it should not store any value
	}
	
	@Test(priority=3)
	public void getAllCookies()
	{
		Response res=given()
				
			.when()
			  .get("https://www.google.com/");
		
		Map<String, String> cookie_variable=res.getCookies();
		
		System.out.println(cookie_variable.keySet());
		
		for(String K :cookie_variable.keySet())
		{
			String Cookie_value = res.getCookie(K);
			System.out.println(K+"   <===>    "+Cookie_value);
		}
	}
		
		@Test(priority=3)
		public void getAllCookies2()
		{
			Response res = given()
			.when()
			  .get("https://www.google.com/");
			
			 Map<String, String> cookies_value =  res.getCookies();
			 
			 System.out.println(cookies_value.keySet());
		}
	    
		@Test
		public void getKeyValue()
		{
			
			Response res = given()
			
			.when()
			   .get("https://www.google.com/");
			
			Map<String, String> cookie_value = res.getCookies();
			
			for(String k:cookie_value.keySet())
			{
				String cookie_values =res.getCookie(k);
				System.out.println(k+" <===>"+cookie_values);
			}
			   
		}
	

}
