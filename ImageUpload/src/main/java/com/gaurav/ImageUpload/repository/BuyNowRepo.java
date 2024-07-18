package com.gaurav.ImageUpload.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.ImageUpload.model.BuyNow;

@Repository
@Qualifier("bnrepo")
public interface BuyNowRepo extends JpaRepository<BuyNow, Long> {

}
