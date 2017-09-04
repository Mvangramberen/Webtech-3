package edu.ap.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/*
 * Second step: first we created a server in the StudentServer.java,
 * in the StudentServer was a link made to StudentApplication(this).
 * Now we are using StudentApplication to provide routing to the StudentResource
 * 
 * To do so, we need to make a router. Which we later can use to define (multiple) 
 * routes. 
 */

public class StudentApplication extends Application {

	// Auto generated || Source -> Override/Implement methods -> CreateInboundRoot()
	@Override
	public synchronized Restlet createInboundRoot() {
		
		// Creating new router with getContext as parameter. Don't forget the "getContext()"
		Router router = new Router(getContext());
		
		// Routing to "/students" (came from StudentServer) "/table" (came from StudentApplication)
		// And connected StudentResource to this path
		router.attach("/table", StudentResource.class);
		
		
		return router;
	}



}