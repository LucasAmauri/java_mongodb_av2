package _bd2_av2_mongodb;

import com.mongodb.Mongo;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.BasicDBObject;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class mongodb {
	private static Mongo mongo;
	private static DB db;
	private static  DBCollection collection;
	

	public static void main(String[] args) {
	
	bridge("LucasAmauri", 27017);
	Create("Járagua do sul", 123123.2, 23213.2);
	
	
		

	}

	
	private static void bridge(String host, int port) {
		try {
			System.out.println("Banco de dados foi inicializado.");
			mongo = new Mongo(host, port);
		}catch (UnknownHostException ex)
		{Logger.getLogger(mongodb.class.getName()).log(Level.SEVERE, null, ex);}
		                                        }
	private static void dbSwitch(String dbname) {
		if(mongo != null) {
			System.out.println("Troca o banco");
			db = mongo.getDB(dbname);
	 }
	}
	private static void switchCollection(String collectionName) {
		if(db != null) {
			collection = db.getCollection(collectionName);
		}
	}
	 

	public static void Create(String nomeLocal, double lat, double lng) {
		
		BasicDBObject document = new BasicDBObject();
		String Local = nomeLocal;
		double latitude = lat;
		double longitude = lng;
		document.put("Local =", Local);
		document.put("Latitude =", latitude);
		document.put("longitude =",  longitude);
		Insert(document);
		System.out.println("Dados foram inseridos");
		
		
	}

	public static void Insert(BasicDBObject document) {
		if(db != null) {
			if(document != null) {
				collection.insert(document);
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
}}
