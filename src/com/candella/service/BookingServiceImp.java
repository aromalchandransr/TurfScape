package com.candella.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.candella.dao.BookingDAOImp;
import com.candella.entity.Booking;

public class BookingServiceImp implements BookingService {
	BookingDAOImp bookingDAOImp=new BookingDAOImp();

	@Override
	public void addBooking(Booking booking) {
		bookingDAOImp.addBooking(booking);
		

	}

	@Override
	public void updateBooking(int bookingId, String columnname) {
		bookingDAOImp.updateBooking(bookingId, columnname);

	}

	@Override
	public List<Booking> viewBooking() {
		
		return bookingDAOImp.viewBooking();
	}

	@Override
	public Booking searchBooking(int bookingId) {
		
		return bookingDAOImp.searchBooking(bookingId);
	}

	@Override
	public List<Booking> getAllBookingBasedONDate(LocalDate bookingDate, LocalTime time) {
		
		return bookingDAOImp.getAllBookingBasedONDate(bookingDate,time);
	}

	public List<Booking> getAllBookingBasedONSlot(LocalDate bookingDate, int time) {
		
		return bookingDAOImp.getAllBookingBasedONSlot(bookingDate, time);
	}

}
