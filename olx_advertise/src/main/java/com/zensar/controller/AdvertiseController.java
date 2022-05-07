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
import com.zensar.entitydto.AdvertiseDetailsDto;
import com.zensar.service.AdvertiseService;

@RestController
public class AdvertiseController {
	@Autowired
	private AdvertiseService advertiseService;

	@PostMapping("/advertise")
	public ResponseEntity<AdvertiseDetailsDto> createAdvertise(@RequestBody AdvertiseDetailsDto newAdvertise) {
		AdvertiseDetailsDto newOne=advertiseService.createAdvertise(newAdvertise);
		return new ResponseEntity<AdvertiseDetailsDto>(newOne,HttpStatus.CREATED);
	}
	
	@PutMapping("/advertise/{id}")
	public AdvertiseDetailsDto updateAdvertise(@PathVariable int id, @RequestBody AdvertiseDetailsDto info) {
		return advertiseService.updateAdvertise(id, info);
	}
	
	@GetMapping("/user/advertise")
	public List<AdvertiseDetailsDto> getAllAdvertise(){
		return advertiseService.getAllAdvertise();
	}
	
	@GetMapping("/user/advertise/{postId}")
	public AdvertiseDetailsDto getAdvertiseById(@PathVariable int postId){
		return advertiseService.getAdvertiseById(postId);
	}
	
	@DeleteMapping("/user/advertise/{postId}")
	public boolean deleteAdvertise(@PathVariable int postId) {
		return advertiseService.deleteAdvertise(postId);
	}
	
	@GetMapping("/advertise/search/filtercriteria")
	public List<AdvertiseDetailsDto> filterAdvertise(){
		return advertiseService.filterAdvertise();
	}
	
	@GetMapping("/advertise/search")
	public List<AdvertiseDetailsDto> searchedAdvertise(){
		return advertiseService.searchedAdvertise();
	}
	
	@GetMapping("/advertise/{postId}")
	public AdvertiseDetailsDto getAdvertise(@PathVariable int postId){
		return advertiseService.getAdvertise(postId);
	}
}
