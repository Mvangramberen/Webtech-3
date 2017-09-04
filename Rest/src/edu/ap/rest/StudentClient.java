package edu.ap.rest;

import org.json.JSONObject;
import org.restlet.resource.ClientResource;

/*
 * Step 3: The client is used to fill up the data needed for the resource. 
 * Nothing is linked to the client because this is just an init to provide test data
 * the the poject
 * 
 * Need to make ClientResource ( to fake the client adding data ) 
 * add the data in a JSON format
 */

public class StudentClient {

    // http://hc.apache.org/
     public static void main(String[] args) {
           
             try {
            	 // The client resource should point to the StudentResource.java file ( use routing provided by
            	 // StudentApplication and StudentServer
            	ClientResource resource = new ClientResource("http://127.0.0.1:8080/students/table");
            	
            	JSONObject json = new JSONObject();
            	json.put("name", "Micky");
            	json.put("lastname", "The allmighty");
            	json.put("grade", 20);
            	
            	resource.post(json);
            	
            	/* In case you need to retrieve the JSON files
            	 * Get everything by using resource.get(String.class)
            	 * !!!!!! This is a single json file containing an array of multiple jsons
            	 */
            	
            }
            catch (Exception e) {
               System.out.println(e.getStackTrace());
            }
        }
    }
