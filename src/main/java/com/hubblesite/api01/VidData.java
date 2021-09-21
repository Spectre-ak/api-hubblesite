package com.hubblesite.api01;

import java.util.Scanner;

import org.json.JSONArray;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class VidData {
	
	private DBUtil dbUtil;
	private JSONArray resc;
	public VidData() {
		this.dbUtil=new DBUtil();
		this.resc=this.dbUtil.getResc("video-rsc");
	}
	
	@RequestMapping(value = "/all/videos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String index(){
		return this.resc.toString();
	}
}
