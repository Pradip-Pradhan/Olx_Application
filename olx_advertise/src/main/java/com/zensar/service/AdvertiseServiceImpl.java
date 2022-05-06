package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.AdvertiseDetails;
import com.zensar.repository.AdvertiseRepository;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {
	
	@Autowired
	private AdvertiseRepository advertiseRepository;

	@Override
	public AdvertiseDetails createAdvertise(AdvertiseDetails newAdvertise) {
		return advertiseRepository.save(newAdvertise);
	}

	@Override
	public AdvertiseDetails updateAdvertise(int id, AdvertiseDetails info) {
		if(advertiseRepository.existsById(id)) {
			AdvertiseDetails updated=advertiseRepository.save(info);
			return updated;
		}
		else {
			return null;
		}
	}

	@Override
	public List<AdvertiseDetails> getAllAdvertise() {
		return advertiseRepository.findAll();
	}

	@Override
	public Optional<AdvertiseDetails> getAdvertiseById(int postId) {
		return advertiseRepository.findById(postId);
	}

	@Override
	public boolean deleteAdvertise(int postId) {
		if(advertiseRepository.existsById(postId)) {
			advertiseRepository.deleteById(postId);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<AdvertiseDetails> filterAdvertise() {
		return advertiseRepository.findAll();
	}

	@Override
	public List<AdvertiseDetails> searchedAdvertise() {
		return advertiseRepository.findAll();
	}

	@Override
	public Optional<AdvertiseDetails> getAdvertise(int postId) {
		return advertiseRepository.findById(postId);
	}

}
