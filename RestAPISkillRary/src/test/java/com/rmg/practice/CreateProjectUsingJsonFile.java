package com.rmg.practice;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectUsingJsonFile {
	
	@Test
	public void createprojectSuingJsonFileTest() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(new File(".\\PojectData.json"));
		
		Response res = reqSpec.post("http://localhost:8084/addProject");
		System.out.println(res.getContentType());
		System.out.println(res.getStatusCode());

		res.prettyPrint();
				
		
	}

}
