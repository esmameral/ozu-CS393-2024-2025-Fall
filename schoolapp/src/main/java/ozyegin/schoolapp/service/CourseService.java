package ozyegin.schoolapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ozyegin.schoolapp.dto.CourseDTO;
import ozyegin.schoolapp.mapper.CourseMapper;
import ozyegin.schoolapp.model.Course;
import ozyegin.schoolapp.repo.CourseRepository;

@Service
public class CourseService {
    @Autowired
    CourseRepository repo;
    
	public CourseDTO getCourse(String code) {
		
		return CourseMapper.courseToCourseDTO(repo.findByCode(code));
		
	}

	public CourseDTO saveCourse(CourseDTO dto) {
		return CourseMapper.courseToCourseDTO(repo.save(CourseMapper.courseDTOToCourse(dto)));
	}

	public List<CourseDTO> getCourses() {
		List<Course> list=repo.findAll();
		List<CourseDTO> dtoList=new ArrayList<CourseDTO>();
		for (Course course : list) {
			dtoList.add(CourseMapper.courseToCourseDTO(course));
		}
		
		return dtoList;
	}
}
