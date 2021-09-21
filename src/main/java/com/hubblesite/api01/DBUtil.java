package com.hubblesite.api01;

import java.awt.List;
import java.util.ArrayList;

import org.bson.Document;
import org.json.JSONArray;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DBUtil {
	private String dburl = null;
	private MongoClient mongoClient = null;

	public DBUtil() {
//		try {
//			String keyVaultName = "keyVaultsForSecureCreds";
//			String keyVaultUri = "https://" + keyVaultName + ".vault.azure.net";
//
//			SecretClient secretClient = new SecretClientBuilder().vaultUrl(keyVaultUri)
//					.credential(new DefaultAzureCredentialBuilder().build()).buildClient();
//
//			KeyVaultSecret retrievedSecret = secretClient.getSecret("databaseCredentials");
//			this.dburl = retrievedSecret.getValue();
//			ConnectionString connectionString = new ConnectionString(dburl);
//			MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString)
//					.build();
//			MongoClient mongoClient = MongoClients.create(settings);
//			this.mongoClient = mongoClient;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

	}

	public JSONArray getImages() {
		ConnectionString connectionString = new ConnectionString(System.getenv("dburl"));
		MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();
		MongoClient mongoClient = MongoClients.create(settings);
		this.mongoClient = mongoClient;
		
		
		MongoDatabase database = mongoClient.getDatabase("hubblesite");
		MongoCollection<Document> collection = database.getCollection("image-resc");
		FindIterable<Document> fi = collection.find();
		MongoCursor<Document> cursor = fi.iterator();
		ArrayList<Object> list=new ArrayList<>();
		JSONArray jsonArray=new JSONArray();
		try {
			while (cursor.hasNext()) {
				Document document = cursor.next();
				//list.add(document.get("1"));
				jsonArray.put(document.get("1"));
			}
		} finally {
			cursor.close();
		}
		return jsonArray;
	}

}
