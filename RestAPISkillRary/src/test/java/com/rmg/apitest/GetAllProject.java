package com.rmg.apitest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetAllProject {
	
	@Test
	public void getProject() {
		given()
		.contentType(ContentType.JSON)
		.baseUri("http://localhost:8084")
		.when()
		.get("/projects")
		.then()
		.log().all();
		//prettyprint
	}
	
	@Test
	public void getProjectBypathParametr() {
		given()
			.contentType(ContentType.JSON)
			.baseUri("http://localhost:8084")
		.when()
			.get("/projects/TY_PROJ_2804")
		.then()
			.log().all();
	}

}
