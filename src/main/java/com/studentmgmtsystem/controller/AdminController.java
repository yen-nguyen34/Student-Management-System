package com.studentmgmtsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmgmtsystem.dao.AdminDao;
import com.studentmgmtsystem.model.Admin;
import com.studentmgmtsystem.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private AdminService adminService;

	// to get register form page
	@GetMapping("/register")
	public String createAdmin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "adminregister";

	}

	// checking for register credentials
	@PostMapping("/register")
	public String registerForm(@ModelAttribute("admin") Admin admin) {
		adminService.saveAdmin(admin);
		return "redirect:/students?success";
	}

	// to get login form page
	@GetMapping("/login")
	public String showLoginPage() {
		// return html page name
		return "adminlogin";
	}

	// checking for login credentials
	@PostMapping("/login")
	public String login(@ModelAttribute(name = "admin") Admin admin) {
		String email = admin.getEmail();
		String password = admin.getPassword();
		Admin ad = adminDao.findByEmailAndPassword(email, password);
		if (ad == null) {
			return "redirect:/login?error";
		} else {
			return "redirect:/students";
		}
	}

}
