package com.rmg.practice;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectUsingPojoClass {
	
	@Test
	public void createProjectTest() {
		int ran=new Random().nextInt(1000);
		ProjectPojo reqBody = new ProjectPojo("Nithesh", "04/05/2021", "TY_01", "Skill_"+ran, "completed", 2);
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(reqBody);
		
		Response res = req.post("http://localhost:8084/addProject");
		System.out.println(res.getStatusCode());
		
		res.prettyPrint();
	}

}
