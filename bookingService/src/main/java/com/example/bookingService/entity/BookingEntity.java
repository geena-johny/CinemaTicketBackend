package com.example.bookingService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class BookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="booking_id")
	private Integer bookingId;
	@Column(name="show_date")
	private String showDate;
	@Column(name="seats")
	private Integer seatsBooked;
	@Column(name="total_price")
	private Integer totalPrice;
	@JoinColumn(name="user_name")
	private String userName;
	@JoinColumn(name="movie_name")
	private String movieName;
	@JoinColumn(name="theatre_name")
	private String theatreName;
	@JoinColumn(name="show_time")
	private String showTime;
	
	
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId=bookingId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName=movieName;
	}
	public String getTheatreName() {
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
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate=showDate;
	}
	public Integer getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(Integer seatsBooked) {
		this.seatsBooked=seatsBooked;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice=totalPrice;
	}


}
