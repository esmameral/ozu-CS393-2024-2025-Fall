package ozyegin.schoolapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ozyegin.schoolapp.dto.CourseDTO;
import ozyegin.schoolapp.model.Course;
import ozyegin.schoolapp.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	
	@RequestMapping(value="/{code}", method = RequestMethod.GET)
	public ResponseEntity<CourseDTO> getCourse(@PathVariable("code") String courseCode) {
		CourseDTO newCourse=courseService.getCourse(courseCode);
		return ResponseEntity.status(HttpStatus.FOUND).body(newCourse);
	}
	
	@GetMapping
	public List<CourseDTO> getCourses() {
		return courseService.getCourses();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) {
		return courseService.saveCourse(courseDTO);
	}
	
	
	
}
