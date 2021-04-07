package com.rmg.apitest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class BasicAuthTest {

	@Test
	public void basicAuthTest() {
		
		//username: rmgyantra
		//password: rmgy@9999
		given()
			.contentType(ContentType.JSON)
			.baseUri("http://localhost:8084")
			.auth()
			.basic("rmgyantra", "rmgy@9999")
		.when()
			.get("/login")
		.then()
			.log().all();
	}
}
