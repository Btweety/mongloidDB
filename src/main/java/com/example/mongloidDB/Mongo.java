package com.example.mongloidDB;

import java.util.Arrays;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Mongo {

	private String username, db, server;
	private char[] password;
	private int port;
	private MongoClient mongoclient;
	private boolean auth;
	private MongoDatabase database;
	
	
	/*
	 * Construtor, cria o cliente e acede à base de dados
	 * aceita com e sem autenticação
	 */
	public Mongo(String username, char[] password, String db, String server, int port, boolean auth) {
		this.username = username;
		this.password = password;
		this.db = db;
		this.server = server;
		this.port = port;
		this.auth = auth;
		try {
			if(!auth) {
				mongoclient = new MongoClient(server, port);
			}
			else {
				MongoCredential credential = MongoCredential.createCredential(username, db, password);
				mongoclient = new MongoClient(new ServerAddress(server, port), Arrays.asList(credential));
			}
			database = mongoclient.getDatabase(db);
	    	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Obtem um Iterable com todas as collections da base de dados
	 */
	public MongoIterable<String> getCollections(){
		return database.listCollectionNames();
	}
	
	public void addUser() {
		/*
		 * TODO
		 */
	}
	public void addSchedule() {
		/*
		 * TODO
		 */
	}
	public void addCompany() {
		/*
		 * TODO
		 */
	}
	
	
	public void close() {
		mongoclient.close();
	}
	
	
	
}
