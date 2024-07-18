package com.gaurav.ImageUpload.services;

import java.util.List;

import com.gaurav.ImageUpload.model.Register;

public interface RegisterService {

	Register insert(Register r);
	List<Register> getAll();
	Register login(String e,String p);
}
