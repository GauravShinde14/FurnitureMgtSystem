package com.gaurav.ImageUpload.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gaurav.ImageUpload.model.MyCart;
import com.gaurav.ImageUpload.repository.MyCartRepo;

@Service
public class MyCartServiceImp implements MyCartService {
	
	@Autowired
	@Qualifier("mcrepo")
	MyCartRepo mcrepo;

	@Override
	public List<MyCart> getallByEmail(String e) {
		// TODO Auto-generated method stub
		return mcrepo.findAllByEmail(e);
	}

	@Override
	public MyCart insert(MyCart mc) {
		// TODO Auto-generated method stub
		return mcrepo.save(mc);
	}

	@Override
	public MyCart findById(Long id) {
		// TODO Auto-generated method stub
		Optional<MyCart> opt = mcrepo.findById(id);
		
		if(opt.isPresent()) {
			MyCart b = opt.get();
			return b;
		}
		
		return null;
	}

}
