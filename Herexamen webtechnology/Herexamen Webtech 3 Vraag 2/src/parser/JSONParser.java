package parser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import json.JSONArray;
import json.JSONObject;
import sun.nio.ch.IOUtil;

public class JSONParser {

	/**
	 * Get all quotes from the txt file and return them in html format
	 */
	public String getProducten() {

		String result = "";
		
		try {	
			
			String filename="C:\\Users\\Micky\\Documents\\GitHub\\Webtech-3\\Herexamen webtechnology\\Herexamen Webtech 3 Vraag 2\\producten.json";
			String content = new String(Files.readAllBytes(Paths.get(filename)));
			JSONObject json = new JSONObject(content);
			JSONArray jsonArray = json.getJSONArray("result");
			
			
			for(int i = 0 ; i < jsonArray.length(); i++) {
				JSONObject temp = jsonArray.getJSONObject(i);
				result +="<p>Product : " + temp.getString("product") + "</p>";
				result +="<p>Producent: " + temp.getString("producent") + "</p>";
				result +="<p>Prijs : "+ temp.getString("prijs")	+ "</p><p></p>";
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}
	
	/**
	 * Get all quotes from the txt file and return them in html format
	 */
	public String getSearchProduct(String search_product) {

		String result = "";
		
		try {	
			
			String filename="C:\\Users\\Micky\\Documents\\GitHub\\Webtech-3\\Herexamen webtechnology\\Herexamen Webtech 3 Vraag 2\\producten.json";
			String content = new String(Files.readAllBytes(Paths.get(filename)));
			JSONObject json = new JSONObject(content);
			JSONArray jsonArray = json.getJSONArray("result");
			
			
			for(int i = 0 ; i < jsonArray.length(); i++) {
			
				JSONObject temp = jsonArray.getJSONObject(i);
				System.out.println("Zoekterm'"+search_product+"' te machten term '"+temp.getString("product")+"'");
				if(search_product.equals(temp.get("product"))) {
					result +="<p>Product : " + temp.getString("product") + "</p>";
					result +="<p>Producent: " + temp.getString("producent") + "</p>";
					result +="<p>Prijs : "+ temp.getString("prijs")	+ "</p><p></p>";
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
