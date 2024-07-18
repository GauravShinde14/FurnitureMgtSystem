package com.gaurav.ImageUpload.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.ImageUpload.model.MyCart;
import com.gaurav.ImageUpload.services.MyCartService;


@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class MyCartController {

	
	@Autowired
	MyCartService mcserv;
	
	@GetMapping("/mycart/{e}")
	public List<MyCart> getAllByemail(@PathVariable("e")String e){
		return mcserv.getallByEmail(e);
	}
	
	@GetMapping("/mycartt/{id}")
	public MyCart getbyid(@PathVariable("id")Long id){
		return mcserv.findById(id);
	}
	@PostMapping("/mycart")
	public MyCart insert(@RequestBody MyCart mc){
		return mcserv.insert(mc);
	}
}
