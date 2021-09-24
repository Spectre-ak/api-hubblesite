package com.hubblesite.api01;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ImageData {

	private DBUtil dbUtil;
	private JSONArray resc;
	public ImageData() {
		this.dbUtil=new DBUtil();
		this.resc=this.dbUtil.getResc("image-resc");
	}
	
	@RequestMapping(value = "/all/images", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String index(){
		return this.resc.toString();
	}
	
	@RequestMapping(value = "/images/tags/{tags}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getImagesBasedOnTags(@PathVariable String tags) {
		System.out.println(tags);
		
		for(Object obj:this.resc) {
			obj=(JSONObject) obj;
			System.out.println(obj);
			break;
		}
		
		return null;
	}

}
