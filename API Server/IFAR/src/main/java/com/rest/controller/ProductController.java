package com.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.rest.domain.ImageTest;
import com.rest.domain.Product;
import com.rest.domain.ProductAndModelRespone;
import com.rest.domain.ProductRespone;
import com.rest.repository.ProductRepository;

@Controller
@RequestMapping(path = "IFAR")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping(path = "getAllProduct")
	public @ResponseBody Iterable<ProductRespone> getAllProduct() {
		List<Product> listProduct = productRepository.getAll();
		List<ProductRespone> result = null;
		if (!listProduct.isEmpty()) {
			result = new ArrayList<>();
			for (int i = 0; i < listProduct.size(); i++) {
				ProductRespone productRespone = new ProductRespone();
				productRespone.setId(listProduct.get(i).getId());
				productRespone.setName(listProduct.get(i).getName());
				productRespone.setPrice(listProduct.get(i).getPrice());
				productRespone.setQuantity(listProduct.get(i).getQuantity());
				productRespone.setOrigin(listProduct.get(i).getOrigin());
				productRespone.setWeight(listProduct.get(i).getWeight());
				if (!(listProduct.get(i).getDescribe() == null)) {
					productRespone.setDescribe(listProduct.get(i).getDescribe());
				}
				productRespone.setImage(listProduct.get(i).getImage());
				productRespone.setStatus(listProduct.get(i).getStatus());
				productRespone.setCreateAt(listProduct.get(i).getCreatedAt());
				productRespone.setUpdateAt(listProduct.get(i).getUpdatedAt());
				productRespone.setModelId(listProduct.get(i).getModel().getId());
				if (!(listProduct.get(i).getProduct() == null)) {
					productRespone.setProductId(listProduct.get(i).getProduct().getId());
				}
				if (!(listProduct.get(i).getRejectReason() == null)) {
					productRespone.setRejectReason(listProduct.get(i).getRejectReason());
				}
				result.add(productRespone);
			}
		}
		return result;
	}

	@GetMapping(path = "getAllProductAndModel")
	public ResponseEntity<List<ProductAndModelRespone>> getAllProductAndModel() throws JSONException, JsonProcessingException {
		List<Product> listProduct = productRepository.getAll();
		List<ProductAndModelRespone> result = null;
		if (!listProduct.isEmpty()) {
			result = new ArrayList<>();
			for (int i = 0; i < listProduct.size(); i++) {

				ProductAndModelRespone productAndModelRespone = new ProductAndModelRespone();
				productAndModelRespone.setHeight(listProduct.get(i).getModel().getHeight());
				productAndModelRespone.setImage(listProduct.get(i).getImage());
				productAndModelRespone.setLength(listProduct.get(i).getModel().getLength());
				productAndModelRespone.setLink(listProduct.get(i).getModel().getLink());
				productAndModelRespone.setModelId(listProduct.get(i).getModel().getId());
				productAndModelRespone.setName(listProduct.get(i).getName());
				productAndModelRespone.setPrice(listProduct.get(i).getPrice());
				productAndModelRespone.setWidth(listProduct.get(i).getModel().getWidth());
				result.add(productAndModelRespone);


				//ObjectMapper mapper = new ObjectMapper();
				//Object to JSON in file
				//String json1 = mapper.writeValueAsString(productAndModelRespone);
			}
		}
		return new ResponseEntity<List<ProductAndModelRespone>>(result, HttpStatus.OK);
	}

	@GetMapping(path = "getAllProductAndModelv2")
	public ResponseEntity getAllProductAndModelv2() throws JSONException, JsonProcessingException {
		List<Product> listProduct = productRepository.getAll();
		List<ProductAndModelRespone> result = null;
		JsonArray aaData = null;

		JSONObject json = new JSONObject();
		JSONObject json2 = new JSONObject();
		if (!listProduct.isEmpty()) {
			result = new ArrayList<>();
			for (int i = 0; i < listProduct.size(); i++) {

				ProductAndModelRespone productAndModelRespone = new ProductAndModelRespone();
				productAndModelRespone.setHeight(listProduct.get(i).getModel().getHeight());
				productAndModelRespone.setImage(listProduct.get(i).getImage());
				productAndModelRespone.setLength(listProduct.get(i).getModel().getLength());
				productAndModelRespone.setLink(listProduct.get(i).getModel().getLink());
				productAndModelRespone.setModelId(listProduct.get(i).getModel().getId());
				productAndModelRespone.setName(listProduct.get(i).getName());
				productAndModelRespone.setPrice(listProduct.get(i).getPrice());
				productAndModelRespone.setWidth(listProduct.get(i).getModel().getWidth());
				result.add(productAndModelRespone);


				ObjectMapper mapper = new ObjectMapper();
				//Object to JSON in file
				String json1 = mapper.writeValueAsString(productAndModelRespone);
				System.out.println(json1);

/*
				Gson gson = new Gson();
				 request = gson.toJson(productAndModelRespone);
				 json.putOpt("name", request);
				*/
			}
		}
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(result, new TypeToken<ArrayList<ProductAndModelRespone>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		JSONObject mainObj = new JSONObject();
		System.out.println(jsonArray.toString());
		mainObj.put("employees", jsonArray);
		json.put("models", jsonArray);
		gson.toJson(mainObj);
		System.out.println(mainObj.toString().replaceAll("\\\\", ""));
		String resultJson=json.toString().replaceAll("\\\\", "");
		resultJson= resultJson.replace("\"[", "[");
		resultJson= resultJson.replace("]\"", "]");

		return new ResponseEntity (resultJson, HttpStatus.OK);
	}
}
