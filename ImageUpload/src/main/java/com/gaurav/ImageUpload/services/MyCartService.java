package com.gaurav.ImageUpload.services;

import java.util.List;
import com.gaurav.ImageUpload.model.MyCart;

public interface MyCartService {

	List<MyCart> getallByEmail(String e);
	MyCart insert(MyCart mc);
	MyCart findById(Long id);
}
