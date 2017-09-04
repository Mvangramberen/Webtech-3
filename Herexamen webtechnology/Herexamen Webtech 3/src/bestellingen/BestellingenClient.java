package bestellingen;

import org.restlet.resource.ClientResource;

public class BestellingenClient {

	public static void main(String[] args) {
        
        try {
       	ClientResource resource = new ClientResource("http://localhost:8080/bol/bestellingen");
       	
       	// Post a new order
       	String order1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	order1 += "<bestelling nameCustomer=\"Gilles Vercammen\" adress=\"Boerengat 65\" orderDate=\"04/09/2017\" product=\"World of warcraft\" ammount=\"5\">\n";
       	order1 += "</bestelling>";
   		resource.post(order1);
   		
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       	
       	String order2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	order2 += "<bestelling nameCustomer=\"Gilles Vercammen\" adress=\"Boerengat 65\" orderDate=\"04/09/2017\" product=\"Desktop\" ammount=\"1\">\n";
       	order2 += "</bestelling>";
   		resource.post(order2);
   		
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       	
       }
       catch (Exception e) {
           System.out.println("In main : " + e.getMessage());
       }

	}

}
