package com.groupproject.adminweb.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.groupproject.adminweb.dto.ProductRespone;
import com.groupproject.adminweb.dto.UserAccountRespone;
import com.groupproject.adminweb.restclient.UserAccountRestClient.Mapping;
import com.groupproject.adminweb.restclient.UserAccountRestClient.UnixEpochDateTypeAdapter;

public class ProductRestClient implements Serializable {
	public static List<ProductRespone> getAllProduct() throws IOException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		final String uri = "http://127.0.0.1:8090/IFAR/getAllProduct";
		StringBuffer response = new StringBuffer();
		String result = null;
			URL obj = new URL(uri);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header

			// con.setRequestProperty("format", "obj");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + uri);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			Gson gson = new Gson();
			Type type = new TypeToken<List<ProductRespone>>(){}.getType();
			List<ProductRespone> productList = gson.fromJson(response.toString(), type);
			System.out.println(productList.size());
			
		

		//final Gson gson = new GsonBuilder()
			//	.registerTypeAdapter(Date.class, UnixEpochDateTypeAdapter.getUnixEpochDateTypeAdapter()).create();
		/*
		 * if (!(obj.get("username").isJsonNull())) { userAccountRespone = new
		 * UserAccountRespone();
		 * userAccountRespone.setUsername(obj.get("username").toString().
		 * replaceAll("\"", ""));
		 * userAccountRespone.setAddress(obj.get("address").toString().
		 * replaceAll("\"", "")); String birth = "{\"date\":" +
		 * obj.get("birth").toString() + "}"; Mapping mapping =
		 * gson.fromJson(birth, Mapping.class);
		 * userAccountRespone.setBirth(mapping.date);
		 * userAccountRespone.setCity(obj.get("city").toString().replaceAll(
		 * "\"", "")); String createAt="{\"date\":" +
		 * obj.get("createdAt").toString() + "}"; mapping =
		 * gson.fromJson(createAt, Mapping.class);
		 * userAccountRespone.setCreatedAt(mapping.date);
		 * userAccountRespone.setEmail(obj.get("email").toString().replaceAll(
		 * "\"", ""));
		 * userAccountRespone.setFullname(obj.get("fullname").toString().
		 * replaceAll("\"", ""));
		 * userAccountRespone.setPhone(obj.get("phone").toString().replaceAll(
		 * "\"", ""));
		 * userAccountRespone.setRoleId(obj.get("roleId").getAsInt());
		 * userAccountRespone.setRoleName(obj.get("roleName").toString().
		 * replaceAll("\"", ""));
		 * userAccountRespone.setSexual(obj.get("sexual").getAsInt()); String
		 * updateAt="{\"date\":" + obj.get("updatedAt").toString() + "}";
		 * mapping = gson.fromJson(updateAt, Mapping.class);
		 * userAccountRespone.setUpdatedAt(mapping.date); }
		 */
		return productList;

	}
}
