package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.domain.Model;
import com.rest.repository.ModelRepository;

@Controller
@RequestMapping(path = "IFAR")
public class ModelController {
	@Autowired
	ModelRepository modelRepository;

	@GetMapping(path = "getAllModel")
	public @ResponseBody List<Model> getAllModel() {
		return modelRepository.getAll();
	}
}
