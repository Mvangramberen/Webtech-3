package edu.ap.rest;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import edu.ap.jdbc.JDBConnection;

/*
 * Last step: StudentApplication made a link to StudentResource.
 * StudentClient is used to provide StudentResource of some dummy data.
 * 
 * In the resource we need to specify the GET and POST methods.
 */

public class StudentResource extends ServerResource {

	@Get
	public String allStudents() {
		
		// Create JDBC connection to connect to Database, Remember to use the getJDBConnection methode
		// to use the implemented Singleton
		JDBConnection conn = JDBConnection.getJDBConnection();
		
		// Open the connection 
		conn.openConnection("students", "root", "root");
	
		// Use selectAll method, defined in the JDBConnection class to retrieve all the records for the DB
		ArrayList<String> result = conn.selectAll();
		
		// Since everything is retrieved, we can close the connection to the DB
		conn.closeConnection();
		
		
		// Creating a JSON object, containing meta data and an JSONArray ( result of the selectAll )
		JSONObject json = new JSONObject();
		json.put("Operation", "selectAll");
		json.put("length", result.size());
		
		JSONArray array = new JSONArray();
		
		
		int index = 0;
		
		for(String row : result) {
			
			JSONObject temp = new JSONObject();
			temp.put("" + index, row);
			
			array.put(temp);
			index++;
		}
		
		json.put("result", array);
		
		return json.toString();
	}


	@Post("txt")
	public void newStudent(String json) {
		
		JSONObject newStudent = new JSONObject(json);
		String lastName = newStudent.getString("lastname");
		String firstName = newStudent.getString("firstname");
		int grade = newStudent.getInt("grade");
				
		JDBConnection c = JDBConnection.getJDBConnection();
		c.openConnection("students", "root", "root");
		c.executeInsert("students", firstName, lastName, grade);
		c.closeConnection();
	}	
	
}