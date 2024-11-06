package ozyegin.schoolapp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ozyegin.schoolapp.model.Course;
import ozyegin.schoolapp.model.Instructor;
import ozyegin.schoolapp.model.Student;
import ozyegin.schoolapp.model.Transcript;
import ozyegin.schoolapp.repo.CourseRepository;
import ozyegin.schoolapp.repo.InstructorRepository;
import ozyegin.schoolapp.repo.StudentRepository;
import ozyegin.schoolapp.repo.TranscriptRepository;

@SpringBootTest
public class InitialData {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@Autowired
	TranscriptRepository tranRepository;
	
	@Autowired
	InstructorRepository insRepository;
	
	@Test
	void insertInitialData(){
        Instructor ins1=new Instructor("Hasan","111");
        Instructor ins2=new Instructor("Fatih","241");
		
		Course c1=new Course("CS391", "Frontend Applications", 4);
		Course c2=new Course("CS393", "Backend Applications", 4);
		Course c3=new Course("CS105", "OO programming with Java", 6);
		c1.setInstructor(ins1);
		c2.setInstructor(ins1);
		c3.setInstructor(ins2);
		
		ins1.getCourses().add(c1);
		ins1.getCourses().add(c2);
		ins2.getCourses().add(c3);
		
		insRepository.save(ins1);
		insRepository.save(ins2);
		courseRepository.save(c1);
		courseRepository.save(c2);
		courseRepository.save(c3);
		

		Student s1=new Student("Baris","CS");
		Student s2=new Student("Sema","IE");
		Student s3=new Student("Berke","EE");
		studentRepository.save(s1);
		studentRepository.save(s2);
		studentRepository.save(s3);	
		
		c1.getStudents().add(s1);
		c1.getStudents().add(s2);
		c1.getStudents().add(s3);
		c2.getStudents().add(s1);
		c3.getStudents().add(s1);
		c3.getStudents().add(s3);
		courseRepository.save(c1);
		courseRepository.save(c2);
		courseRepository.save(c3);	
		
		s1.getCourses().add(c1);
		s1.getCourses().add(c2);
		s1.getCourses().add(c3);
		
		s2.getCourses().add(c1);
		s2.getCourses().add(c1);
		
		s3.getCourses().add(c1);
		s3.getCourses().add(c3);
		
		
		studentRepository.save(s1);
		studentRepository.save(s2);
		studentRepository.save(s3);	
		

		
		
		Transcript tran1=new Transcript();
		tran1.setGrade(70);
		Transcript tran2=new Transcript();
		tran2.setGrade(80);
		Transcript tran3=new Transcript();
		tran3.setGrade(90);
		
		s1.setTranscript(tran1);
		s2.setTranscript(tran2);
		s3.setTranscript(tran3);
		
		
		

		tranRepository.save(tran1);		
		tranRepository.save(tran2);		
		tranRepository.save(tran3);		
		studentRepository.save(s1);
		studentRepository.save(s2);
		studentRepository.save(s3);	
	}
}
