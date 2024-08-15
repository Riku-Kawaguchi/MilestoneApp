package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MilestoneEntity;

@Repository
public interface MilestoneRepository extends JpaRepository<MilestoneEntity, Long> {
	
}