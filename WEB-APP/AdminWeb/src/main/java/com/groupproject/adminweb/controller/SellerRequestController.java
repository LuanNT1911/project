package com.groupproject.adminweb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;


@Controller
public class SellerRequestController {

	// Gobal variable to keep track upload progess
		static JSONObject uploadData; 
		final static String UPLOAD_STATUS_KEY="upload_status";
		final static String UPLOAD_VALUE_KEY="upload_value";
		static{
			uploadData = new JSONObject();
			uploadData.put(UPLOAD_STATUS_KEY, "start");
			uploadData.put(UPLOAD_VALUE_KEY, "0");
		}
	
	
	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public String test() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		final String uri = "http://127.0.0.1:8090/IFAR/test";
		RestTemplate restTemplate = new RestTemplate();

		List<LinkedTreeMap<String, Object>> userMap = restTemplate.getForObject(uri, List.class);
		// JsonParser jsonParser = new JsonParser();
		// JsonObject res = jsonParser.parse(body).getAsJsonObject();
		if (userMap != null) {
			for (LinkedTreeMap<String, Object> map : userMap) {
				System.out.println("Request : id=" + map.get("id") + ", status=" + map.get("status") + ", publicLink="
						+ map.get("publicLink"));
				ArrayList<LinkedTreeMap> subtree = (ArrayList<LinkedTreeMap>) map.get("models");
				for (LinkedTreeMap map1 : subtree) {
					System.out.println("models : id=" + map1.get("id") + ", status=" + map1.get("status") + ", link="
							+ map1.get("link"));
				}
			}
		} else {
			System.out.println("No user exist----------");
		}
		return "login";
	}
	
	@RequestMapping(value="/approve", method=RequestMethod.GET)

	public String approve(HttpServletRequest request, Model model, @RequestParam String _id,@RequestParam String userRequest,@RequestParam String token,RedirectAttributes redirectAttribute) throws Exception{
		System.out.println("user: "+userRequest+"_"+_id);
		String url="redirect:/approveGennerate3d";
		String serverHost = "http://127.0.0.1:8090";

		String getModelLinkPath = serverHost + "/IFAR/approve?id=" + _id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(getModelLinkPath, String.class);
		String body = response.getBody().toString();
		System.out.println(body);
		if(body.trim().equals("success")){
			System.out.println("abc ");
			url = "redirect:/authorize";
		}
//		System.out.println(url);
		System.out.println("token: "+token);
		HttpSession session = request.getSession();
		session.setAttribute("USERREQUEST", userRequest+"_"+_id);
		redirectAttribute.addAttribute("photosceneName", userRequest+"_"+_id);
		redirectAttribute.addAttribute("token", token);
		//redirectAttribute.addAttribute("sellerRequest", userRequest);
		redirectAttribute.addAttribute("requestId", _id);
		
		
		return "redirect:/createPhotosceneId";
		//return "redirect:/getLinkTest";
	}
	
	@RequestMapping(value = "/approveGennerate3d", method = RequestMethod.GET)
	public String approveGennerate3d(HttpServletRequest request, Model model,@RequestParam(required=false) String token) throws Exception {

		String serverHost = "http://127.0.0.1:8090";

		String getApprovePath = serverHost + "/IFAR/getSellerRequest?status=1";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(getApprovePath, String.class);

		ObjectMapper mapper = new ObjectMapper();
		JSONArray listJson = new JSONArray(response.getBody());
		ArrayList<Map<String, Object>> listAppove = new ArrayList<>();
		for (int i = 0; i < listJson.length(); i++) {
			listAppove.add(mapper.readValue(listJson.get(i).toString(), Map.class));
		}

		String getPedingList = serverHost + "/IFAR/getSellerRequest?status=0";

		response = restTemplate.getForEntity(getPedingList, String.class);

		JSONArray listPedingJson = new JSONArray(response.getBody());
		ArrayList<Map<String, Object>> listPeding = new ArrayList<>();
		for (int i = 0; i < listPedingJson.length(); i++) {
			listPeding.add(mapper.readValue(listPedingJson.get(i).toString(), Map.class));
		}

		String getRejectList = serverHost + "/IFAR/getSellerRequest?status=-1";

		response = restTemplate.getForEntity(getRejectList, String.class);

		JSONArray listRejectJson = new JSONArray(response.getBody());
		ArrayList<Map<String, Object>> listReject = new ArrayList<>();
		for (int i = 0; i < listRejectJson.length(); i++) {
			listReject.add(mapper.readValue(listRejectJson.get(i).toString(), Map.class));
		}
		HttpSession session = request.getSession();
		session.setAttribute("token", token);
		
		model.addAttribute("approvedList", listAppove);
		model.addAttribute("pedingList", listPeding);
		model.addAttribute("rejectList", listReject);
model.addAttribute("token", token);
		
		model.addAttribute("link", request.getAttribute("link"));
		model.addAttribute("requestid", request.getAttribute("requestid"));
		
		
		System.out.println("link 1" + request.getAttribute("link"));
		System.out.println("requestid 1" + request.getAttribute("requestid"));

		return "approveGennerate3d";
	}

	
	@RequestMapping(value = "/approveGennerate3dtodown", method = RequestMethod.GET)
	public String approveGennerate3dtoDown(HttpServletRequest request, Model model,@RequestParam String token,@RequestParam String link,@RequestParam String requestid) throws Exception {

		String serverHost = "http://127.0.0.1:8090";

		String getApprovePath = serverHost + "/IFAR/getSellerRequest?status=1";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(getApprovePath, String.class);

		ObjectMapper mapper = new ObjectMapper();
		JSONArray listJson = new JSONArray(response.getBody());
		ArrayList<Map<String, Object>> listAppove = new ArrayList<>();
		for (int i = 0; i < listJson.length(); i++) {
			listAppove.add(mapper.readValue(listJson.get(i).toString(), Map.class));
		}

		String getPedingList = serverHost + "/IFAR/getSellerRequest?status=0";

		response = restTemplate.getForEntity(getPedingList, String.class);

		JSONArray listPedingJson = new JSONArray(response.getBody());
		ArrayList<Map<String, Object>> listPeding = new ArrayList<>();
		for (int i = 0; i < listPedingJson.length(); i++) {
			listPeding.add(mapper.readValue(listPedingJson.get(i).toString(), Map.class));
		}

		String getRejectList = serverHost + "/IFAR/getSellerRequest?status=0&rejectReason=no";

		response = restTemplate.getForEntity(getRejectList, String.class);

		JSONArray listRejectJson = new JSONArray(response.getBody());
		ArrayList<Map<String, Object>> listReject = new ArrayList<>();
		for (int i = 0; i < listRejectJson.length(); i++) {
			listReject.add(mapper.readValue(listRejectJson.get(i).toString(), Map.class));
		}
		HttpSession session = request.getSession();
		session.setAttribute("token", token);
		
		model.addAttribute("approvedList", listAppove);
		model.addAttribute("pedingList", listPeding);
		model.addAttribute("rejectList", listReject);

		model.addAttribute("token", token);
		model.addAttribute("link", link);
		model.addAttribute("requestid", requestid);
		
		
		System.out.println("link 1" + link);
		System.out.println("requestid 1" + requestid);

		return "approveGennerate3d";
	}
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public @ResponseBody String download(HttpServletRequest request, Model model, @RequestParam String _id)
			throws Exception {

		String serverHost = "http://localhost:8090";
		String getModelLinkPath = serverHost + "/IFAR/getModelLink?id=" + _id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(getModelLinkPath, String.class);

		return response.getBody();
	}

	@RequestMapping(value = "/re-upload", method = RequestMethod.POST)
	public @ResponseBody String reUpload(@RequestParam("file") MultipartFile[] file, HttpServletRequest request,
			HttpServletResponse httpresponse, String _id, RedirectAttributes attributes) throws Exception {
//System.out.println("abc: "+file.length);
		// build URI
		String serverHost = "http://localhost:8090";
		String uploadFilePath = serverHost + "/IFAR/re-upload?_id=" + _id;

		MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
		// tranform file to system file
		try{
		for (int i = 0; i < file.length; i++) {

			String drawfile = file[i].getOriginalFilename();
			File sysFile = new File(drawfile);
			file[i].transferTo(sysFile);
			Resource resourceFile = new FileSystemResource(sysFile);
			bodyMap.add("file", resourceFile);
		}


		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String,Object>>(bodyMap, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uploadFilePath, HttpMethod.POST, requestEntity,
				String.class);

		
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		HttpSession session = request.getSession();
		attributes.addAttribute("token", session.getAttribute("token"));
	
		return "";
	}

	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	public @ResponseBody String reject(HttpServletRequest request, Model model, @RequestParam(value="_id") String _id, @RequestParam(value = "reason") String reason)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params = new LinkedMultiValueMap();
		params.add("id", _id);
		params.add("reason", reason);

		HttpEntity<MultiValueMap<String, String>> requestAPI = new HttpEntity<MultiValueMap<String, String>>(params,
				headers);
		String serverHost = "http://localhost:8090";
//		String RejectPath = serverHost + "/IFAR/reject?id=" + _id+"&?reason=abc";
		String RejectPath = serverHost + "/IFAR/reject";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity result = restTemplate.postForEntity(RejectPath, requestAPI, String.class);
		final String body = result.getBody().toString();
//		ResponseEntity<String> response = restTemplate.getForEntity(RejectPath, String.class);
		System.out.println(reason);
		return body;
	}
	
	
	@RequestMapping(value = "/getUpdateData", method = RequestMethod.GET)
	public @ResponseBody String getUploadprogressData(HttpServletRequest request)
			throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params = new LinkedMultiValueMap();
		String serverHost = "http://127.0.0.1:8090";
		String getDataLink = serverHost + "/IFAR/getUpdateData";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<MultiValueMap<String, String>> requestAPI = new HttpEntity<MultiValueMap<String, String>>(params,
				headers);
		ResponseEntity result = restTemplate.getForEntity(getDataLink, String.class);
		String response=result.getBody().toString();
		uploadData = new JSONObject(response);
		System.out.println(uploadData);
		return uploadData.toString();
	}
	
	
	
}