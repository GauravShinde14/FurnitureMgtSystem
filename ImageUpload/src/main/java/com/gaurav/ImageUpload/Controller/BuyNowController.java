package com.gaurav.ImageUpload.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.ImageUpload.model.BuyNow;

import com.gaurav.ImageUpload.services.BuyNowService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class BuyNowController {

	
	@Autowired
	BuyNowService bns;
	

	@GetMapping("/buynow")
	public List<BuyNow> getAll(){
		return bns.getAll();
	}
	
	@PostMapping("/buynow")
	public BuyNow insert(@RequestBody BuyNow b){
		return bns.insert(b);
	}
	
}
