package bestellingen;

import org.restlet.*;
import org.restlet.data.Protocol;

public class Main {
	
	public static void main(String[] args) throws Exception {  
	    // Create a new Component.  
	    Component component = new Component();  

	    // Add a new HTTP server listening on port 8080.  
	    component.getServers().add(Protocol.HTTP, 8080);  

	    // Attach the sample application.  
	    component.getDefaultHost().attach("/bol",  new BestellingApplication());  

	    // Start the component.  
	    component.start();  
	}

}
