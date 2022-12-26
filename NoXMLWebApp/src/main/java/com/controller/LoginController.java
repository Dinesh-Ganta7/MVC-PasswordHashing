package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	JdbcTemplate template;

	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}

	@RequestMapping("/signin")
	public String signin() {
		return "signin";
	}

	@RequestMapping("/validate-login")
	public String validateLogin(HttpServletRequest req, Model model) throws Exception {

		String userName = req.getParameter("email");
		String password = req.getParameter("password");

		boolean isValid = loginService.validateLogin(userName, password);
		if (isValid) {
			model.addAttribute("email", userName);
			return "travel-book";
		} else {
			return "error";
		}

	}

	@RequestMapping("/create-user")
	public String createUser(HttpServletRequest req, Model model) throws Exception {
		String email = req.getParameter("email");
		String password = req.getParameter("confirm-password");
		String dob = req.getParameter("dob");
		System.out.println(
				String.format("Details Entered are email %s, Password is %s and dob is %s", email, password, dob));

		loginService.signupUser(email, password, dob);

		model.addAttribute("email", email);
		return "travel-book";

	}

}
