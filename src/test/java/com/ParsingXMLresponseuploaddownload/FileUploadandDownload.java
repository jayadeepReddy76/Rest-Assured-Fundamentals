package com.ParsingXMLresponseuploaddownload;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FileUploadandDownload {
	
	@Test(priority=1)
	public void singleFIleUpload()
	{
		File myfile = new File("C://Users//jayad//OneDrive//Documents//JsonFiles//TestFiles//Test1.txt");

		given()
		    .multiPart("file",myfile)
		    .contentType("multipart/form-data")
		.when()
		    .post("http://localhost:8080/uploadFile")
		.then()
		   .statusCode(200)
		   .body("fileName", equalTo("Test1.txt"));
	}
	
	@Test(priority=2)
	public void MultipleFilesUpload()
	{
		File myfile1 = new File("C://Users//jayad//OneDrive//Documents//JsonFiles//TestFiles//Test1.txt");
		File myfile2 = new File("C://Users//jayad//OneDrive//Documents//JsonFiles//TestFiles//Test2.txt");
		
		given()
		     .multiPart("files",myfile1)
		     .multiPart("files",myfile2)
		     .contentType("multipart/form-data")
		.when()
		   .post("http://localhost:8080/uploadMultipleFiles")
		.then()
		   .statusCode(200)
		   .body("[0].fileName",equalTo("Test1.txt"))
		   .body("[1].fileName",equalTo("Test2.txt"))
		   .log().all();
	}
	
    @Test(priority=3)
    public void downloadFile()
    {
    	given()
    	
    	.when()
    	   .get("http://localhost:8080/downloadFile/Test1.txt")
        .then()
          .log().all();
    }
}
