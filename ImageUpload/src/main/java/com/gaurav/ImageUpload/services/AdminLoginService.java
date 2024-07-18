package com.gaurav.ImageUpload.services;

import com.gaurav.ImageUpload.model.AdminLogin;

public interface AdminLoginService {

	public AdminLogin findbyemailandpassword(String email, String password);
}
