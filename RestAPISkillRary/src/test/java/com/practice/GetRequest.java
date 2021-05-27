package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class GetRequest {
	

	@Test
	public void getReqTest() {
		List<Object> list=new ArrayList<Object>();
		list.add("userid1");
		list.add("userid2");
		list.add("userid3");
		list.add("userid4");
		list.add("userid5");
		
		List<Object> userId=new ArrayList<Object>();
		Response res = given()
			.contentType(ContentType.JSON)
			.baseUri("http//localhost:8888")
		.when()
			.get("/endpoint");
		
		 List<Object> resBody = res.getBody().jsonPath().getList("userid");
		 Assert.assertTrue(resBody.size()>=5);
		 
		 for(int i=0;i<=5;i++) {
			 userId.add(res.jsonPath().get("["+i+"].userID"));
		 }
		 Assert.assertEquals(userId, list);
		
		
		
		
	}

}
