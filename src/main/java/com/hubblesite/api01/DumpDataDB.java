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
		//dumpVidResc(mongoClient);
	}
	
	static void dumpImgResc(MongoClient mongoClient) {
		try {
			
			MongoDatabase database = mongoClient.getDatabase("hubblesite");
			MongoCollection<Document> collection = database.getCollection("image-resc");
			
			String result=CharStreams.toString(new InputStreamReader(DumpDataDB.class.getClassLoader().getResourceAsStream("imgArray.json")));
			
			JSONArray dataArray=new JSONArray(result);
			int counter=0;
			for(Object object:dataArray) {
				counter++;
				synchronized (dataArray) {
					Document document=new Document("1",object.toString());
					collection.insertOne(document);
				}
				System.out.println(counter);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	static void dumpVidResc(MongoClient mongoClient) {
		try {
			
			MongoDatabase database = mongoClient.getDatabase("hubblesite");
			MongoCollection<Document> collection = database.getCollection("video-rsc");
			
			String result=CharStreams.toString(new InputStreamReader(DumpDataDB.class.getClassLoader().getResourceAsStream("vidArray.json")));
			
			JSONArray dataArray=new JSONArray(result);
			int counter=0;
			for(Object object:dataArray) {
				counter++;
				synchronized (dataArray) {
					Document document=new Document("1",object.toString());
					collection.insertOne(document);
				}
				System.out.println(counter);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
