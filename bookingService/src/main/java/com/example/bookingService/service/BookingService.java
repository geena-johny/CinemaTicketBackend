package com.example.bookingService.service;

import java.util.List;

import com.example.bookingService.model.Booking;

public interface BookingService {

	public void addBooking(Booking booking) throws Exception;
	public void deleteBooking(Booking booking) throws Exception;
	public List<Booking> getBooking(Booking booking) throws Exception;

}
