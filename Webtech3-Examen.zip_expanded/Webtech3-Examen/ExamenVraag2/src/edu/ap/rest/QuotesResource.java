package edu.ap.rest;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.ap.txt.TXTParser;

public class QuotesResource extends ServerResource {

	@Get("html")
	public String getQuotes() {
		TXTParser parser = new TXTParser();
		return parser.getQuotes();
	}
	
}
