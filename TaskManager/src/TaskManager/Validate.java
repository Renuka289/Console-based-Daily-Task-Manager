package TaskManager;

import java.util.Scanner;

public class Validate {

	public String validateUsername(Scanner sc) {
		String username = "";
		boolean result = false;
		do {
			System.out.println("Enter the username: ");
			username = sc.nextLine();
			if (username.length() > 20 || username.length() < 8) {
				System.out.println("Username should contains at least 8 characters and atmost 20 characters");
				result = false;
			} else {
				result = true;
			}
		} while(result == false);
		
		return username;
	}
	
	public String validatePassword(Scanner sc) {
		String password = "";
		boolean result = false;
		do {
			System.out.println("Enter the password: ");
			password = sc.nextLine();
			if (password.length() > 20 || password.length() < 8) {
				System.out.println("Password should contains at least 8 characters and atmost 20 characters");
				result = false;
			} else {
				result = true;
			}
		} while(result == false);
		
		return password;
	}
	
	public String validateTitle(Scanner sc) {
		String title = "";
		boolean result = false;
		do {
			System.out.println("Enter the title: ");
			title = sc.nextLine();
			if (title.length() > 50) {
				System.out.println("Title should contains atmost 50 characters");
				result = false;
			} else {
				result = true;
			}
		} while(result == false);
		
		return title;
	}
	
	public String validateDescription(Scanner sc) {
		String description = "";
		boolean result = false;
		do {
			System.out.println("Enter the description: ");
			description = sc.nextLine();
			if (description.length() > 50) {
				System.out.println("Description should contains atmost 100 characters");
				result = false;
			} else {
				result = true;
			}
		} while(result == false);
		
		return description;
	}
	
}
