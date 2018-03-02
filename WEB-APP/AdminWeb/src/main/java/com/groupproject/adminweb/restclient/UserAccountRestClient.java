package com.groupproject.adminweb.restclient;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.groupproject.adminweb.dto.UserAccountRespone;

public class UserAccountRestClient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static UserAccountRespone checkLogin(String username, String password) {
		UserAccountRespone userAccountRespone = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		final String uri = "http://127.0.0.1:8090/IFAR/checkLogin";

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("username", username);
		params.add("password", password);

		HttpEntity<MultiValueMap<String, String>> requestAPI = new HttpEntity<MultiValueMap<String, String>>(params,
				headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> result = restTemplate.postForEntity(uri, requestAPI, String.class);
		final String body = result.getBody().toString(); // Or use
															// response.raw(),
															// if want raw
															// response string
		System.out.println(body);
		// JsonParser jsonParser = new JsonParser();
		// JsonObject res = jsonParser.parse(body).getAsJsonObject();

		JsonObject obj = (JsonObject) new JsonParser().parse(result.getBody().toString());
		final Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, UnixEpochDateTypeAdapter.getUnixEpochDateTypeAdapter())
				.create();

		if (!(obj.get("username").isJsonNull())) {
			userAccountRespone = new UserAccountRespone();
			userAccountRespone.setUsername(obj.get("username").toString().replaceAll("\"", ""));
			userAccountRespone.setAddress(obj.get("address").toString().replaceAll("\"", ""));
			String birth = "{\"date\":" + obj.get("birth").toString() + "}";
			Mapping mapping = gson.fromJson(birth, Mapping.class);
			userAccountRespone.setBirth(mapping.date);
			userAccountRespone.setCity(obj.get("city").toString().replaceAll("\"", ""));
			String createAt="{\"date\":" + obj.get("createdAt").toString() + "}";
			mapping = gson.fromJson(createAt, Mapping.class);
			userAccountRespone.setCreatedAt(mapping.date);
			userAccountRespone.setEmail(obj.get("email").toString().replaceAll("\"", ""));
			userAccountRespone.setFullname(obj.get("fullname").toString().replaceAll("\"", ""));
			userAccountRespone.setPhone(obj.get("phone").toString().replaceAll("\"", ""));
			userAccountRespone.setRoleId(obj.get("roleId").getAsInt());
			userAccountRespone.setRoleName(obj.get("roleName").toString().replaceAll("\"", ""));
			userAccountRespone.setSexual(obj.get("sexual").getAsInt());
			String updateAt="{\"date\":" + obj.get("updatedAt").toString() + "}";
			mapping = gson.fromJson(updateAt, Mapping.class);
			userAccountRespone.setUpdatedAt(mapping.date);
		}
		return userAccountRespone;
	}
	
	
	final class Mapping {
		final Date date = null;
	}

	final static class UnixEpochDateTypeAdapter extends TypeAdapter<Date> {

		private static final TypeAdapter<Date> unixEpochDateTypeAdapter = new UnixEpochDateTypeAdapter();

		private UnixEpochDateTypeAdapter() {
		}

		static TypeAdapter<Date> getUnixEpochDateTypeAdapter() {
			return unixEpochDateTypeAdapter;
		}

		@Override
		public Date read(final JsonReader in) throws IOException {
			// this is where the conversion is performed
			return new Date(in.nextLong());
		}

		@Override
		public void write(final JsonWriter out, final Date value) throws IOException {
			// write back if necessary or throw UnsupportedOperationException
			out.value(value.getTime());
		}

	}
	
	

}
