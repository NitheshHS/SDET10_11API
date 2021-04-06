package com.rmg.apitest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class PathParameter {
	
	@Test
	public void getProject() {
		given()
			.contentType(ContentType.JSON)
			.baseUri("http://localhost:8084")
			.pathParam("projectId", "TY_PROJ_2402")
		.when()
			.get("/projects/{projectId}")
		.then()
			.log().all();
	
	}

}
