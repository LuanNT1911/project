package com.groupproject.adminweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupproject.adminweb.dto.Account;
import com.groupproject.adminweb.restclient.AccountRestClient;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		System.out.println("abc");
		return "login";
//		return "redirect:/approveGennerate3d";
	}

	@RequestMapping(value = "/authorize", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model, final RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("client_id", "qtCJ1QNYAyIirhymdbGVz6mxmfzOddf3");
		redirectAttributes.addAttribute("response_type", "code");
		redirectAttributes.addAttribute("scope", "data:read data:write");
		redirectAttributes.addAttribute("redirect_uri", "http://localhost.autodesk.com:8080/adminWeb/callback");
		String transactionUrl = "https://developer.api.autodesk.com/authentication/v1/authorize";
		return "redirect:" + transactionUrl;
	}
}
