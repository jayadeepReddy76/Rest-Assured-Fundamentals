package com.bodyrequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;


/* Different ways to create POST request body
 * 1. Post request body using HashMap
 * 2. Post request body creation using org.json
 * 3. Post request body creation using POJO classes
 * 4. Post request using external json file data
 */

public class DifferentWaysPostRequestbody {
	
	@Test(priority=0)
	public void createUser()
	{
		HashMap data = new HashMap();
		data.put("name", "John");
		data.put("location", "France");
		data.put("phone", "123456");
		
		String CourseArr[] = {"Java","Python"};
		data.put("courses", CourseArr);
		
		
		given()
		  .contentType("application/json")
		  .body(data)
		.when()
		   .post("http://localhost:3000/students")
		.then()
		   .statusCode(201)
		   .log().all();
		
	}
	
	@Test(priority=1)
	public void testPostUsingHashMap()
	{
		HashMap data = new HashMap();
		
		data.put("name", "John");
		data.put("location", "France");
		data.put("phone", "123456");
		
		String CourseArr[] = {"c","c++"};
		data.put("courses", CourseArr);
		
		given()
		    .contentType("application/json")
		    .body(data)
		.when()
		    .post("http://localhost:3000/students")
		.then()
		   .statusCode(201)
		   .body("name",equalTo("John"))
		   .body("location",equalTo("France"))
		   .body("phone",equalTo("123456"))
		   .body("courses[0]",equalTo("c"))
		   .body("courses[1]",equalTo("c++"))
		   .header("Content-Type","application/json; charset=utf-8")
		   .log().all();
	
	}
    
	@Test(priority=2)
	public void deleteRecord()
	{
		given()
		
		.when()
		  .delete("http://localhost:3000/students/6")
		.then()
		  .statusCode(200)
		  .log().all();
	}
}
