package com.gaurav.ImageUpload.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.ImageUpload.model.AdminLogin;

@Repository
@Qualifier("adminRepo")
public interface AdminLoginRepo extends JpaRepository<AdminLogin, Integer> {

	AdminLogin findByEmailAndPassword(String email,String password);
	
}
