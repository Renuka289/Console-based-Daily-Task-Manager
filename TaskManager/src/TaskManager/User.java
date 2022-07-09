package TaskManager;
import java.sql.*;

public class User {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
		
	}
	
	public String register(Connection con,String username, String password) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("insert into users values(?,?)");
		stmt.setString(1, username);
		stmt.setString(2, password);
		int i = stmt.executeUpdate();
		
		if (i>0) {
			return "User registered";
		} else {
			return "An error occured while trying to register user";
		}
		
	}
	
	public void login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void logout(String username, String password) {
		this.username = null;
		this.password = null;
	}
	
}
