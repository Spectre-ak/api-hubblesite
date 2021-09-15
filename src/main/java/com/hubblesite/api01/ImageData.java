package com.hubblesite.api01;

import java.util.Scanner;

import org.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageData {

	@GetMapping("/")
	public Object index(){
		return "/index";
	}

}
