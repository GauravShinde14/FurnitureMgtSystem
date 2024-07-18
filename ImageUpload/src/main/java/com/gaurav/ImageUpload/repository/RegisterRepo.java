package com.gaurav.ImageUpload.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.ImageUpload.model.Register;

@Repository
@Qualifier("regRepo")
public interface RegisterRepo extends JpaRepository<Register, Long> {
	Register findByEmailAndPassword(String email,String password);
}
