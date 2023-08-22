package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.Fare;

import com.candella.service.FareServiceImp;

public class FareUtility {

	public static void main(String[] args) {
		char selectChoice;
		Scanner scanner=new Scanner(System.in);
		do {
			
		
		viewFare();

	System.out.println("do you want continue");
	selectChoice = scanner.next().charAt(0);
	if (selectChoice != 'y' && selectChoice != 'Y') {
        MainUtility.mainMenu();
    }
} while (selectChoice == 'y' || selectChoice == 'Y');
}

	public static void viewFare() {
		
		FareServiceImp fareService=new FareServiceImp();
		List<Fare> fareList=fareService.viewFare();
		System.out.println("----Turf Fare Details------");
		
		
		System.out.println("Fare ID   | Turf ID    |   Fare/2hr");
		System.out.println("--------------------------------------");

		
		for (Fare fare : fareList) {
		    
		    System.out.printf("%-8s | %-10s | %-10s%n", fare.getFareId(),fare.getTurf().getTurfId(),fare.getFare());
		}

	
		System.out.println("--------------------------------------");

	}

		
	}


