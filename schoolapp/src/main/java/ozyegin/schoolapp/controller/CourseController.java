package ozyegin.schoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ozyegin.schoolapp.model.Course;
import ozyegin.schoolapp.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	
	@RequestMapping(value="/{code}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable("code") String courseCode) {
		
		return courseService.getCourse(courseCode);
	}
}
