package com.gaurav.ImageUpload.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gaurav.ImageUpload.model.AdminLogin;
import com.gaurav.ImageUpload.repository.AdminLoginRepo;

@Service
public class AdminLoginImp implements AdminLoginService {
	
	@Autowired
	@Qualifier("adminRepo")
	AdminLoginRepo adminRepo;

	@Override
	public AdminLogin findbyemailandpassword(String email, String password) {
		// TODO Auto-generated method stub
		return adminRepo.findByEmailAndPassword(email, password);
	}

}
