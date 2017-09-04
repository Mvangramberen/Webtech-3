package edu.ap.rest;

import org.restlet.resource.ClientResource;

public class ZiekenhuisClient {

	public static void main(String[] args) {
        
        try {
       	ClientResource resource = new ClientResource("http://localhost:8080/ziekenhuis/patienten");
       	// Post a new race
       	String patient1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	patient1 += "<patient id=\"3\" datehour=\"25/01/2017 - 13:00\" namePatient=\"Jeremy Keusters\" dobPatient=\"19/04/1997\" nameNurse=\"Olga Coutrin\">";
       	patient1 += "<diagnose>Verkoudheidje</diagnose>";
       	patient1 += "</patient>";
   		resource.post(patient1);
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       	
       	String patient2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	patient2 += "<patient id=\"4\" datehour=\"25/01/2017 - 15:00\" namePatient=\"Philippe Possemiers\" dobPatient=\"19/04/1997\" nameNurse=\"Ingeborg Van Osselaer\">";
       	patient2 += "<diagnose>Griep</diagnose>";
       	patient2 += "</patient>";
   		resource.post(patient2);
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       }
       catch (Exception e) {
           System.out.println("In main : " + e.getMessage());
       }

	}

}
