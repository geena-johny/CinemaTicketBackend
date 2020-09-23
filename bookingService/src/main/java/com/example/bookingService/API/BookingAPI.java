package com.example.bookingService.API;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.bookingService.model.Booking;
import com.example.bookingService.service.BookingService;


@RestController
@CrossOrigin
@RequestMapping(value="/bookingservice")
public class BookingAPI {
	@Autowired
	private BookingService bookingService;
	@Autowired
	Environment env;
	
	
	@PostMapping(value="/ticketBooking")
	public JSONObject addBooking(@RequestBody Booking boookingDetails) throws Exception{
		try {
			bookingService.addBooking(boookingDetails);
//			Integer bid=boookingDetails.getBookingId();
			JSONObject obj=new JSONObject();
			obj.put("Booking", "successfully completed");
			return obj;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
		}
	}
	
	
	@PostMapping(value="/cancelBooking")
	public JSONObject deleteBooking(@RequestBody Booking booking) throws Exception{
		try {
			bookingService.deleteBooking(booking);
			JSONObject obj=new JSONObject();
			obj.put("Booking", "successfully cancelled");
			return obj;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
		}
		
	}
	
	
	
	@PostMapping(value="/getBooking")
	public ResponseEntity <List<Booking>> getBookingList(@RequestBody Booking booking) throws Exception{
		try {
			List<Booking> bookings=new ArrayList<Booking>();
			bookings=bookingService.getBooking(booking);
			ResponseEntity<List<Booking>> bookingList=new ResponseEntity<List<Booking>>(bookings,HttpStatus.OK);
			return bookingList;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
		}
	}

}
