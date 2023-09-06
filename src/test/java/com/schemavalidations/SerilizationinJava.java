package com.schemavalidations;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerilizationinJava {
	
	// pojo -- serilization --> json Onject -- deserilization --> pojo
	
	@Test
	public void convertPojo2Json() throws JsonProcessingException
	{
		Student stu = new Student();
		
		stu.setName("Jayadeep");
		stu.setLocation("Hyderabad");
		stu.setPhone("123456");
		String courseArr [] = {"Java", "RestAssured"};
		stu.setCourse(courseArr);
		
		ObjectMapper objmapper = new ObjectMapper();
		
		String jsondata = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(stu);
		System.out.println(jsondata);	
	}
	
	@Test
	public void convertjsonobjtoPojo() throws JsonProcessingException
	{
		String jsondata = "{\r\n"
				+ "  \"location\" : \"Hyderabad\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"course\" : [ \"Java\", \"RestAssured\" ],\r\n"
				+ "  \"name\" : \"Jayadeep\"\r\n"
				+ "}";
		ObjectMapper objMapper = new ObjectMapper();
		Student stupojo = objMapper.readValue(jsondata,Student.class);
		
		System.out.println("Name:"+stupojo.getName());
		System.out.println("Location:"+stupojo.getLocation());
		System.out.println("PhoneNumber"+stupojo.getPhone());
		System.out.println("Course:"+stupojo.getCourse()[0]);
		System.out.println("Course:"+stupojo.getCourse()[1]);
	}

}
