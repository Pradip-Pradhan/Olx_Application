package com.zensar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.AdvertiseDetails;
import com.zensar.service.AdvertiseService;

@RestController
public class AdvertiseController {
	@Autowired
	private AdvertiseService advertiseService;

	@PostMapping("/advertise")
	public ResponseEntity<AdvertiseDetails> createAdvertise(@RequestBody AdvertiseDetails newAdvertise) {
		AdvertiseDetails newOne=advertiseService.createAdvertise(newAdvertise);
		return new ResponseEntity<AdvertiseDetails>(newOne,HttpStatus.CREATED);
	}
	
	@PutMapping("/advertise/{id}")
	public AdvertiseDetails updateAdvertise(@PathVariable int id, @RequestBody AdvertiseDetails info) {
		return advertiseService.updateAdvertise(id, info);
	}
	
	@GetMapping("/user/advertise")
	public List<AdvertiseDetails> getAllAdvertise(){
		return advertiseService.getAllAdvertise();
	}
	
	@GetMapping("/user/advertise/{postId}")
	public Optional<AdvertiseDetails> getAdvertiseById(@PathVariable int postId){
		return advertiseService.getAdvertiseById(postId);
	}
	
	@DeleteMapping("/user/advertise/{postId}")
	public boolean deleteAdvertise(@PathVariable int postId) {
		return advertiseService.deleteAdvertise(postId);
	}
	
	@GetMapping("/advertise/search/filtercriteria")
	public List<AdvertiseDetails> filterAdvertise(){
		return advertiseService.filterAdvertise();
	}
	
	@GetMapping("/advertise/search")
	public List<AdvertiseDetails> searchedAdvertise(){
		return advertiseService.searchedAdvertise();
	}
	
	@GetMapping("/advertise/{postId}")
	public Optional<AdvertiseDetails> getAdvertise(@PathVariable int postId){
		return advertiseService.getAdvertise(postId);
	}
}
