package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.Turf;
import com.candella.entity.TurfOwner;
import com.candella.service.TurfServiceImp;

public class TurfUtility {

	public static void main(String[] args) {
		turfMenu();
		
	}
	public static void turfMenu() {
		
		Scanner scanner=new Scanner(System.in);
		char selectChoice;
		do
		{
			
		
	
		System.out.println("Main MENU");
		System.out.println("1:Add Turf\n2:Update Turf\n3:View Turf\n4:Search Turf");
		int choice=scanner.nextInt();
		if(choice==1)
		{
			addTurf();
		}
		else if (choice == 2) {
			updateTurf();
			
	
		}
		else if(choice==3) {
			viewTurfs();
		
		}
		else if(choice==4)
		{
			searchTurf();
			
		}
		System.out.println("do you want continue");
		selectChoice = scanner.next().charAt(0);
		if (selectChoice != 'y' && selectChoice != 'Y') {
	        MainUtility.mainMenu();
	    }
	} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static Turf searchTurf() {
		TurfServiceImp turfServiceImp=new TurfServiceImp();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Turf ID:");
		int turfid=scanner.nextInt();
		Turf turf= turfServiceImp.searchTurf(turfid);
		if (turf !=null)
		{System.out.println("***Turf Details****");
		System.out.println("Turf ID:"+turf.getTurfId());
		System.out.println(" Turf Name:"+turf.getTurfName());
		System.out.println("Location:"+turf.getLocation());
		System.out.println("Owner_id:"+turf.getTurfowner().getOwnerId());
		System.out.println("Type:"+turf.getType());
	    System.out.println("Address:"+turf.getAddress());
	    System.out.println("Facilities:"+turf.getFacilities())	;
	    System.out.println("Size:"+turf.getSize());
	    System.out.println("Phone:"+turf.getPhone());
	}else
	{
		System.out.println("Turf not found");
	}
	return turf;
	
			
		}

	private static void viewTurfs() {
		TurfServiceImp turfServiceImp=new TurfServiceImp();
		List<Turf> turfList=turfServiceImp.viewTurf();
		System.out.println("----List of Turf Owners------");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-8s | %-15s | %-15s | %-8s | %-15s | %-25s | %-15s | %-10s | %-15s%n",
                "TurfID", "Turf Name", "Location", "Owner ID", "Type", "Address", "Facilities", "Size", "Phone");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for (Turf turf : turfList){
	
		System.out.printf("%-8s | %-15s | %-15s | %-8s | %-15s | %-25s | %-15s | %-10s | %-15s%n",
				turf.getTurfId(),turf.getTurfName(),turf.getLocation(),turf.getTurfowner().getOwnerId(),turf.getType(),turf.getAddress(),turf.getFacilities(),turf.getSize(),turf.getPhone());
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	}

	private static void updateTurf() {
		TurfServiceImp turfServiceImp=new TurfServiceImp();
		Scanner scanner=new Scanner(System.in);
		System.out.println("***Update Turf Details");
		System.out.println("Enter the Turf id :");
		int turfid=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the column to update");
		String columnname=scanner.nextLine();
		turfServiceImp.updateTurf(turfid, columnname);
		
		
	}

	private static void addTurf() {
		TurfServiceImp turfServiceImp=new TurfServiceImp();
		Scanner scanner =new Scanner(System.in);
		 System.out.println("Enter Turf Details");
		 System.out.println("Turf ID");
		 int turfid= scanner.nextInt();
		 scanner.nextLine();
		 System.out.println("Turf Name");
		 String tname=scanner.nextLine();
		 System.out.println("location");
		 String loc=scanner.nextLine();
		 System.out.println("ownerId");
		 int oid=scanner.nextInt();
		 scanner.nextLine();
		 System.out.println("type");
		 String type=scanner.nextLine();
		 System.out.println("Address");
		 String address=scanner.nextLine();
		 System.out.println("Facilities");
		 String facilities=scanner.nextLine();
		 System.out.println("size");
		 String size=scanner.nextLine();
		 System.out.println("Phone");
		 long phone=scanner.nextLong();
		 TurfOwner turfOwner=new TurfOwner();
		 turfOwner.setOwnerId(oid);
		 turfServiceImp.addTurf(new Turf(turfid,tname,loc,type,address,facilities,size,phone, turfOwner));
		 System.out.println("Turf added Successfully");
		 
		
	
		
	}
	public void viewTurfBasedOnLOcation(String location) {
		TurfServiceImp turfServiceImp=new TurfServiceImp();
		List<Turf> turfList=turfServiceImp.viewTurfBasedOnLocation(location);
		System.out.println("----List of Turf Owners------");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-8s | %-15s | %-15s | %-8s | %-15s | %-25s | %-15s | %-10s | %-15s%n",
                "TurfID", "Turf Name", "Location", "Owner ID", "Type", "Address", "Facilities", "Size", "Phone");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for (Turf turf : turfList){
	
			if(turf.getLocation().equalsIgnoreCase(location))
		System.out.printf("%-8s | %-15s | %-15s | %-8s | %-15s | %-25s | %-15s | %-10s | %-15s%n",
				turf.getTurfId(),turf.getTurfName(),turf.getLocation(),turf.getTurfowner().getOwnerId(),turf.getType(),turf.getAddress(),turf.getFacilities(),turf.getSize(),turf.getPhone());
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	}

}

