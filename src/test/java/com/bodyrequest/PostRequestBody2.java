package com.bodyrequest;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class PostRequestBody2 {
	
	//post request body using org.json library
	
	@Test
	public void jsonLibrary()
	{
		JSONObject data = new JSONObject();
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123456");
		
		String courseArr[] = {"c","c++"};
		data.put("courses", courseArr);
		
		
		given()
		  .contentType("application/Json")
		  .body(data.toString())
		  
		.when()
		   .post("http://localhost:3000/students")
		.then()
		  .statusCode(201)
		  .body("name",equalTo("Scott"))
		  .body("location",equalTo("France"))
		  .body("phone",equalTo("123456"))
		  .body("courses[0]",equalTo("c"))
		  .body("courses[1]",equalTo("c++"))
		  .header("Content-Type","application/json; charset=utf-8")
		  .log().all();
		
	}
	
	@Test
	public void testDelete()
	{
		given()
		
		.when()
		  .delete("http://localhost:3000/students/12")
		
		.then()
		  .log().all();
	}
}
