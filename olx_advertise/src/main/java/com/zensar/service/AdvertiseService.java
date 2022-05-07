package com.zensar.service;

import java.util.List;
import java.util.Optional;

import com.zensar.entity.AdvertiseDetails;
import com.zensar.entitydto.AdvertiseDetailsDto;
import com.zensar.exception.UserNotFound;

public interface AdvertiseService {

	AdvertiseDetailsDto createAdvertise(AdvertiseDetailsDto newAdvertise);
	AdvertiseDetailsDto updateAdvertise(int id, AdvertiseDetailsDto info) throws UserNotFound;
	List<AdvertiseDetailsDto> getAllAdvertise();
	AdvertiseDetailsDto getAdvertiseById(int postId) throws UserNotFound;
	boolean deleteAdvertiseById(int postId) throws UserNotFound;
	List<AdvertiseDetailsDto> filterAdvertise();
	List<AdvertiseDetailsDto> searchedAdvertise();
	AdvertiseDetailsDto getAdvertise(int postId) throws UserNotFound;
}
