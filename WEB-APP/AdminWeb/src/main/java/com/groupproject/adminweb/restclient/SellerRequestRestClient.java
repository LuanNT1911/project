package com.groupproject.adminweb.restclient;



import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SellerRequestRestClient {
	public String getLinkFolderImage(String requestId){
		
		String serverHost = "http://127.0.0.1:8090";
		String getApprovePath = serverHost + "/IFAR/getSellerRequest?status=1";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(getApprovePath, String.class);
		return null;
	}

}
