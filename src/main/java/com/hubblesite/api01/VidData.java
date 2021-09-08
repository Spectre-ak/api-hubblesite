package com.hubblesite.api01;

import java.util.Scanner;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;

public class VidData {
	
	private JSONArray jsonArray;
	
	public VidData() {
		// TODO Auto-generated constructor stub
		Scanner scanner=new Scanner(this.getClass().getClassLoader().getResourceAsStream("vidArray.json"));
		String jsonAsString="";
		while(scanner.hasNextLine()) {
			jsonAsString+=scanner.nextLine();
		}
		this.jsonArray=new JSONArray(jsonAsString);
	}
	
	@GetMapping("/vid/all")
	public Object getAllVids() {
		return this.jsonArray.toString(3);
	}
}
