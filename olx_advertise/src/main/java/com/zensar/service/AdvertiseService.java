package com.zensar.service;

import java.util.List;
import java.util.Optional;

import com.zensar.entity.AdvertiseDetails;
import com.zensar.entitydto.AdvertiseDetailsDto;

public interface AdvertiseService {

	AdvertiseDetailsDto createAdvertise(AdvertiseDetailsDto newAdvertise);
	AdvertiseDetailsDto updateAdvertise(int id, AdvertiseDetailsDto info);
	List<AdvertiseDetailsDto> getAllAdvertise();
	AdvertiseDetailsDto getAdvertiseById(int postId);
	boolean deleteAdvertise(int postId);
	List<AdvertiseDetailsDto> filterAdvertise();
	List<AdvertiseDetailsDto> searchedAdvertise();
	AdvertiseDetailsDto getAdvertise(int postId);
}
