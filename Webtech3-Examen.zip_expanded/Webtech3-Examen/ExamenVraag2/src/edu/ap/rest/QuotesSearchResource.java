package edu.ap.rest;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.ap.txt.TXTParser;

public class QuotesSearchResource extends ServerResource {
	
	@Get("html")
	public String getSearchQuotes(String search_term) {
		search_term = getAttribute("search_term");
		TXTParser parser = new TXTParser();
		return parser.getSearchQuotes(search_term);
	}
}
