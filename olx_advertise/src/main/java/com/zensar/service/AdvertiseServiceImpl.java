package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.AdvertiseDetails;
import com.zensar.entitydto.AdvertiseDetailsDto;
import com.zensar.repository.AdvertiseRepository;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {
	
	@Autowired
	private AdvertiseRepository advertiseRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AdvertiseDetailsDto createAdvertise(AdvertiseDetailsDto newAdvertise) {
		AdvertiseDetails newAd=modelMapper.map(newAdvertise, AdvertiseDetails.class);
		AdvertiseDetails save=advertiseRepository.save(newAd);
		return modelMapper.map(save, AdvertiseDetailsDto.class);
	}

	@Override
	public AdvertiseDetailsDto updateAdvertise(int id, AdvertiseDetailsDto info) {
		AdvertiseDetailsDto adResponse= getAdvertise(id);
		AdvertiseDetails info2=modelMapper.map(adResponse, AdvertiseDetails.class);
		if(info2 != null) {
			info2.setId(id);
			info2.setTitle(info2.getTitle());
			info2.setCategory(info2.getCategory());
			info2.setCreatedDate(info2.getCreatedDate());
			info2.setDescription(info2.getDescription());
			info2.setModifiedDate(info2.getModifiedDate());
			info2.setPrice(info2.getPrice());
			info2.setStatus(info2.getStatus());
			info2.setUserName(info2.getUserName());
			AdvertiseDetails info3=advertiseRepository.save(info2);
			return modelMapper.map(info3, AdvertiseDetailsDto.class);
		}else {
			return null;
		}
		
	}

	@Override
	public List<AdvertiseDetailsDto> getAllAdvertise() {
		List<AdvertiseDetails> allAd=advertiseRepository.findAll();
		List<AdvertiseDetailsDto> dtos=new ArrayList<AdvertiseDetailsDto>();
		for(AdvertiseDetails ad:allAd) {
			AdvertiseDetailsDto getAllAd=modelMapper.map(ad, AdvertiseDetailsDto.class);
			dtos.add(getAllAd);
		}
		return dtos;
	}

	@Override
	public AdvertiseDetailsDto getAdvertiseById(int postId) {
		Optional<AdvertiseDetails> getIdAd=advertiseRepository.findById(postId);
		AdvertiseDetails advertiseDetails=null;
		if(getIdAd.isPresent()) {
			advertiseDetails=getIdAd.get();
			return modelMapper.map(advertiseDetails, AdvertiseDetailsDto.class);
		}else {
			return null;
		}
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
	public List<AdvertiseDetailsDto> filterAdvertise() {
		List<AdvertiseDetails> allAd=advertiseRepository.findAll();
		List<AdvertiseDetailsDto> dtos=new ArrayList<AdvertiseDetailsDto>();
		for(AdvertiseDetails ad:allAd) {
			AdvertiseDetailsDto getAllAd=modelMapper.map(ad, AdvertiseDetailsDto.class);
			dtos.add(getAllAd);
		}
		return dtos;
	}

	@Override
	public List<AdvertiseDetailsDto> searchedAdvertise() {
		List<AdvertiseDetails> allAd=advertiseRepository.findAll();
		List<AdvertiseDetailsDto> dtos=new ArrayList<AdvertiseDetailsDto>();
		for(AdvertiseDetails ad:allAd) {
			AdvertiseDetailsDto getAllAd=modelMapper.map(ad, AdvertiseDetailsDto.class);
			dtos.add(getAllAd);
		}
		return dtos;
	}

	@Override
	public AdvertiseDetailsDto getAdvertise(int postId) {
		Optional<AdvertiseDetails> getIdAd=advertiseRepository.findById(postId);
		AdvertiseDetails advertiseDetails=null;
		if(getIdAd.isPresent()) {
			advertiseDetails=getIdAd.get();
			return modelMapper.map(advertiseDetails, AdvertiseDetailsDto.class);
		}else {
			return null;
		}
	}

}
