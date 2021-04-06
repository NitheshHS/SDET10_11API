package com.rmg.apitest;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rmg.practice.ProjectPojo;

import io.restassured.http.ContentType;
public class CreateProject {
	
	@Test
	public void createProject() {
		ProjectPojo project = new ProjectPojo("Nithesh", 
				"06/04/2021", "TY_01", "Skill22", "on going", 1);
		given()	
			.body(project)
			.contentType(ContentType.JSON)
			.baseUri("http://localhost:8084")
			
		.when()
			.post("/addProject")
		.then()
			.log().all();
		
	}
}
