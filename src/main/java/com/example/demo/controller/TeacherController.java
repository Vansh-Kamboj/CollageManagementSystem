package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repo.TeacherRepository;
@Controller 
public class TeacherController {
	
	@Autowired
	private TeacherRepository TeacherService;

	public TeacherController() {
	}
	@GetMapping("/teachers")
	public String listteachers(Model model) {
		List<Teacher>allTeachers=TeacherService.findAll();
		System.out.println(TeacherService);
		model.addAttribute("teachers",allTeachers );
		return "teachers";
	}
	
	@GetMapping("/teachers/new")
	public String createteachersForm(Model model) {
	    Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "Create_teacher";
		
	} 
	
	@PostMapping("/teachers")
	public String saveteacher(@ModelAttribute("teacher") Teacher teach) {
		TeacherService.save(teach);
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/edit/{id}")
	public String editteacherForm(@PathVariable Long id, Model model) {
		Teacher teacherstobeupdate= (TeacherService.getOne(id));
		model.addAttribute("teacher",teacherstobeupdate);
		return "Edit_teacher";
	}

	@PostMapping("/teachers/{id}")
	public String updateStudent(@PathVariable Long  id,
			@ModelAttribute("teacher") Teacher teacher,
			Model model) {
		
		// get student from database by id
		Teacher existingteacher = TeacherService.getOne(id);
		existingteacher.setId(id);
		existingteacher.setFirstName(teacher.getFirstName());
		existingteacher.setLastName(teacher.getLastName());
		existingteacher.setEmail(teacher.getEmail());
		existingteacher.setPost(teacher.getPost());
		// save updated student object
		TeacherService.save(existingteacher);
		return "redirect:/teachers";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/teachers/{id}")
	public String deleteStudent(@PathVariable Long  id) {
		TeacherService.deleteById(id);
		return "redirect:/teachers";
	}

}
