package BLL;

import java.util.ArrayList;

import jdbc.JdbcConnection;

public class DataAccess {

	/*
	 * The creation of a dataAccess class acts like a proxy. It manages the access to and from the 
	 * Database using the JdbcConnection. This also makes it much easier to create a Single point of
	 * Access for the webservice.  
	 */
	
	private JdbcConnection connection = JdbcConnection.getJdbcConnection();
	private ArrayList<String> result = new ArrayList<String>();
	private String select ="SELECT firstname, lastname, grade FROM students";
		public DataAccess() {}
	private int arrayLength;
	private String[] aResult;
	
	public String[] getAllStudents(){
		try{connection.openConnection("students", "root", "root");
		result = connection.selectAll(select);
		arrayLength = result.size();
		}
		catch(Exception e) {
			System.out.println(e);
			arrayLength = 0;
		}
		
		/*
		 * Due to a bug in the JAX-B service within SOAP, you aren't able to return complex collections
		 * such as ArrayLists. To fix this issue, there are several sollutions for example
		 * return an array or wrap it into a POJO.
		 */
		aResult = new String[arrayLength];
		for (int i = 0; i<result.size() ;i++) {
			aResult[i] = result.get(i).toString();
		}
		
			return aResult;
	}
	
}
