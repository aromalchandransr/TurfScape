package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.dao.FareDAOImp;
import com.candella.entity.Booking;
import com.candella.entity.Payment;
import com.candella.service.PaymentServiceImp;

public class PaymentUtility {

	public static void main(String[] args) {
		paymentMenu();
	}
	public static void paymentMenu() {
		Scanner scanner=new Scanner(System.in);
		char selectChoice;
		do
		{
			
		
	
		System.out.println("Main MENU");
		System.out.println("1:Add Payment\n2:View Payment");
		int choice=scanner.nextInt();
		if(choice==1)
		{
			addPayment();
		}
		else if (choice == 2) {
			viewPayment();
		}
	
		
		System.out.println("do you want continue");
		selectChoice = scanner.next().charAt(0);
		if (selectChoice != 'y' && selectChoice != 'Y') {
	        MainUtility.mainMenu();
	    }
	} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void viewPayment() {
		PaymentServiceImp paymentService=new PaymentServiceImp();
		List<Payment> paymentList=paymentService.viewPayment();
		System.out.println("*********Payment Details********");
		
		System.out.printf("%-15s %-15s %-15s %-20s %-15s%n",
			    "Payment ID", "Booking ID", "Total Cost", "Payment Method", "Payment Status");
			System.out.println("---------------------------------------------------------------");

			for (Payment payment : paymentList) {
			    System.out.printf("%-15s %-15s %-15s %-20s %-15s%n",
			        payment.getPaymentId(),
			        payment.getBookingID().getBookingId(),
			        payment.getTotalCost(),
			        payment.getPaymentMethod(),
			        payment.getPaymentStatus());
			}
	}
	private static void addPayment() {
		
		PaymentServiceImp paymentService=new PaymentServiceImp();
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter payment details");
		System.out.println("Payment ID");
		int paymentId=scanner.nextInt();
		System.out.println("Booking ID");
		int bookigId=scanner.nextInt();
	    int turfid=BookingUtility.searchBooking(bookigId);
	    double fare=FareDAOImp.searchFare(turfid);
		System.out.println("Total Cost"+fare);
		
		scanner.nextLine();
		System.out.println("Payment Method");
		String paymentMethod=scanner.nextLine();
		scanner.nextLine();
		System.out.println("Payment Status");
		String paymentStatus=scanner.nextLine();
		Booking booking=new Booking();
		booking.setBookingId(bookigId);
		paymentService.addPayment(new Payment(paymentId,booking,fare,paymentMethod,paymentStatus));
		System.out.println("Payment Intiated Sucessfully");
		
	}


	}


