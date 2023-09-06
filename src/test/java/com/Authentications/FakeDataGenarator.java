package com.Authentications;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakeDataGenarator {
	
	@Test
	public void fakeDataGenarator()
	{
		Faker faker = new Faker();
		
		String fullname = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		String name = faker.name().username();
		String password = faker.internet().password();
		
		String cell = faker.phoneNumber().cellPhone();
		String email = faker.internet().emailAddress();
		
		System.out.println("Full Name : "+fullname);
		System.out.println("First Name : "+firstName);
		System.out.println("Last Name : "+lastName);
		
		System.out.println("User Name : "+name);
		System.out.println("Password : "+password);
		
		System.out.println("Cell Number : "+cell);
		System.out.println("Email address : "+email);
		
	}

}
