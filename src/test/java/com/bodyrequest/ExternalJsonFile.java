package com.bodyrequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ExternalJsonFile {
	
	@Test
	public void externalJsonFile() throws FileNotFoundException
	{
		File f = new File(".\\body.json");
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		
		given()
		  .contentType("application/json")
		  .body(data.toString())
		
		.when()
		  .post("http://localhost:3000/students")
		
		.then()
		  .statusCode(201)
		  .body("name",equalTo("Scott"))
		  .body("location", equalTo("France"))
		  .body("phone", equalTo("123456"))
		  .body("courses[0]", equalTo("c"))
		  .body("courses[1]", equalTo("c++"))
		  .header("Content-Type", "application/Json; charset=utf-8")
		  .log().all();
	
	}

}
