package com.hubblesite.api01;    

import java.io.InputStreamReader;
import java.util.Scanner;

import org.bson.Document;
import org.json.JSONArray;

import com.google.common.io.CharStreams;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DumpDataDB { 

	public static void main(String[] args) throws Exception{
		ConnectionString connectionString = new ConnectionString(System.getenv("dburl"));
		MongoClientSettings settings = MongoClientSettings.builder()
		        .applyConnectionString(connectionString)
		        .build();
		MongoClient mongoClient = MongoClients.create(settings);
		
		//dumpImgResc(mongoClient);   
		
		System.out.println();
	}
	
	static void dumpImgResc(MongoClient mongoClient) {
		try {
			
			MongoDatabase database = mongoClient.getDatabase("hubblesite");
			MongoCollection<Document> collection = database.getCollection("image-resc");
			
			String result=CharStreams.toString(new InputStreamReader(DumpDataDB.class.getClassLoader().getResourceAsStream("imgArray.json")));
			
			JSONArray dataArray=new JSONArray(result);
			
			for(Object object:dataArray) {
				synchronized (dataArray) {
					Document document=new Document();
					
				}
				break;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
