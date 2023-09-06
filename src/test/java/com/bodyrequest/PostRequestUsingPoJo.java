package com.bodyrequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class PostRequestUsingPoJo {
	
	//post request body using pojo class
	
	@Test
	public void testPostUsingPojo()
	{
		Pojo_postrequest data = new Pojo_postrequest();
		
		data.setName("Scott");
	    data.setLocation("France");
		data.setPhone("123456");
		String CourseArr[] = {"C","C++"};
		data.setCourses(CourseArr);
		
		given()
		  .contentType("application/json")
		  .body(data)
		
		.when()
		   .post("http://localhost:3000/students")
		
		.then()
		   .statusCode(201)
		   .body("name",equalTo("Scott"))
		   .body("location",equalTo("France"))
		   .body("phone", equalTo("123456"))
		   .body("courses[0]",equalTo("C"))
		   .body("courses[1]",equalTo("C++"))
		   .header("Content-Type","application/json; charset=utf-8")
		  .log().all();
		
	}

}
