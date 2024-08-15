package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MilestoneEntity;
import com.example.demo.repository.MilestoneRepository;

@Service
@Transactional
public class MilestoneService {
	@Autowired
	MilestoneRepository repository;
	
	public List<MilestoneEntity> list() {
		return repository.findAll();
	}

	public void insert(MilestoneEntity create) {
		repository.save(create);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Optional<MilestoneEntity> detail(Long id) {
		return repository.findById(id);
	}
}