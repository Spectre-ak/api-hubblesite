package com.hubblesite.api01;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRescAccess {

	@GetMapping("/t")
	public String t() throws URISyntaxException {
		
		Scanner scanner1=new Scanner(this.getClass().getClassLoader().getResourceAsStream("vidArray.json"));
		
		return scanner1.nextLine();
		
	}
}
