package com.hubblesite.api01;

import java.util.Scanner;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageData {
	
	private JSONArray jsonArray;
	public ImageData() {
		Scanner scanner=new Scanner(this.getClass().getClassLoader().getResourceAsStream("imgArray.json"));
		String jsonAsString="";
		while(scanner.hasNextLine()) {
			jsonAsString+=scanner.nextLine();
		}
		this.jsonArray=new JSONArray(jsonAsString);
	}
	
	@GetMapping("/img/all")
	public Object AllImages() {
		return jsonArray.toString(3);
	}

}
