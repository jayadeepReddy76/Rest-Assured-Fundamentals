package com.ParsingXMLresponseuploaddownload;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class DynamicXMLResponse {
	
	@Test
	public void dynamicXMLResponse()
	{
		Response res = RestAssured.given()
				.contentType(ContentType.XML)
				
				.when()
				   .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
	
	String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
	Assert.assertEquals(pageNo, "1");
	
	String travelres = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
	Assert.assertEquals(travelres, "Developer");
		 
	}
	
	@Test
	public void getResponseUsingList()
	{
		Response res = RestAssured.given()
		  .contentType(ContentType.XML)
		  
		  .when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlobj = new XmlPath(res.asString());
		List<String> travellers = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(),10);
		
		//verify taveller name in the present response
		List<String> traveller_name = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean status = false;
		for(String travellername:traveller_name)
		{
			if(travellername.equals("AS"))
			{
				status = true;
				break;
			}
		}
		
		
		    
		  
	}

}
