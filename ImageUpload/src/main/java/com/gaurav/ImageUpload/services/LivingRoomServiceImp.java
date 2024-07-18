package com.gaurav.ImageUpload.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gaurav.ImageUpload.model.LivingRoom;
import com.gaurav.ImageUpload.repository.LivingRoomRepo;

@Service
public class LivingRoomServiceImp implements LivingRoomService {
	
	@Autowired
	@Qualifier("LivingRoomRepo")
	LivingRoomRepo LivingRoomRepo;

	@Override
	public LivingRoom saveData(LivingRoom lr) {
		// TODO Auto-generated method stub
		
		return LivingRoomRepo.save(lr);
	}

	@Override
	public List<LivingRoom> getAll() {
		// TODO Auto-generated method stub
		return LivingRoomRepo.findAll();
	}

	@Override
	public List<LivingRoom> findbyType(String type) {
		// TODO Auto-generated method stub
		return LivingRoomRepo.findAllByType(type);
	}

	@Override
	public LivingRoom update(Long id, LivingRoom l) {
		// TODO Auto-generated method stub
		
		Optional<LivingRoom> opt = LivingRoomRepo.findById(id);
		
		if(opt.isPresent()) {
			
			LivingRoom lr = opt.get();
			
			lr.setProductName(l.getProductName());
			lr.setPrice(l.getPrice());
			lr.setType(l.getType());
			lr.setPhoto(l.getPhoto());
			return LivingRoomRepo.save(lr);
		}
		
		
		return null;
	}

	@Override
	public LivingRoom getById(Long id) {
		// TODO Auto-generated method stub
		Optional<LivingRoom> opt =  LivingRoomRepo.findById(id);
		if(opt.isPresent()) {
			LivingRoom lr  = opt.get();
			return lr;
		}
		return null;
	}

	@Override
	public void deletebyid(Long id) {
		// TODO Auto-generated method stub
		LivingRoomRepo.deleteById(id);
	}

}
