package edu.ap.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class QuotesApplication extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
   @Override
   public synchronized Restlet createInboundRoot() {

       Router router = new Router(getContext());

       router.attach("/quotes", QuotesResource.class);
       router.attach("/quotes/{search_term}", QuotesSearchResource.class);
       return router;
   }
}
