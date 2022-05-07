package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.OlxCategory;
import com.zensar.entity.OlxStatus;
import com.zensar.entitydto.OlxCategoryDto;
import com.zensar.entitydto.OlxStatusDto;
import com.zensar.repository.CategoryRepository;
import com.zensar.repository.StatusRepository;

@Service
public class MasterServiceImpl implements MasterService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<OlxCategoryDto> getAllCategorys() {
		List<OlxCategory> categories=categoryRepository.findAll();
		List<OlxCategoryDto> dtos=new ArrayList<OlxCategoryDto>();
		
		for(OlxCategory category:categories) {
			OlxCategoryDto categoryDto=modelMapper.map(category, OlxCategoryDto.class);
			dtos.add(categoryDto);
		}
		return dtos;
	}

	@Override
	public List<OlxStatusDto> getAllStatus() {
		List<OlxStatus> status=statusRepository.findAll();
		List<OlxStatusDto> dtos=new ArrayList<OlxStatusDto>();
		for(OlxStatus status2:status) {
			OlxStatusDto olxStatusDto=modelMapper.map(status2, OlxStatusDto.class);
			dtos.add(olxStatusDto);
		}
		return dtos;
	}

}
