package jdbc;

import java.sql.*;
import java.util.ArrayList;

/*
 * Made a SQL database with folowing specifications
 * Schema : students
 * Tables : students
 * colums of table students: firstname VARCHAR(40), lastname VARCHAR(40), grade INT
 */


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
			// Since JDBC Connection 6 the class used for the driver is 'com.mysql.cj.jdbc.Driver'
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Since JDBC COnnection 6 it's mandatory to append the serverTimezone to the URL!
			String url = "jdbc:mysql://localhost/" + database + "?serverTimezone=UTC";
			
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
	
	public ArrayList<String> selectAll(String query) {
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
		
		return result;
	}
	
	public void executeInsert(String query) {
		
		try {
			Statement statement = conn.createStatement();
			
			// Insert statements should be executed with "executeUpdate()" and NOT with "executeQuery()"
			statement.executeUpdate(query);
			statement.close();
		}
		catch(Exception e ) {
			System.out.println(e);
		}
		
	}
	
	
}
