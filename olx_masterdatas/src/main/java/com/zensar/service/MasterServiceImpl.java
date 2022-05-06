package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.OlxCategory;
import com.zensar.entity.OlxStatus;
import com.zensar.repository.CategoryRepository;
import com.zensar.repository.StatusRepository;

@Service
public class MasterServiceImpl implements MasterService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<OlxCategory> getAllCategorys() {
		return categoryRepository.findAll();
	}

	@Override
	public List<OlxStatus> getAllStatus() {
		return statusRepository.findAll();
	}

}
