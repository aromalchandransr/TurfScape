package com.candella.utility;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.candella.entity.Booking;
import com.candella.entity.LeastTimeSlot;
import com.candella.entity.TimeSlot;
import com.candella.entity.Turf;
import com.candella.entity.User;
import com.candella.service.BookingServiceImp;
import com.candella.service.TimeSlotServiceImp;
import com.candella.service.TurfServiceImp;

public class BookingUtility {

	public static void main(String[] args) {
		bookingMenu();	
	}
	public static void bookingMenu() {
		Scanner scanner = new Scanner(System.in);
		char selectChoice;
		do {

			System.out.println("Main MENU");
			System.out.println("1:Add Booking\n2:Update Booking\n3:View Booking\n4:Avialable turf based on time slot\n5:Least Booked time Slot");
			int choice = scanner.nextInt();
			if (choice == 1) {
				getBookingBasedonDate();
				addBooking();
			} else if (choice == 2) {
				updateBooking();

			} else if (choice == 3) {
				viewBooking();

			} else if (choice == 4) {
				TurfAvalableBasedOnSlot();

			}
		 else if (choice == 5) {
			LeastBookedTimeSlot();

		}
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
			if (selectChoice != 'y' && selectChoice != 'Y') {
		        MainUtility.mainMenu();
		    }
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void LeastBookedTimeSlot() {


		    BookingServiceImp bookingServiceImp = new BookingServiceImp();
		    TimeSlotServiceImp timeSlotServiceImp = new TimeSlotServiceImp();

		    List<Booking> bookingList = bookingServiceImp.viewBooking();
		    List<TimeSlot> timeSlotList = timeSlotServiceImp.viewTimeSlots();
		    HashMap<Integer, Integer> timeSlotMap = new HashMap<Integer, Integer>();

		    // Count occurrences of time slot IDs in the booking table
		    for (Booking booking : bookingList) {
		        int timeSlotId = booking.getSlot().getSlNum();

		        // Update the timeSlotMap to track occurrences of each time slot ID
		        timeSlotMap.put(timeSlotId, timeSlotMap.getOrDefault(timeSlotId, 0)+1);
		    }

		    // Find the least booked count
		    int minBookingCount = Integer.MAX_VALUE;
		    for (int bookingCount : timeSlotMap.values()) {
		        if (bookingCount < minBookingCount) {
		            minBookingCount = bookingCount;
		        }
		    }

		    // Print time slot IDs with least booked count
		    System.out.println("Time Slot IDs with the least booking count:");

		    for (TimeSlot timeSlot : timeSlotList) {
		        int timeSlotId = timeSlot.getSlNum();
		        int bookingCount = timeSlotMap.getOrDefault(timeSlotId, 0);

		        if (bookingCount <= minBookingCount) {
		        	LeastTimeSlot leastTimeSlot=new LeastTimeSlot();
		        	leastTimeSlot = new LeastTimeSlot(timeSlotId);
		            System.out.println("Time Slot ID: " + timeSlotId + ", Count: " + bookingCount);
		        }
		    }
		}


		
	
		
	

				   
	

	private static void TurfAvalableBasedOnSlot() {
		{
			 BookingServiceImp bookingServiceImp = new BookingServiceImp();
			
			 TurfServiceImp  turfServiceImp=new TurfServiceImp();
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    
			 Scanner scanner = new Scanner(System.in);
		     System.out.println("Enter the date for booking: ");
		     String date = scanner.nextLine();
		     System.out.println("Enter the time slot");
		     int time=scanner.nextInt();
		     
		     
		     LocalDate BookingDate = LocalDate.parse(date, formatter);
		     
		     List<Booking> bookingsList = bookingServiceImp.getAllBookingBasedONSlot(BookingDate,time);
		     List<Turf> turfList=turfServiceImp.viewTurf();
		     List<Turf> turfnotbooked=new ArrayList<>(turfList);
		     turfnotbooked=turfList;
		     if(bookingsList != null) {
		    	 System.out.println("booking list "+ bookingsList.size());
		     for (Booking booking:bookingsList)
		     {  	 
		      	
		    	
		    		 turfnotbooked.removeIf(turf ->turf.getTurfId()==(booking.getTurf().getTurfId()));
		    	 
		     }
		     if(!turfnotbooked.isEmpty()) {
		    	 System.out.println("Turfs not booked on "+ date +":");
		    	 for (Turf turf:turfnotbooked)
		    	 {
		    		 
		    		 
		    		 System.out.println("Turf Id:"+turf.getTurfId());
		    		 System.out.println("Turf Location:"+turf.getLocation());
		    	 }
		     }
		     }
		     else
		    	 System.out.println("No Turfs available on this date and time slot");
			
				
			}

	}


	private static void viewBooking() {
		BookingServiceImp bookingServiceImp = new BookingServiceImp();
		List<Booking> bookingList = bookingServiceImp.viewBooking();

		System.out.println("----List of Bookings----");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-10s | %-10s | %-10s | %-12s | %-10s | %-10s | %-10s |%-15s%n",
		        "Booking ID", "User ID", "Turf ID", "Booking Date", "Start Time", "End Time", "Slot ID", "Booking Status");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		for (Booking booking : bookingList) {
		    System.out.printf("%-10s | %-10s | %-10s | %-12s | %-10s | %-10s | %-10s |%-15s%n",
		            booking.getBookingId(),
		            booking.getUser().getUserId(),
		            booking.getTurf().getTurfId(),
		            booking.getBookingDate().format(dateFormatter),
		            booking.getStartTime().format(timeFormatter),
		            booking.getEndTime().format(timeFormatter),
		            booking.getSlot().getSlNum(),
		            booking.getBookingStatus());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");

	}
		

	private static void updateBooking() {
		// TODO Auto-generated method stub

	}

	private static void addBooking() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		BookingServiceImp bookingService = new BookingServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Booking details");
		System.out.println("Booking ID");
		int bookingId = scanner.nextInt();
		System.out.println("User ID");
		int uid = scanner.nextInt();
		System.out.println("Turf ID");
		int tid = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Booking Date");
		String bookingDate = scanner.nextLine();
		LocalDate bdate = LocalDate.parse(bookingDate, formatter);
		scanner.nextLine();
		System.out.println("Start Time");
		String starttime = scanner.nextLine();
		LocalTime stime = LocalTime.parse(starttime, timeFormatter);
		System.out.println("End Time");
		String endtime = scanner.nextLine();
		LocalTime etime = LocalTime.parse(endtime, timeFormatter);
		
		scanner.nextLine();
		System.out.println("Slot ID");
		int slotId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Booking Status");
		String bstatus = scanner.nextLine();
		User user = new User();
		user.setUserId(uid);
		Turf turf = new Turf();
		turf.setTurfId(tid);
		TimeSlot slot=new TimeSlot();
		slot.setSlNum(slotId);
		bookingService.addBooking(new Booking(bookingId, user, turf, bdate, stime, etime,slot, bstatus));
		System.out.println("Booking added Successfully");

	}
	private static void getBookingBasedonDate()
	{
	 BookingServiceImp bookingServiceImp = new BookingServiceImp();
	 TurfServiceImp  turfServiceImp=new TurfServiceImp();
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	 Scanner scanner = new Scanner(System.in);
     System.out.println("Enter the date for booking: ");
     String date = scanner.nextLine();
     ;
     System.out.println("Enter the  Location: ");
     String location=scanner.nextLine();
     TurfUtility turfUtility= new TurfUtility();
     
     System.out.println("Enter the start time for booking: ");
     String timeStart = scanner.nextLine();
     LocalDate BookingDate = LocalDate.parse(date, formatter);
     LocalTime time= LocalTime.parse(timeStart,timeFormatter);
     turfUtility.viewTurfBasedOnLOcation(location);
     List<Booking> bookingsList = bookingServiceImp.getAllBookingBasedONDate(BookingDate,time);
     List<Turf> turfList=turfServiceImp.viewTurf();
     List<Turf> turfnotbooked=new ArrayList<>(turfList);
     turfnotbooked=turfList;
     if(bookingsList != null) {
    	 System.out.println("booking list "+ bookingsList.size());
     for (Booking booking:bookingsList)
     {  	 
      	
    	
    		 turfnotbooked.removeIf(turf ->turf.getTurfId()==(booking.getTurf().getTurfId()));
    	 
     }
     if(!turfnotbooked.isEmpty()) {
    	 System.out.println("Turfs not booked on "+ date +":");
    	 for (Turf turf:turfnotbooked)
    	 {
    		 if(turf.getLocation().equalsIgnoreCase(location))
    		 {
    		 System.out.println("Turf Id:"+turf.getTurfId());
    		 System.out.println("Turf Location:"+turf.getLocation());
    	 }}
     }
     }
     else
    	 System.out.println("No Turfs available on this date");
	
		
	}
	public static int searchBooking(int bookingId) {
		BookingServiceImp bookingServiceImp=new BookingServiceImp();
		Booking booking=bookingServiceImp.searchBooking(bookingId);
		
		int turfid = 0;
	
		 turfid=booking.getTurf().getTurfId();
		return turfid;
	
		
	}

}
