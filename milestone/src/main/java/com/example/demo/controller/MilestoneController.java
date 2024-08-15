package com.example.demo.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.MilestoneEntity;
import com.example.demo.service.MilestoneService;
 
@Controller
public class MilestoneController {
	@Autowired
	private MilestoneService service;
	
	@GetMapping("/milestones")
	public String showList(Model model) {
		model.addAttribute("milestoneList", service.list());
		return "milestones/list";
	 }
	
	@GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("milestoneCreate", new MilestoneEntity());
        return "milestones/createForm";
    }
	@PostMapping("/create")
	 public String saveMilestone(@ModelAttribute MilestoneEntity create) {
		service.insert(create);
		return "redirect:/milestones";
	 }
	
	@DeleteMapping("/{id}")
	 public String deleteMilestone(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/milestones";
	}
	
	@GetMapping("/{id}")
	 public String showDetail(@PathVariable Long id, Model model) {
		Optional<MilestoneEntity> optionalMilestone = service.detail(id);
		model.addAttribute("milestoneDetail", optionalMilestone.get());
		return "milestones/detail";
	}
 
}