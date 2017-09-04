package producten;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import parser.JSONParser;

public class ProductenResource extends ServerResource {

	@Get("html")
	public String getProducten() {
		JSONParser parser = new JSONParser();
		return parser.getProducten();
	}
	
}
