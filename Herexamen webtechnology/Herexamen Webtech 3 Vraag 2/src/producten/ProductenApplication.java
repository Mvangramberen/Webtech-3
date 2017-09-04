package producten;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ProductenApplication extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
   @Override
   public synchronized Restlet createInboundRoot() {

       Router router = new Router(getContext());

       router.attach("/producten", ProductenResource.class);
       router.attach("/producten/{search_product}", ProductenSearchResource.class);
       return router;
   }
}
