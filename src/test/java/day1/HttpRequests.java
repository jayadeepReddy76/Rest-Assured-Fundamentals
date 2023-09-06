package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpRequests {
	int id;
	@Test(priority=1)
	public void listUser()
	{
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200).body("page", equalTo(2)).log().all();
	}
	
	@Test(priority=2)
	public void createUser()
	{
		HashMap data = new HashMap();
		data.put("name", "Jayadeep");
		data.put("Job", "Software QA");
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
	}
    
	@Test(priority=3, dependsOnMethods= {"createUser"})
	public void updateUser()
	{
		HashMap data = new HashMap<>();
		data.put("name", "john");
		data.put("Job", "Test");
		
		
		given().contentType("application/json")
		.body(data)
		.when().put("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		given()
		
		.when().delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
	}
}
