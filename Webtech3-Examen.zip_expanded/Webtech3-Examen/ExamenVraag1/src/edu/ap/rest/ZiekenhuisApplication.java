package edu.ap.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ZiekenhuisApplication extends Application {

	
	@Override
	public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of StudentResource.
	    Router router = new Router(getContext());
	    
	    // Defines only one route
	    router.attach("/patienten", ZiekenhuisResource.class);
	    
	    return router;
	}
	
}
