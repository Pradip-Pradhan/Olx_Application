package com.zensar.service;

import java.util.List;
import java.util.Optional;

import com.zensar.entity.AdvertiseDetails;

public interface AdvertiseService {

	AdvertiseDetails createAdvertise(AdvertiseDetails newAdvertise);
	AdvertiseDetails updateAdvertise(int id, AdvertiseDetails info);
	List<AdvertiseDetails> getAllAdvertise();
	Optional<AdvertiseDetails> getAdvertiseById(int postId);
	boolean deleteAdvertise(int postId);
	List<AdvertiseDetails> filterAdvertise();
	List<AdvertiseDetails> searchedAdvertise();
	Optional<AdvertiseDetails> getAdvertise(int postId);
}
