package TaskManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task {

	String username;
	String title;
	String description;
	String status;
	LocalDateTime date;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String create(Connection con, User user, String title, String description) throws Exception {
		this.status = "Incomplete";
		this.date = LocalDateTime.now();
		String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		
		PreparedStatement stmt = con.prepareStatement("insert into task values(?,?,?,?,?)");
		stmt.setString(1, user.getUsername());
		stmt.setString(2, title);
		stmt.setString(3, description);
		stmt.setString(4, status);
		stmt.setString(5, formattedDate);
		
		int i = stmt.executeUpdate();
		
		if (i>0) {
			return "Task Added";
		} else {
			return "An error occured while trying to add task";
		}
	}

	public void update(Connection con, Scanner sc, String taskName) throws Exception {
		int upch = Integer.parseInt(sc.nextLine());;
		PreparedStatement stmt;
		Validate validate = new Validate();
		ResultSet rs;
		switch(upch) {
			case 1:
				System.out.println("Enter the new title: ");
				String newTitle = validate.validateTitle(sc);
				stmt = con.prepareStatement("update task set title = ? where title = ?");
				stmt.setString(1, newTitle);
				stmt.setString(2, taskName);
				
				rs = stmt.executeQuery();
				System.out.println("Task Updated");
				break;
			case 2:
				System.out.println("Enter the new description: ");
				String newDescription = validate.validateDescription(sc);
				stmt = con.prepareStatement("update task set description = ? where title = ?");
				stmt.setString(1, newDescription);
				stmt.setString(2, taskName);
				
				rs = stmt.executeQuery();
				System.out.println("Task Updated");
				break;
			case 3:
				System.out.println("Choose the status: \n1. Complete \n2. Incomplete");
				int stup = Integer.parseInt(sc.nextLine());;
				String newStatus = "Incomplete";
				switch (stup) {
					case 1:
						newStatus = "Complete";
						break;
					case 2:
						newStatus = "Incomplete";
						break;
					default:
						System.out.println("Invalid option");
				}
				stmt = con.prepareStatement("update task set status = ? where title = ?");
				stmt.setString(1, newStatus);
				stmt.setString(2, taskName);
				
				rs = stmt.executeQuery();
				System.out.println("Task Updated");
				
				break;
			default:
				System.out.println("Invalid option");
				
		}
	}

	public String delete(Connection con, User user, String taskname) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("delete from task where title = ? and username = ?");
		stmt.setString(1, taskname);
		stmt.setString(2, user.getUsername());
		
		ResultSet rs = stmt.executeQuery();
		
		return "Task deleted";
	}
}
