package com.gaurav.ImageUpload.services;

import java.util.List;

import com.gaurav.ImageUpload.model.BuyNow;

public interface BuyNowService {
	
	List<BuyNow> getAll();
	BuyNow findById(Long id);
	BuyNow insert(BuyNow b);
	
}
