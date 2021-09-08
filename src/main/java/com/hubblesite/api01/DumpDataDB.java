package com.hubblesite.api01;

import java.util.Scanner;

import org.bson.Document;
import org.json.JSONArray;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DumpDataDB {

	public static void main(String[] args) throws Exception{
		Scanner scanner=new Scanner(DumpDataDB.class.getClassLoader().getResourceAsStream("imgArray.json"));
		JSONArray jsonArray=new JSONArray();
		ConnectionString connectionString = new ConnectionString(DBurl.dburl);
		MongoClientSettings settings = MongoClientSettings.builder()
		        .applyConnectionString(connectionString)
		        .build();
		MongoClient mongoClient = MongoClients.create(settings);
		
		
	}
	
	static void dumpImgResc(MongoClient mongoClient) {
		try {
			
			MongoDatabase database = mongoClient.getDatabase("hubblesite");
			MongoCollection<Document> collection = database.getCollection("image-resc");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
