package TaskManager;
import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projectdb","projectdb123");
        Statement stmt = con.createStatement();

        Scanner sc = new Scanner(System.in);		
		System.out.println("1. New user \n2. Already existing user");		
		String option = sc.nextLine();
		
		String ch = "y";
		
		User user = new User();
		Task task = new Task();
		Validate validate = new Validate();
		
		String username;
		String password;
		String taskName;
		boolean  records;
		PreparedStatement query;
		
		switch(option){
			//Register new user
			case "1":
				do {
					try {
						username = validate.validateUsername(sc);
						password = validate.validatePassword(sc);
						
						System.out.println(user.register(con, username, password));
						user.login(username, password);
						ch = "n";
					} catch (Exception e) {
						System.out.println("username taken");
					}
				}while(ch.equals("y"));					
				break;
				
			//Login to already existing user
			case "2":
				System.out.println("Enter the username: ");
				username = sc.nextLine();
				System.out.println("Enter the password: ");
				password = sc.nextLine();
				
				query = con.prepareStatement("Select * from users where username = ?");
				query.setString(1, username);
				
				ResultSet rs = query.executeQuery();
				
				records = false;
				while(rs.next()) {
					records = true;
					if (rs.getString("username").equals(username)) {
						if (rs.getString("password").equals(password)) {
							user.login(username, password);
						}
						else {
							System.out.println("Invalid password");
						}
					}
					else {
						System.out.println("Invalid username");
					}
				}
				if (!records) {
					System.out.println("User not found");
					user.setUsername(null);
				}
				break;
			default:
				System.out.println("Invalid option");
		}
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------
		//Task display
		if(user.getUsername()==null) {
			System.out.println("Login to view tasks");
		} else {
			String ech = "y";
			do {
				System.out.println("Tasks \n1. Create task \n2. Update task\n3. Delete task\n4. Show all tasks \n5.Logout");
				String choice = sc.nextLine();
				switch(choice) {
				
					//Create new task
					case "1":
						String title = validate.validateTitle(sc);
						String description = validate.validateDescription(sc);
						
						task.create(con, user, title, description);
						System.out.println("Task created");
						break;
					
					//Update Task
					case "2":
						System.out.println("Enter the name of the task you want to update: ");
						taskName = sc.nextLine();
						System.out.println("What do you want to update \n1. Title \n2. Description \n3. Status");
						task.update(con, sc, taskName);
						break;
						
					//Delete task
					case "3":
						System.out.println("Enter the name of the task you want to delete: ");
						taskName = sc.nextLine();
						System.out.println(task.delete(con, user, taskName));
						break;
						
					//Show all the task
					case "4":
						query =  con.prepareStatement("Select * from task where username = ?");
						query.setString(1, user.getUsername());
						ResultSet rs = query.executeQuery();

						System.out.println("---------------------------------------------");  
						System.out.printf("%5s %20s %15s", "TITLE", "Description", "STATUS");  
						System.out.println();
						System.out.println("---------------------------------------------");
						
						records = false;
						while(rs.next()) {
							records = true;
							System.out.printf("%5s %20s %15s", rs.getString("title"), rs.getString("description"), rs.getString("status"));  
							System.out.println();
						}
						if (!records) {
							System.out.println("No records found");
						}
						System.out.println("---------------------------------------------");						
						break;
						
					//Logout
					case "5":
						user.logout(user.getUsername(), user.getPassword());
						ech = "n";
						break;
					default:
						System.out.println("Invalid option");
				}
			}while(ech.equals("y"));
			
		}
		
		sc.close();
        con.close();
        stmt.close();
	}

}
