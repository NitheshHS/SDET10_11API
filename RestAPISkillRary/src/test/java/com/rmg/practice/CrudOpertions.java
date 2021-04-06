package com.rmg.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CrudOpertions {
	/*
	 * {
  "createdBy": "string",
  "createdOn": "string",
  "projectId": "string",
  "projectName": "string",
  "status": "string",
  "teamSize": 0
}
	 */
	@Test
	public void test() {
		JSONObject j=new JSONObject();
		j.put("createdBy","Bharani");
		j.put("createdOn","3-1-2021");
		j.put("projectId", "1234");
		j.put("projectName","rmgYantra");
		j.put("status","Ongoing");
		j.put("teamSize",5);
		RequestSpecification req = RestAssured.given().baseUri("http://localhost:8084")
		.contentType(ContentType.JSON)
		.body(j);
		Response res = req.post("/addProject");
		res.prettyPrint();
		
		
	}
	@Test
	public void getOpertion() {
		RestAssured.get("http://localhost:8084/projects").prettyPrint();
	}
	
	@Test
	public void getOperationwithId() {
		RestAssured.get("http://localhost:8084/projects/TY_PROJ_2202").prettyPrint();
	}
	
	@Test
	public void updateOperation() {
		JSONObject j=new JSONObject();
		j.put("createdBy","Bharani");
		j.put("createdOn","3-1-2021");
		j.put("projectId", "1234");
		j.put("projectName","rmgBharani");
		j.put("status","Completed");
		j.put("teamSize",5);
		RequestSpecification updatereq = RestAssured.given().baseUri("http://localhost:8084")
				.contentType(ContentType.JSON)
				.body(j);
		updatereq.put("/projects/TY_PROJ_2202").prettyPrint();
	
	

}
	@Test
	public void deleteoption() {
		RestAssured.delete("http://localhost:8084/projects/TY_PROJ_2202").prettyPrint();
	}
}
