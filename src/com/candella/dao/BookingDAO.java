package com.candella.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.candella.entity.Booking;
import com.candella.entity.User;



public interface BookingDAO {
	public void addBooking(Booking booking);

	public void updateBooking(int bookingId, String columnname);

	public List<Booking> viewBooking();
	
	public Booking searchBooking(int bookingId);
	
	public List<Booking> getAllBookingBasedONDate(LocalDate bookingDate,LocalTime time);
	

}
