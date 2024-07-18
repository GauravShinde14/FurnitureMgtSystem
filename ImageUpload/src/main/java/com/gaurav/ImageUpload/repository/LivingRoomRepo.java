package com.gaurav.ImageUpload.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.ImageUpload.model.LivingRoom;
@Repository
@Qualifier("LivingRoomRepo")
public interface LivingRoomRepo extends JpaRepository<LivingRoom, Long> {
	
	List<LivingRoom> findAllByType(String type);

}
