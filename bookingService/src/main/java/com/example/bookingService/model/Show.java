package com.example.bookingService.model;

public class Show {
	private Integer showId;
	private String movieName;
	private String theatreName;
	private String showTime;
	private Integer seatsAvailable;
	
	public Integer getShowId(){
		return showId;	
	}
	public void setShowId(Integer showId) {
		this.showId=showId;
	}
	public String getMovieName(){
		return movieName;	
	}
	public void setMovieName(String movieName) {
		this.movieName=movieName;
	}
	public String getTheatreName(){
		return theatreName;	
	}
	public void setTheatreName(String theatreName) {
		this.theatreName=theatreName;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String time) {
		this.showTime=showTime;
	}
	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable=seatsAvailable;
	}

}
