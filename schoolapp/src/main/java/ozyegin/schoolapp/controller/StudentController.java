package ozyegin.schoolapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ozyegin.schoolapp.dto.StudentDTO;
import ozyegin.schoolapp.projection.StudentBasicInfo;
import ozyegin.schoolapp.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/{studentId}")
	public StudentDTO findStudent(@PathVariable("studentId") int id) {	
		return service.findByID(id);
		
	}
	
	@GetMapping()
	public List<StudentBasicInfo> getAll() {	
		return service.getAll();
	}
	
	@PutMapping("/{studentId}/{courseCode}")
	public void enrollCourse(@PathVariable("studentId") int id, @PathVariable("courseCode") String courseCode) {
		service.enrollCourse(id, courseCode);
	}
	
}
