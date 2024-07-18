package com.gaurav.ImageUpload.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gaurav.ImageUpload.model.Register;
import com.gaurav.ImageUpload.repository.RegisterRepo;

@Service
public class RegisterServiceImp implements RegisterService {
	
	@Autowired
	@Qualifier("regRepo")
	RegisterRepo regRepo;

	@Override
	public Register insert(Register r) {
		// TODO Auto-generated method stub
		return regRepo.save(r);
	}

	@Override
	public List<Register> getAll() {
		// TODO Auto-generated method stub
		return regRepo.findAll();
	}

	@Override
	public Register login(String e, String p) {
		// TODO Auto-generated method stub
		return regRepo.findByEmailAndPassword(e, p);
	}

}
