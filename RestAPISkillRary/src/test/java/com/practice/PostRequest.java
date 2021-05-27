package com.practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;
public class PostRequest {
	@Test
	public void postReqTest() {
		int userID=01234567;
		String username="admin";
		int score=100;
		given()
			.contentType(ContentType.JSON)
			.baseUri("http://localhost:portNo")
			.pathParam("userID", userID)
			.pathParam("username", username)
			.pathParam("score", score)
		.when()
			.put("/endpoint/{userID}/{username}/{score}")
		.then()
			.assertThat().statusCode(200)
		.and()
			.assertThat().contentType(ContentType.JSON)
		.and()
			.assertThat().time(Matchers.lessThan(500L), TimeUnit.MILLISECONDS)
		.and()
			.log().all();
		
	}
}
