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
		/*
		ArrayList<String> listImage =  new ArrayList<>();
		for(int i=0;i<listJson.length();i++){
			System.out.println(listJson.get(i).toString());
		}
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3809.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3810.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3811.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3812.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3813.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3814.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3815.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3816.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3817.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3818.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3819.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3820.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3821.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3822.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3823.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3824.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3825.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3826.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3827.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3828.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3829.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3830.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3831.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3832.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3833.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3834.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3835.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3836.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3837.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3838.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3839.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3840.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3841.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3842.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3843.JPG");
		listImage.add("https://s3.amazonaws.com/3dimagetest/binhco/IMG_3844.JPG");*/
		for(int i=0;i<listJson.length();i++){
			System.out.println(listJson.get(i).toString());
			Generate3DModelRestClient.updateImage(photosceneId, token, listJson.get(i).toString(), "file["+i+"]");
		}

		
		/*
		 * String[] file = {
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3809.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3810.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3811.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3812.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3813.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3814.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3815.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3816.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3817.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3818.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3819.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3820.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3821.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3822.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3823.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3824.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3825.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3826.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3827.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3828.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3829.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3830.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3831.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3832.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3833.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3834.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3835.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3836.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3837.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3838.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3839.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3840.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3841.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3842.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3843.JPG",
		 * "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3844.JPG" };
		 * params.add("file[0]", file[0]); params.add("file[1]", file[1]);
		 * params.add("file[2]", file[2]); params.add("file[3]", file[3]);
		 * params.add("file[4]", file[4]); params.add("file[5]", file[5]);
		 * params.add("file[6]", file[6]); params.add("file[7]", file[7]);
		 * params.add("file[8]", file[8]); params.add("file[9]", file[9]);
		 * params.add("file[10]", file[10]); params.add("file[11]", file[11]);
		 * params.add("file[12]", file[12]); params.add("file[13]", file[13]);
		 * params.add("file[14]", file[14]); params.add("file[15]", file[15]);
		 * params.add("file[16]", file[16]); params.add("file[17]", file[17]);
		 * params.add("file[18]", file[18]); params.add("file[19]", file[19]);
		 * params.add("file[20]", file[20]); params.add("file[21]", file[21]);
		 * params.add("file[22]", file[22]); params.add("file[23]", file[23]);
		 * params.add("file[24]", file[24]); params.add("file[25]", file[25]);
		 * params.add("file[26]", file[26]); params.add("file[27]", file[27]);
		 * params.add("file[28]", file[28]); params.add("file[29]", file[29]);
		 * params.add("file[30]", file[30]); params.add("file[31]", file[31]);
		 * params.add("file[32]", file[32]); params.add("file[33]", file[33]);
		 * params.add("file[34]", file[34]); params.add("file[35]", file[35]);
		 */


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
