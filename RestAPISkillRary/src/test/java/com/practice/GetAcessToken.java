package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetAcessToken {
	
	@Test
	public void getAcessTokenTest() {
		RestAssured.baseURI="https://bookstore.toolsqa.com";
		AuthorizationRequest credentials = new AuthorizationRequest("TOOLSQA-Test","Test@@123");
		 Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.body(credentials)
		.when()
			.post("/Account/v1/GenerateToken");
		response.then()
			.log().all();
		
		Token token = response.getBody().as(Token.class);
		
		Assert.assertEquals("Success", token.status);
		Assert.assertEquals("User authorized successfully.", token.result);
	}
	
	@Test
	public void getAllBooks() {
		RestAssured.baseURI="https://bookstore.toolsqa.com";
		Response response = RestAssured.given()
			.contentType(ContentType.JSON)
		.when()
			.get("/BookStore/v1/Books");
		response.then()
			.log().all();
		
		Books books = response.getBody().as(Books.class);
		for(int i=0;i<books.books.size();i++) {
		System.out.println(books.books.get(i).author);
		}
	}

}
