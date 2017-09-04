package edu.ap.rest;

import org.restlet.*;
import org.restlet.data.Protocol;

/*
 * First step: Create component to run server on designated port. 
 * define a default application to run on the default path. 
 * and finally run the component
 */

public class StudentServer {

	public static void main(String[] args) {
		
		try {
			// Create a new component
			Component component = new Component();
			
			// Defining server, which protocol to use and the port the servers listens to
			component.getServers().add(Protocol.HTTP, 8080);
			
			// Set the default page to "/students" and link the StudentApplication class to this URI
			component.getDefaultHost().attach("/students", new StudentApplication());
			
			//Run the component
			component.start();
		} 
	    catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
