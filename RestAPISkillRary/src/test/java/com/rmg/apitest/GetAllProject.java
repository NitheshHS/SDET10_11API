package com.rmg.apitest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

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
		String projectId="TY_PROJ_2804";
		given()
			.contentType(ContentType.JSON)
			.baseUri("http://localhost:8084")
			.pathParam("projectId", projectId)
		.when()
			.get("/projects/{projectId}")
		.then()
			.assertThat().statusCode(200)
		.and()
			.assertThat().time(Matchers.lessThan(300L), TimeUnit.MILLISECONDS)
		.and()
			.assertThat().body("projectId", Matchers.equalTo(projectId))
		.and()
			.assertThat().header("Content-Type", "application/json")
		.and()
			.assertThat().contentType(ContentType.JSON)
			.log().all();
	}

}
