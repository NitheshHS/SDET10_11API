package com.rmg.practice;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

//plain old java object
@JsonPropertyOrder(value = {
		"createdBy",
		"createdOn",
		"projectId",
		"projectName",
		"status",
		"teamSize"
})
public class ProjectPojo {

	String createdBy;
	String createdOn;
	String projectId;
	String projectName;
	String status;
	int teamSize;
	public ProjectPojo(String createdBy, String createdOn, String projectId, String projectName, String status,
			int teamSize) {
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.projectId = projectId;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}
	
	public ProjectPojo() {}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	
}
