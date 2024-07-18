package com.gaurav.ImageUpload.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gaurav.ImageUpload.model.LivingRoom;
import com.gaurav.ImageUpload.services.LivingRoomService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class HomeController {
	
	@Autowired
	LivingRoomService lsr;
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/images";
	
	@GetMapping("/")
	public String home() {
		return "hello world";
	}
	
	
	@PostMapping("/")
	public LivingRoom insert(@ModelAttribute LivingRoom lr, @RequestParam("image") MultipartFile file) throws IOException {
		
		String originalFileName=file.getOriginalFilename();
		Path fileNameAndPath = Paths.get(uploadDirectory,originalFileName);
		Files.write(fileNameAndPath,file.getBytes());
		
		lr.setPhoto(originalFileName);
//		 lr.setPhoto("/images/" + originalFileName);
		return lsr.saveData(lr);
	}
	
	@GetMapping("/livingroom")
	public List<LivingRoom> get(){
		return lsr.getAll();
	}
	@GetMapping("/livingroom/{id}")
	public LivingRoom getbyId(@PathVariable("id")Long id){
		return lsr.getById(id);
	}
	
	@GetMapping("/type/{type}")
	public List<LivingRoom> getbytype(@PathVariable("type")String type){
		return lsr.findbyType(type);
	}
	
	@DeleteMapping("/livingroom/{id}")
	public void delete(@PathVariable("id")Long id) {
		lsr.deletebyid(id);
	}
	
	  @PutMapping("/update/{id}")
	    public LivingRoom update(@PathVariable("id") Long id,
	                             @RequestParam("productName") String productName,
	                             @RequestParam("price") String price,
	                             @RequestParam("type") String type,
	                             @RequestParam(value ="image", required = false) MultipartFile photo) throws IOException {
	        LivingRoom lr = new LivingRoom();
	        lr.setProductName(productName);
	        lr.setPrice(price);
	        lr.setType(type);
	        if (photo == null ) {
	           
	            LivingRoom l = lsr.getById(id);
	        	lr.setPhoto(l.getPhoto());
	        }else {
	        	 String originalFileName = photo.getOriginalFilename();
		            Path fileNameAndPath = Paths.get(uploadDirectory, originalFileName);
		            Files.write(fileNameAndPath, photo.getBytes());
		            lr.setPhoto(originalFileName);
	        }
	        	
	        
	        return lsr.update(id, lr);
	    }
	

	
	
//	public ResponseEntity<LivingRoom> update(
//	        @PathVariable("id") Long id,
//	        @RequestParam("productName") String productName,
//	        @RequestParam("price") String price,
//	        @RequestParam("type") String type,
//	        @RequestParam(value = "image", required = false) MultipartFile photo) throws IOException {
//	        
//	        LivingRoom lr = lsr.getById(id);
//	        if (lr == null) {
//	            return ResponseEntity.notFound().build();
//	        }
//
//	        lr.setProductName(productName);
//	        lr.setPrice(price);
//	        lr.setType(type);
//
//
////	        if (photo != null) {
////	            if (!photo.isEmpty()) {
////	                String originalFileName = photo.getOriginalFilename();
////	                Path fileNameAndPath = Paths.get(uploadDirectory, originalFileName);
////	                Files.write(fileNameAndPath, photo.getBytes());
////	                lr.setPhoto(originalFileName);
////	            } else {
////	                // Handle the case when the photo is empty
////	                lr.setPhoto(lr.getPhoto()); // Retain the existing photo
////	            }
////	        } else {
////	            // Handle the case when the photo is null
////	            lr.setPhoto(lr.getPhoto()); // Retain the existing photo
////	        }
//	        
//	        if(photo == null && photo.isEmpty() ) {
//	        	LivingRoom lr1 = lsr.getById(id);
//	        	lr.setPhoto(lr1.getPhoto());
//	        }else {
//	        	 String originalFileName = photo.getOriginalFilename();
//	                Path fileNameAndPath = Paths.get(uploadDirectory, originalFileName);
//	                Files.write(fileNameAndPath, photo.getBytes());
//	                lr.setPhoto(originalFileName);
//	        }
//
//
//	        lsr.update(id, lr);
//	        return ResponseEntity.ok(lr);
//	    }
}
