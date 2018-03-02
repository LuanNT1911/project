package com.groupproject.adminweb.dto;

import java.io.Serializable;

public class Location implements Serializable{
	int id;
	double longitude;
	double latitude;
    int user_id;
	long time;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Location(int id, double longitude, double latitude, int user_id, long time) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.user_id = user_id;
		this.time = time;
	}
	
	
}
