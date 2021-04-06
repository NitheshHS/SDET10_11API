package com.rmg.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PathParameter {
	
	@Test
	public void pathParam() {
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.pathParam("projId", "TY_PROJ_1606");
		Response res = req.get("http://localhost:8084/projects/{projId}");
		
		res.prettyPrint();
		
	}
	

}
