package ozyegin.schoolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ozyegin.schoolapp.model.Course;
import ozyegin.schoolapp.repo.CourseRepository;

@Service
public class CourseService {
    @Autowired
    CourseRepository repo;
    
	public Course getCourse(String code) {
		
		return repo.findByCode(code);
		
	}
}
