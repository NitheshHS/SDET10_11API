package com.rmg.apitest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Oauth2Test {
	
	@Test
	public void oauthTest() {
		Response res = given()
			.formParam("client_id", "SDET10_11")
			.formParam("client_secret", "180edaf9141e6a425abf10304c8a2d38")
			.formParam("grant_type", "client_credentials")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
//		res.then()
//			.log().all();
		String token=res.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
			.contentType(ContentType.JSON)
			.baseUri("http://coop.apps.symfonycasts.com")
			.auth().oauth2(token)
			.pathParam("USER_ID", "1301")
			.when()
				.post("/api/{USER_ID}/eggs-collect")
			.then()
				.log().all();
	}

}
