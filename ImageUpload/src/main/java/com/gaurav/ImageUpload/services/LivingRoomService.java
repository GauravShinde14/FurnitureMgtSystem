package com.gaurav.ImageUpload.services;

import java.util.List;

import com.gaurav.ImageUpload.model.LivingRoom;

public interface LivingRoomService {

	public LivingRoom saveData(LivingRoom lr); 
	
	public List<LivingRoom> getAll();
	public LivingRoom getById(Long id);
	public List<LivingRoom> findbyType(String type);
	public void deletebyid(Long id);
	LivingRoom update(Long id,LivingRoom l);

	
	
}
