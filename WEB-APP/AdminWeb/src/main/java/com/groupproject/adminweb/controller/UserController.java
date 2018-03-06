package com.groupproject.adminweb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.groupproject.adminweb.dto.ProductRespone;
import com.groupproject.adminweb.dto.UserAccountRespone;
import com.groupproject.adminweb.restclient.Generate3DModelRestClient;
import com.groupproject.adminweb.restclient.ProductRestClient;
import com.groupproject.adminweb.dto.UserAccountRespone;
import com.groupproject.adminweb.restclient.UserAccountRestClient;

@Controller
public class UserController {

	@RequestMapping(value = "/createPhotosceneId", method = RequestMethod.GET)
	public String showUserList(HttpServletRequest request, @RequestParam("token") String token,@RequestParam("photosceneName") String photosceneName, @RequestParam String requestId,Model model,final RedirectAttributes redirectAttributes) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", token);

		final String uri = "https://developer.api.autodesk.com/photo-to-3d/v1/photoscene";

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		params.add("scenename", photosceneName);
		params.add("format", "obj");
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params,
				headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> result = restTemplate.postForEntity(uri, requestEntity, String.class);

		JsonObject obj = (JsonObject) new JsonParser().parse(result.getBody().toString());

		String photoid = obj.get("Photoscene").toString();
		String photosceneid = photoid.replaceAll("\"", "");
		String id = photosceneid.substring(photosceneid.lastIndexOf(":") + 1, photosceneid.length() - 1);
		redirectAttributes.addAttribute("photosceneId", id);
		redirectAttributes.addAttribute("token", token);
		redirectAttributes.addAttribute("requestId", requestId);
		request.setAttribute("photosceneName", photosceneName);
		request.setAttribute("token", token);
		request.setAttribute("photosceneId", id);
		request.setAttribute("requestId", requestId);
		return "redirect:/uploadImage";
	}

	@RequestMapping(value = "checkLogin", method = RequestMethod.POST)
	public String checkLogin(HttpServletRequest request, @RequestParam("txtUsername") String username,
			@RequestParam("txtPassword") String password) {
		HttpSession session = request.getSession();
		String resultPage = "LoginFail";
		UserAccountRestClient userRest = new UserAccountRestClient();
		UserAccountRespone userAccount = userRest.checkLogin(username, password);
		if(!(userAccount==null)){
			
			session.setAttribute("USERACCOUNT", userAccount);
			resultPage="redirect:/authorize";
		}
		try {
			request.setAttribute("PRODUCTLIST", ProductRestClient.getAllProduct());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return resultPage;
	}

	@RequestMapping(value = "/uploadImage", method = RequestMethod.GET)
	public String viewProfile(HttpServletRequest request, @RequestParam("photosceneId") String photosceneId,
			@RequestParam("token") String token,@RequestParam String requestId, final RedirectAttributes redirectAttributes) {
		String serverHost = "http://127.0.0.1:8090";

		String getApprovePath = serverHost + "/IFAR/getImages?id="+requestId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(getApprovePath, String.class);

		ObjectMapper mapper = new ObjectMapper();
		System.out.println("respne body : "+response.getBody());
		JSONArray listJson = new JSONArray(response.getBody());
		
		for(int i=0;i<listJson.length();i++){
			System.out.println(listJson.get(i).toString());
			Generate3DModelRestClient.updateImage(photosceneId, token, listJson.get(i).toString(), "file["+i+"]");
		}

		
		redirectAttributes.addAttribute("photosceneId", photosceneId);
		redirectAttributes.addAttribute("token", token);
		redirectAttributes.addAttribute("requestId", requestId);
		request.setAttribute("photosceneId", photosceneId);
		request.setAttribute("token", token);
		return "redirect:/processImage";
	}

	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public String getToken(HttpServletRequest request, @RequestParam("code") String code,Model model,final RedirectAttributes redirectAttributes) {
		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Content-Type", "application/x-www-form-urlencoded");
		final String uri = "https://developer.api.autodesk.com/authentication/v1/gettoken";
		System.out.println("code   " + code);
		MultiValueMap<String, String> params = new LinkedMultiValueMap();
		params.add("Content-Type", "application/x-www-form-urlencoded");
		params.add("client_id", "qtCJ1QNYAyIirhymdbGVz6mxmfzOddf3");
		params.add("client_secret", "1SfnYSYY2IS44wI9");
		params.add("grant_type", "authorization_code");
		params.add("code", code);

		params.add("redirect_uri", "http://localhost.autodesk.com:8080/adminWeb/callback");

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params,
				headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity result = restTemplate.postForEntity(uri, requestEntity, String.class);

		JsonObject obj = (JsonObject) new JsonParser().parse(result.getBody().toString());
		String accesstoken = obj.get("access_token").toString().replaceAll("\"", "");
		System.out.println("json : " + obj.toString());
		System.out.println(accesstoken);
		String token = "Bearer " + accesstoken;
		System.out.println(token);

		request.setAttribute("token", token);
		redirectAttributes.addAttribute("token", token);
		System.out.println("token :" + token);
		return "redirect:/approveGennerate3d";
		// return "redirect:/refreshTo";
	}

	

	@RequestMapping(value="/processImage",method=RequestMethod.GET)
	public String viewChangePasswordForm(HttpServletRequest request, @RequestParam("photosceneId") String photosceneId,
			@RequestParam("token") String token,@RequestParam String requestId, Model model, final RedirectAttributes redirectAttribute) {

		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Accept", "application/json");
		headers.set("Authorization", token);
		System.out.println("token image : " + token);
		System.out.println("photoidImage : " + photosceneId);
		final String uri = "https://developer.api.autodesk.com/photo-to-3d/v1/photoscene/" + photosceneId;
		MultiValueMap<String, String> params = new LinkedMultiValueMap();
		params.add("photosceneid", photosceneId);

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params,
				headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity result = restTemplate.postForEntity(uri, requestEntity, String.class);

		JsonObject obj = (JsonObject) new JsonParser().parse(result.getBody().toString());

		System.out.println("json : " + obj.toString());

		redirectAttribute.addAttribute("photosceneId", photosceneId);
		redirectAttribute.addAttribute("token", token);
		redirectAttribute.addAttribute("requestId", requestId);
		request.setAttribute("photosceneId", photosceneId);
		request.setAttribute("token", token);
		request.getSession().setAttribute("photosceneId", photosceneId);
		request.getSession().setAttribute("token", token);

		return "redirect:/getLink";
	}

	@RequestMapping(value = "/checkProcess", method = RequestMethod.GET)
	public String viewAddNewForm(HttpServletRequest request, @RequestParam("photosceneId") String photosceneId,
			@RequestParam("token") String token, Model model, final RedirectAttributes redirectAttributes) {

		String url = "https://developer.api.autodesk.com/photo-to-3d/v1/photoscene/" + photosceneId + "/progress";
		try {
			int oldProcess;
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			System.out.println("old process" + request.getParameter("oldProcess"));
			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			con.setRequestProperty("Authorization", token);
			con.setRequestProperty("Content-Type", "application/json");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println("asdada");
			System.out.println(response.toString());

			JsonObject jObj = (JsonObject) new JsonParser().parse(response.toString());
			String progress = jObj.get("Photoscene").toString().replaceAll("\"", "");
			JsonObject processObj = (JsonObject) new JsonParser().parse(progress);
			int progressReturn = Integer.parseInt(processObj.get("progress").toString().replaceAll("\"", ""));
			System.out.println("abc     " + progressReturn);
			if (request.getParameter("oldProcess").isEmpty() || request.getParameter("oldProcess") == null) {
				oldProcess = 0;
			} else {
				oldProcess = Integer.parseInt(request.getParameter("oldProcess"));
			}
			request.setAttribute("oldProcess", oldProcess);
			request.setAttribute("Process", progressReturn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "createScene";

	}

	@RequestMapping(value = "/getLink", method = RequestMethod.GET)
	public String getLinkModel(HttpServletRequest request, @RequestParam("photosceneId") String photosceneId,
			@RequestParam("token") String token,@RequestParam String requestId, Model model, final RedirectAttributes redirectAttributes) {
		String link = null;

		while (link == null) {
			link = getLink(token, photosceneId);
		}
		request.setAttribute(requestId, link);
		System.out.println("link ne:" + link);
		HttpSession session = request.getSession();
		redirectAttributes.addAttribute("link", link);
		redirectAttributes.addAttribute("requestid", 1);
		redirectAttributes.addAttribute("token", session.getAttribute("token"));
		return "redirect:/approveGennerate3dtodown";

	}
	
	@RequestMapping(value = "/getLinkTest", method = RequestMethod.GET)
	public String getLinkModela(HttpServletRequest request, Model model, final RedirectAttributes redirectAttributes) {
		String link = "awdwad";

		HttpSession session = request.getSession();
		redirectAttributes.addAttribute("link", link);
		redirectAttributes.addAttribute("requestid", 1);
		redirectAttributes.addAttribute("token", session.getAttribute("token"));
		
		System.out.println("link ne:" + link);
		return "redirect:/approveGennerate3dtodown";

	}

	public String getLink(String token, String photosceneId) {
		String url = "https://developer.api.autodesk.com/photo-to-3d/v1/photoscene/" + photosceneId + "?format=obj";
		StringBuffer response = new StringBuffer();
		String result = null;
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			con.setRequestProperty("Authorization", token);
			con.setRequestProperty("Content-Type", "application/json");
			// con.setRequestProperty("format", "obj");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println("asdada");
			System.out.println(response.toString());
			JsonObject jObj = (JsonObject) new JsonParser().parse(response.toString());
			if (!jObj.toString().contains("Data is not ready")) {
				// if(jObj.get("Photoscene").toString()!=null){
				String jsonLink = jObj.get("Photoscene").toString();
				JsonObject linkObj = (JsonObject) new JsonParser().parse(jsonLink);
				System.out.println("linkobj" + linkObj.toString());
				result = linkObj.get("scenelink").toString().replaceAll("\"", "");
				System.out.println("result" + result);
				return result;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
