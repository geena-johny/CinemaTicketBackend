package com.example.bookingService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="showing")
public class ShowEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="show_id")
	private Integer showId;
	@Column(name="show_t")
	private String showTime;
	@Column(name="seats_available")
	private Integer seatsAvailable;
	@JoinColumn(name="movie_name")
	private String movieName;
	@JoinColumn(name="theatre_name")
	private String theatreName;
	
	
	
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
	public void setShowTime(String showTime) {
		this.showTime=showTime;
	}
	public Integer getSeatsAvailable(){
		return seatsAvailable;	
	}
	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable=seatsAvailable;
	}

}
