package ozyegin.schoolapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ozyegin.schoolapp.dto.StudentDTO;
import ozyegin.schoolapp.mapper.StudentMapper;
import ozyegin.schoolapp.model.Course;
import ozyegin.schoolapp.model.Student;
import ozyegin.schoolapp.projection.StudentBasicInfo;
import ozyegin.schoolapp.repo.CourseRepository;
import ozyegin.schoolapp.repo.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repo;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	StudentMapper mapper; 
	
	
	public StudentDTO findByID(int id) {
		Student student=repo.findById(id).get();
		return mapper.studentToDTO(student);
	}
	
	public List<StudentBasicInfo> getAll() {
		return repo.getAllStudents();
	}

	public void enrollCourse(int id, String courseCode) {
		Student student=repo.findById(id).get();
		Course course = courseRepo.findByCode(courseCode);
		student.getCourses().add(course);
		course.getStudents().add(student);
		repo.save(student);
		courseRepo.save(course);
		
		
	}

}
