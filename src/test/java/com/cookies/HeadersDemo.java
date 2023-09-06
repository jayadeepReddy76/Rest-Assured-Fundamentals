package com.cookies;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	
	
	@Test()
	public void getHeader()
	{
	
	RestAssured.given()
	
	.when()
	   .get("https://www.google.com/")
	   
	.then()
	   .header("Content-Type", "text/html; charset=ISO-8859-1")
	   .and()
	   .header("Content-Encoding","gzip")
	   .and()
	   .header("Server", "gws")
	   .log().headers();

}
	
	@Test
	public void getHeaders()
	{
		Response res = RestAssured.given()
		
		.when()
		  .get("https://www.google.com/");
		
		String valid_header = res.getHeader("Content-Type");
		System.out.println("The value of Content-Type header is :"+valid_header);
	}
	
	@Test
	public void getAllHeaders()
	{
		Response res = RestAssured.given()
		   
		.when()
		   .get("https://www.google.com/");
		 
		  Headers valid_headers =res.getHeaders();
		  
		  for(Header hd:valid_headers)
		  {
			  System.out.println(hd.getName()+"  <===> "+hd.getValue());
		  }
	}
	
}
