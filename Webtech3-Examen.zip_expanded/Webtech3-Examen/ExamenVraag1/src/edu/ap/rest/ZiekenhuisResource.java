package edu.ap.rest;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.ap.xml.XMLParser;

public class ZiekenhuisResource extends ServerResource {

	
	@Get("html")	
	public String getPatients() {
		System.out.println("GetPatients");
		XMLParser parser = new XMLParser();
		return parser.getPatients();
	}
	
	@Post("txt")
	public String addPatient(String xml) {
		XMLParser parser = new XMLParser();
		return parser.addPatient(xml);
	}
}
