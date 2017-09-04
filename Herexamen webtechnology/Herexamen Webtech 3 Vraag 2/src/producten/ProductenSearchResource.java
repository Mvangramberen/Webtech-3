package producten;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import parser.JSONParser;

public class ProductenSearchResource extends ServerResource {
	
	@Get("html")
	public String getSearchProduct(String search_product) {
		search_product = getAttribute("search_product");
		System.out.println("in resource :" + search_product);
		JSONParser parser = new JSONParser();
		return parser.getSearchProduct(search_product);
	}
}
