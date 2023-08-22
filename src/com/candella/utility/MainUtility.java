package com.candella.utility;

import java.util.Scanner;


public class MainUtility {
	

	public static void main(String[] args) {
		mainMenu();
	}
	public static void mainMenu() {
		char selectChoice;
		Scanner scanner = new Scanner(System.in);
	
		do {	
		
		System.out.println("         *****************  Welcome to TurfScape ******************");
		System.out.println("  ");
		System.out.println("                    Explore and Book your turfs here   ");
		System.out.println("   ");
		System.out.println("           ------------------------------~*~---------------------------------");
		System.out.println("   ");
		System.out.println("               ****** TurfScape Main Menu  *******       ");
		System.out.println("   ");
		System.out.println("       		 	1.User Registration Management");
		System.out.println("       			2.Turf Owner Management");
		System.out.println("        		3.Turf Management ");
		System.out.println("		        4.Booking Management");
		System.out.println("        		5.FeedBack Management  ");
		System.out.println("         		6.Payment Management ");
		System.out.println("       			7.fare chart ");
		System.out.println("        		8.time slot details ");

		System.out.println("Enter your choice: ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			 UserUtility.userMenu();
			break;
		case 2:
			TurfOwnerUtility.turfownerMenu();
			break;
		case 3:
			TurfUtility.turfMenu();
			break;
		case 4:
			BookingUtility.bookingMenu();
			break;
		case 5:
			FeedBackUtility.feedBackMenu();
			break;
		case 6:
			PaymentUtility.paymentMenu();
			break;
		case 7:
			FareUtility.viewFare();
			break;
		case 8:
			TimeSlotUtility.viewTimeSlots();
			break;
		default:
			System.out.println("Invalid choice. Please select again.");
			System.out.println("Do you want to continue (y/n)?");
		}
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}
	}


