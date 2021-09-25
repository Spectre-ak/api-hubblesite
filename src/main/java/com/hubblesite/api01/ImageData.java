package com.hubblesite.api01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
		tags=tags.toLowerCase();
		List<String> listTags=new ArrayList<>();
		listTags=Arrays.asList(tags.split("\\+"));
		
		System.out.println(listTags);
		
		JSONArray similarTagsResults=new JSONArray();
		
		for(int i=0;i<this.resc.length();i++) {
			JSONObject jsonObject=new JSONObject(this.resc.get(i).toString());
			JSONArray tagsPresent=jsonObject.getJSONArray("tags");
			for(Object obj:tagsPresent) {
				String tag=obj.toString().toLowerCase();
				for(String subTag:listTags) {
					if(subTag.contains(tag) || tag.contains(subTag)) {
						similarTagsResults.put(jsonObject);
					}
				}
			}
		}
		
		
		return similarTagsResults.toString();
	}

}
