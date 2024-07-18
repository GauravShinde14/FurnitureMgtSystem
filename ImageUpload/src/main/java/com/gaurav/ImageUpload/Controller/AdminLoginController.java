package com.gaurav.ImageUpload.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.ImageUpload.model.AdminLogin;
import com.gaurav.ImageUpload.services.AdminLoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminLoginController {

	@Autowired
	AdminLoginService as;
	
	
	@GetMapping("/adminLogin/{email}/{password}")
	public AdminLogin getAdmin(@PathVariable("email")String email,@PathVariable("password")String password) {
		
		return as.findbyemailandpassword(email, password);
	}
}
