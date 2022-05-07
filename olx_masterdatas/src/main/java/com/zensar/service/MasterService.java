package com.zensar.service;

import java.util.List;

import com.zensar.entity.OlxCategory;
import com.zensar.entity.OlxStatus;
import com.zensar.entitydto.OlxCategoryDto;
import com.zensar.entitydto.OlxStatusDto;

public interface MasterService {

	List<OlxCategoryDto> getAllCategorys();
	List<OlxStatusDto> getAllStatus();
}
