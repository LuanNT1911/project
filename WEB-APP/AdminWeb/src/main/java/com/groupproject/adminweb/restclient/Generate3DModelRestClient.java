package com.groupproject.adminweb.restclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Generate3DModelRestClient {
	public static void updateImage(String photosceneId,String token,String linkImage,String param){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", token);

		final String uri = "https://developer.api.autodesk.com/photo-to-3d/v1/file";
		MultiValueMap<String, String> params = new LinkedMultiValueMap();

		params.add("photosceneid", photosceneId);
		params.add("type", "image");
		params.add(param, linkImage);
		
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params,
				headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity result = restTemplate.postForEntity(uri, requestEntity, String.class);

		JsonObject obj = (JsonObject) new JsonParser().parse(result.getBody().toString());
		System.out.println(obj.toString());
	}
}
