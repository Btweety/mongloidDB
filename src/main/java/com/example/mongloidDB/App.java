package com.example.mongloidDB;

import java.util.Iterator;

public class App {
	
	public static void main( String[] args ){
    	String username = "root";
    	char[] password = "root".toCharArray();
    	String db = "shiftsWorks";
    	
    	Mongo mongodb = new Mongo(username, password, db, "localhost", 27017, false);
    	Iterator<String> mongit = mongodb.getCollections().iterator();
    	
    	while(mongit.hasNext()) {
    		System.out.println(mongit.next());
    	}
    	
    	mongodb.close();
    }
}
