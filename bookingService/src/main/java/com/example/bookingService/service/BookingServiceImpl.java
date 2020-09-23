package com.example.bookingService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookingService.Dao.BookingDao;
import com.example.bookingService.model.Booking;

@Service(value="bookingService")
@Transactional
public class BookingServiceImpl implements BookingService{
	@Autowired
	BookingDao bookingDao;
	
	
	@Override
	public void addBooking(Booking booking) throws Exception{
		
			Integer a=bookingDao.addBooking(booking);
			if(a==0) {
				throw new Exception("Service.BOOKING_CANNOT_BE_COMPLETED");
			}
		
	}
	
	

	@Override
	public void deleteBooking(Booking booking) throws Exception{
			bookingDao.deleteBooking(booking);
	}
	
	
	@Override
	public List<Booking> getBooking(Booking booking) throws Exception{
		List<Booking> bookingList =null;
		try {
			bookingList = bookingDao.getBooking(booking);

			if (bookingList.isEmpty())
				throw new Exception("Service.BOOKING_NOT_FOUND");

		} catch (Exception e) {
			throw e;
		}
		return bookingList;
		
	}

}
