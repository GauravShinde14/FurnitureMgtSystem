package com.gaurav.ImageUpload.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.ImageUpload.model.MyCart;

@Repository
@Qualifier("mcrepo")
public interface MyCartRepo extends JpaRepository<MyCart, Long> {
	
	List<MyCart> findAllByEmail(String e);

}
