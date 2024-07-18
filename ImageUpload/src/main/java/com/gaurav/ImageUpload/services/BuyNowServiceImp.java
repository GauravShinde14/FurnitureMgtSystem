package com.gaurav.ImageUpload.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gaurav.ImageUpload.model.BuyNow;
import com.gaurav.ImageUpload.repository.BuyNowRepo;

@Service
public class BuyNowServiceImp implements BuyNowService {
	
	@Autowired
	@Qualifier("bnrepo")
	BuyNowRepo bnrepo;

	@Override
	public List<BuyNow> getAll() {
		// TODO Auto-generated method stub
		return bnrepo.findAll();
	}

	@Override
	public BuyNow findById(Long id) {
		// TODO Auto-generated method stub
		Optional<BuyNow> opt = bnrepo.findById(id);
		
		if(opt.isPresent()) {
			BuyNow b = opt.get();
			return b;
		}
		
		return null;
	}

	@Override
	public BuyNow insert(BuyNow b) {
		// TODO Auto-generated method stub
		return bnrepo.save(b);
	}

}
