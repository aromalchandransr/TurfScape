package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.User;
import com.candella.service.UserService;
import com.candella.service.UserServiceImp;

public class UserUtility {

	public static void main(String[] args) {
	 userMenu();
	}
		public static void userMenu() {
		Scanner scanner=new Scanner(System.in);
		char selectChoice;
		do
		{
			
		
		System.out.println("*****Welcome to TURFSCAPE******");
		System.out.println("Main MENU");
		System.out.println("1:Add user\n2:Update user\n3:View user\n4:Search user");
		int choice=scanner.nextInt();
		if(choice==1)
		{
			addUser();
		}
		else if (choice == 2) {
			updateUser();
			
	
		}
		else if(choice==3) {
			viewUsers();
		
		}
		else if(choice==4)
		{
			searchuser();
			
		}

		System.out.println("do you want continue");
		selectChoice = scanner.next().charAt(0);
		if (selectChoice != 'y' && selectChoice != 'Y') {
	        MainUtility.mainMenu();
	    }
	} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	

	private static User searchuser() {
		UserServiceImp userservice = new UserServiceImp();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the userid:");
		int userid=scanner.nextInt();
		User user= userservice.searchUser(userid);
		if (user !=null)
		{
			System.out.println("***User Details****");
			System.out.println("User ID:"+user.getUserId());
			System.out.println("Full name:"+user.getFirstName()+user.getLast_Name());
			System.out.println("Address:"+user.getAddress());
			System.out.println("Email:"+user.getEmail());
			System.out.println("Phone no:"+user.getPhone());
		}else
		{
			System.out.println("User not found");
		}
		return user;
		
		
	}



	private static void viewUsers() {
		UserServiceImp userservice = new UserServiceImp();
		List<User> userList = userservice.viewUsers();

		System.out.println("----List of Users------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-10s | %-15s | %-15s | %-30s | %-30s | %-15s%n", "User ID", "First Name", "Last Name", "Email", "Address", "Phone");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
		

		for (User user : userList) {
		    System.out.printf("%-10s | %-15s | %-15s | %-30s | %-30s | %-15s%n",
		            user.getUserId(), user.getFirstName(), user.getLast_Name(), user.getEmail(), user.getAddress(), user.getPhone());
		}

		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");


		
		
		
	}



	private static void updateUser() {
		UserServiceImp userservice=new UserServiceImp();
		Scanner scanner=new Scanner(System.in);
		System.out.println("***Update user Details");
		System.out.println("Enter the user id :");
		int userid=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the column to update");
		String columnname=scanner.nextLine();
		userservice.updateUser(userid,columnname);
		
	}



	private static void addUser() {
		UserService userservice= new UserServiceImp();
		Scanner scanner =new Scanner(System.in);
		 System.out.println("Enter USER Details");
		 System.out.println("USER ID");
		 int userid = scanner.nextInt();
		 scanner.nextLine();
		 System.out.println("First Name");
		 String firstname=scanner.nextLine();
		 scanner.nextLine();
		 System.out.println("Last Name");
		 String lastname=scanner.nextLine();
		 System.out.println("email");
		 String email =scanner.nextLine();
		 System.out.println("address");
		 String address=scanner.nextLine();
		 System.out.println("phone");
		 long phone =scanner.nextLong();
		 userservice.addUser(new User(userid,firstname,lastname,email,address,phone));
		 System.out.println("User added Successfully");

		
	
	}
}


