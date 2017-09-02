package jdbc;

import java.sql.*;
import java.util.ArrayList;

public class JdbcConnection {
	
	private static JdbcConnection instance = null;
	private Connection conn = null;
	
	// Empty constructor
	private JdbcConnection() {}
	
	// Singleton for the Jdbc connection instance
	public static synchronized JdbcConnection getJdbcConnection() {
		
		if(instance == null) {
			instance = new JdbcConnection();
		}
		
		return instance;
	}
	
	public void openConnection(String database, String user, String password) {
		try {
			// Class.forName is used to load classes. 
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/" + database;
			
			// DriverManager is a class which is extended from the Driver class we loaded earlier. 
			conn = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
		}
	}
	
	public void selectAll(String query) {
		ResultSet rs = null;
		ArrayList<String> result = new ArrayList<String>();
		
		try {
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
				while(rs.next()) 
				{
					result.add(rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getInt(3));
				}
			statement.close();
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
	}
	
	public void executeInsert(String query) {
		
		try {
			Statement statement = conn.createStatement();
			statement.executeQuery(query);
			statement.close();
		}
		catch(Exception e ) {
			System.out.println(e);
		}
		
	}
	
	
}
