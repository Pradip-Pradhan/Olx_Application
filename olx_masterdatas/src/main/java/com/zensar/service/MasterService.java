package com.zensar.service;

import java.util.List;

import com.zensar.entity.OlxCategory;
import com.zensar.entity.OlxStatus;

public interface MasterService {

	List<OlxCategory> getAllCategorys();
	List<OlxStatus> getAllStatus();
}
