package com.example.theatreService.entity;

public class TheatreEntity {
	
	@Entity
	@Table(name="theatre")
	private String theatreName;
	private String location;
	private Integer seatingCapacity;
	private Integer rate;
	
	
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName=theatreName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity() {
		this.seatingCapacity=seatingCapacity;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate() {
		this.rate=rate;
	}

}
