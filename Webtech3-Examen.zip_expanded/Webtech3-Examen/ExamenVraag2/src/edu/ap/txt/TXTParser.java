package edu.ap.txt;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class TXTParser {

	/**
	 * Get all quotes from the txt file and return them in html format
	 */
	public String getQuotes() {

		String result = "";
		
		try {	
			Scanner scanner = new Scanner(new File("C:\\Users\\Micky\\Documents\\GitHub\\Webtech-3\\Webtech3-Examen.zip_expanded\\Webtech3-Examen\\ExamenVraag2\\oscar_wilde.txt")).useDelimiter("(\\n)|;");		
			while(scanner.hasNext()) {
				result += scanner.next() + "<br>";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}
	
	/**
	 * Get all quotes from the txt file and return them in html format
	 */
	public String getSearchQuotes(String search_term) {

		String result = "";
		System.out.println(search_term);
		
		try {	
			Scanner scanner = new Scanner(new File("C:\\Users\\Micky\\Documents\\GitHub\\Webtech-3\\Webtech3-Examen.zip_expanded\\Webtech3-Examen\\ExamenVraag2\\oscar_wilde.txt")).useDelimiter(Pattern.compile("^\\s*$", Pattern.MULTILINE));		
			while(scanner.hasNext()) {
				final String quote = scanner.next();
				   if(quote.contains(search_term)) { 
				       result += quote + "<br><br>";
				   }
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}
}
