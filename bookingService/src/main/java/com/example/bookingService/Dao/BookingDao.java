package com.example.bookingService.Dao;

import java.util.List;

import com.example.bookingService.model.Booking;

public interface BookingDao {
	public Integer addBooking(Booking booking) throws Exception;
	public void deleteBooking(Booking booking) throws Exception;
	public List<Booking> getBooking(Booking booking) throws Exception;

}
