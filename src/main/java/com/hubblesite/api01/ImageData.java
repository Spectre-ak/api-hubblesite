package com.hubblesite.api01;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageData {

	private DBUtil dbUtil;
	private ArrayList<Object> resc;
	public ImageData() {
		this.dbUtil=new DBUtil();
		this.resc=this.dbUtil.getImages();
	}
	@GetMapping("/")
	public Object index(){
		return this.resc;
	}

}
