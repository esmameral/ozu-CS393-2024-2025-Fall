package ozyegin.schoolapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ozyegin.schoolapp.projection.InstructorInfo;
import ozyegin.schoolapp.service.InstructorService;

@RestController
@RequestMapping("/instructors")
@CrossOrigin
public class InstructorController {
	
	@Autowired
	InstructorService service;
	
	@GetMapping
	public List<InstructorInfo> getAll() {	
		return service.getAll();
	}
}
