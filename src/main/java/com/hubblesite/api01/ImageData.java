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
	private JSONArray resc;
	public ImageData() {
		this.dbUtil=new DBUtil();
		this.resc=this.dbUtil.getImages();
	}
	@GetMapping("/all/images")
	public String index(){
		return this.resc.toString(3);
	}

}
