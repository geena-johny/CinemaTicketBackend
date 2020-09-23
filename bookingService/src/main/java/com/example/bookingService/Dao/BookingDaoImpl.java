package com.example.bookingService.Dao;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.bookingService.entity.BookingEntity;
import com.example.bookingService.entity.ReportsEntity;
import com.example.bookingService.entity.ShowEntity;
import com.example.bookingService.model.Booking;


@Repository("bookingDao")
public class BookingDaoImpl implements BookingDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Integer addBooking(Booking booking) throws Exception{
		BookingEntity bookingEntity=new BookingEntity();
		ReportsEntity reportsEntity= new ReportsEntity();
		ShowEntity showEntity= new ShowEntity();
		System.out.println("1");
		Query query=em.createQuery("select u from ShowEntity u where u.movieName=?1 and u.theatreName=?2 and u.showTime=?3");
		System.out.println("2");
		query.setParameter( 1,booking.getMovieName());
		query.setParameter( 2,booking.getTheatreName());
		query.setParameter( 3,booking.getShowTime());
		List<ShowEntity> showList=query.getResultList();
		ShowEntity val=showList.get(0);
		System.out.println("4");
		if(!showList.isEmpty() && val.getSeatsAvailable()>booking.getSeatsBooked()) {
			bookingEntity.setUserName(booking.getUserName());
			bookingEntity.setShowTime(booking.getShowTime());
			bookingEntity.setShowDate(booking.getShowDate());
			bookingEntity.setMovieName(booking.getMovieName());
			bookingEntity.setTheatreName(booking.getTheatreName());
			bookingEntity.setSeatsBooked(booking.getSeatsBooked());
			System.out.println("78");
			Query qy=em.createQuery("select a.rate from TheatreEntity a where a.theatreName=:tname");
			qy.setParameter("tname",booking.getTheatreName());
			Integer ticketRate=(Integer)qy.getSingleResult();
			Integer totalprice=booking.getSeatsBooked()*ticketRate;
			bookingEntity.setTotalPrice(totalprice);
			
			em.persist(bookingEntity);
			
			Integer seatsRemaining=(val.getSeatsAvailable())-(booking.getSeatsBooked());
			
			for(ShowEntity a:showList) {
				a.setSeatsAvailable(seatsRemaining);
			}
			reportsEntity.setBookingId(bookingEntity.getBookingId());
			reportsEntity.setUserName(bookingEntity.getUserName());
			reportsEntity.setShowTime(bookingEntity.getShowTime());
			reportsEntity.setShowDate(bookingEntity.getShowDate());
			reportsEntity.setMovieName(bookingEntity.getMovieName());
			reportsEntity.setTheatreName(bookingEntity.getTheatreName());
			reportsEntity.setSeatsBooked(bookingEntity.getSeatsBooked());
			reportsEntity.setTotalPrice(bookingEntity.getTotalPrice());
			reportsEntity.setStatus("Booked");
			
			em.persist(reportsEntity);  
			
			return bookingEntity.getBookingId();
		}
		
		return 0;
	}
	
	
	
	
	@Override
	public void deleteBooking(Booking booking) throws Exception{
		BookingEntity bookingEntity=em.find(BookingEntity.class, booking.getBookingId());
		if(bookingEntity!=null) {
			em.remove(bookingEntity);
			Query q=em.createQuery("select a from ReportsEntity a where a.bookingId=:bId");
			q.setParameter("bId", booking.getBookingId());
			List<ReportsEntity> report=q.getResultList();
			for(ReportsEntity a:report) {
				a.setStatus("Cancelled");
			}
			System.out.println("7878");
			Query query=em.createQuery("select u from ShowEntity u where u.movieName=?1 and u.theatreName=?2 and u.showTime=?3");
			query.setParameter( 1,bookingEntity.getMovieName());
			query.setParameter( 2,bookingEntity.getTheatreName());
			query.setParameter( 3,bookingEntity.getShowTime());
			System.out.println(bookingEntity.getMovieName());
			System.out.println(bookingEntity.getShowTime());
			System.out.println(bookingEntity.getTheatreName());

			List<ShowEntity> showList=query.getResultList();
			System.out.println(showList.size());
			System.out.println("88");
			ShowEntity val=showList.get(0);
			System.out.println("1000");
			Integer seatsRemaining=(val.getSeatsAvailable())+(bookingEntity.getSeatsBooked());
			
			for(ShowEntity a:showList) {
				a.setSeatsAvailable(seatsRemaining);
			}
		}
		
		
	}
	
	
	
	
	@Override
	public List<Booking> getBooking(Booking booking) throws Exception{
		ShowEntity showEntity=new ShowEntity();
		Query query=em.createQuery("select u from BookingEntity u where u.userName=?1");
		query.setParameter(1, booking.getUserName());
		List<Booking> bookingList=new ArrayList<Booking>();
		List<BookingEntity> movies=query.getResultList();
		for(BookingEntity a:movies) {
			Booking val=new Booking();
			val.setUserName(a.getUserName());
			val.setBookingId(a.getBookingId());
			val.setMovieName(a.getMovieName());
			val.setTheatreName(a.getTheatreName());
			val.setShowTime(a.getShowTime());
			val.setShowDate(a.getShowDate());
			val.setSeatsBooked(a.getSeatsBooked());
			val.setTotalPrice(a.getTotalPrice());
			bookingList.add(val);
			
		}
		return bookingList;
	}
	

}
