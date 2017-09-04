package bestellingen;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import xml.XMLParser;

public class BestellingenResource extends ServerResource {

	
	@Get("html")	
	public String getPatients() {
		System.out.println("Get bestellingen");
		XMLParser parser = new XMLParser();
		return parser.getOrders();
	}
	
	@Post("txt")
	public String addOrder(String xml) {
		XMLParser parser = new XMLParser();
		return parser.addOrder(xml);
	}
}
