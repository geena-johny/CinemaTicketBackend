package com.example.bookingService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theatre")
public class TheatreEntity {
	@Id
	@Column(name="theatre_name")
	private String theatreName;
	@Column(name="location")
	private String location;
	@Column(name="seat_capacity")
	private Integer seatingCapacity;
	@Column(name="rate")
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
	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity=seatingCapacity;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate=rate;
	}


}
