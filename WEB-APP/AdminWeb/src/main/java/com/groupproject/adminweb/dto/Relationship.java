package com.groupproject.adminweb.dto;

import java.io.Serializable;

public class Relationship implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6191152449495132237L;
	private int id;
	private int requestUserId;
	private int responseUserId;
	private boolean checkaccept;
	private boolean shareLocation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRequestUserId() {
		return requestUserId;
	}
	public void setRequestUserId(int requestUserId) {
		this.requestUserId = requestUserId;
	}
	public int getResponseUserId() {
		return responseUserId;
	}
	public void setResponseUserId(int responseUserId) {
		this.responseUserId = responseUserId;
	}
	public boolean isCheckaccept() {
		return checkaccept;
	}
	public void setCheckaccept(boolean checkaccept) {
		this.checkaccept = checkaccept;
	}
	public boolean getShareLocation() {
		return shareLocation;
	}
	public void setShareLocation(boolean shareLocation) {
		this.shareLocation = shareLocation;
	}
	
	
	public Relationship() {
		// TODO Auto-generated constructor stub
	}
	public Relationship(int id, int requestUserId, int responseUserId, boolean checkaccept, boolean shareLocation) {
		super();
		this.id = id;
		this.requestUserId = requestUserId;
		this.responseUserId = responseUserId;
		this.checkaccept = checkaccept;
		this.shareLocation = shareLocation;
	}
	
	
}
