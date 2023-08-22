package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.TurfOwner;
import com.candella.entity.User;
import com.candella.service.TurfOwnerServiceImp;



public class TurfOwnerUtility {

	public static void main(String[] args) {
		turfownerMenu();
	}
	public static void turfownerMenu() {
		
		Scanner scanner=new Scanner(System.in);
		char selectChoice;
		do
		{
			
		
	
		System.out.println("Main MENU");
		System.out.println("1:Add Turf Owner\n2:Update Turf Owner\n3:View Turf Owner\n4:Search Turf Owner");
		int choice=scanner.nextInt();
		if(choice==1)
		{
			addTurfOwner();
		}
		else if (choice == 2) {
			updateTurfOwner();
			
	
		}
		else if(choice==3) {
			viewTurfOwners();
		
		}
		else if(choice==4)
		{
			searchTurfOwner();
			
		}

		System.out.println("do you want continue");
		selectChoice = scanner.next().charAt(0);
		if (selectChoice != 'y' && selectChoice != 'Y') {
	        MainUtility.mainMenu();
	    }
	} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static TurfOwner searchTurfOwner() {
		TurfOwnerServiceImp turfOwnerService= new TurfOwnerServiceImp();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the owner ID:");
		int ownerid=scanner.nextInt();
		TurfOwner turfOwner= turfOwnerService.searchTurfOwner(ownerid);
		if (turfOwner !=null)
		{
			System.out.println("***Owner Details****");
			System.out.println("Owner ID:"+turfOwner.getOwnerId());
			System.out.println("Owner Name:"+turfOwner.getOwnerName());
			System.out.println("Address:"+turfOwner.getAddress());
			System.out.println("Phone no:"+turfOwner.getPhone());
		}else
		{
			System.out.println("Turf Owner not found");
		}
		return turfOwner;
		
		
	}
		
	

	private static void viewTurfOwners() {
		TurfOwnerServiceImp turfOwnerService= new TurfOwnerServiceImp();
		List<TurfOwner> ownerList = turfOwnerService.viewTurfOwner();

		System.out.println("----List of Turf Owners------");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-10s | %-15s | %-15s | %-15s%n", "Owner ID", " Name","Address", "Phone");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		

		for (TurfOwner turfowner : ownerList) {
		    System.out.printf("%-10s | %-15s | %-15s | %-15s%n",
		            turfowner.getOwnerId(),turfowner.getOwnerName(),turfowner.getAddress(),turfowner.getPhone());
		}

		System.out.println("-----------------------------------------------------------------------------------------------------------------");


		
		
		
	}

		
		
	

	private static void updateTurfOwner() {
		TurfOwnerServiceImp turfOwnerService= new TurfOwnerServiceImp();
		Scanner scanner=new Scanner(System.in);
		System.out.println("***Update Turf Owner Details");
		System.out.println("Enter the Owner id :");
		int userid=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the column to update");
		String columnname=scanner.nextLine();
		turfOwnerService.updateTurfOwner(userid,columnname);
		
	}

	private static void addTurfOwner() {
		TurfOwnerServiceImp turfOwnerService= new TurfOwnerServiceImp();
		Scanner scanner =new Scanner(System.in);
		 System.out.println("Enter Turf Owner Details");
		 System.out.println("Owner ID");
		 int ownerid = scanner.nextInt();
		 scanner.nextLine();
		 System.out.println("Owner Name");
		 String name=scanner.nextLine();
		 System.out.println("address");
		 String address=scanner.nextLine();
		 System.out.println("phone");
		 long phone =scanner.nextLong();
		 turfOwnerService.addTurfOwner(new TurfOwner(ownerid,name,address,phone));
		 System.out.println("Turf Owner added Successfully");

		
	
	}
		
		
	


	}


