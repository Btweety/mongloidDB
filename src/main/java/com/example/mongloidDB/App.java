package com.example.mongloidDB;

import java.util.Iterator;

import com.mongodb.client.MongoIterable;

public class App {
	
	public static void main( String[] args ){
    	String username = "root";
    	char[] password = "root".toCharArray();
    	String db = "shiftsWorks";
    	
    	Mongo mongodb = new Mongo(username, password, db, "localhost", 27017, false);
    	Iterator mongit = mongodb.getCollections().iterator();
    	
    	while(mongit.hasNext()) {
    		System.out.println((String) mongit.next());
    	}
    }
}
