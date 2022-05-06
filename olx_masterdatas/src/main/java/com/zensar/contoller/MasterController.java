package com.zensar.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.OlxCategory;
import com.zensar.entity.OlxStatus;
import com.zensar.service.MasterServiceImpl;

@RestController
@RequestMapping("/advertise")
public class MasterController {
	@Autowired
	private MasterServiceImpl masterServiceImpl;
	
	@GetMapping("/category")
	public List<OlxCategory> getAllCategorys(){
		return masterServiceImpl.getAllCategorys();
	}
	
	@GetMapping("/status")
	public List<OlxStatus> getOlxStatus(){
		return masterServiceImpl.getAllStatus();
	}

}
