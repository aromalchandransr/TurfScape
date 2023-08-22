package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.TimeSlot;
import com.candella.service.TimeSlotServiceImp;

public class TimeSlotUtility {

	public static void main(String[] args) {
		char selectChoice;
		Scanner scanner=new Scanner(System.in);
		do {
			
		
		viewTimeSlots();

		System.out.println("do you want continue");
		selectChoice = scanner.next().charAt(0);
		if (selectChoice != 'y' && selectChoice != 'Y') {
	        MainUtility.mainMenu();
	    }
	} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	public static void viewTimeSlots() {
		TimeSlotServiceImp timeSlotService= new TimeSlotServiceImp();
		List<TimeSlot> timeList=timeSlotService.viewTimeSlots();
		System.out.println("----List of Time Slots------");
		
		
		System.out.println("Sl Num   |       Time        |   Slot");
		System.out.println("--------------------------------------");

		
		for (TimeSlot timeslot : timeList) {
		    
		    System.out.printf("%-8s | %-10s | %-10s%n", timeslot.getSlNum(), timeslot.getTime(), timeslot.getSlot());
		}

	
		System.out.println("--------------------------------------");

	}

}
