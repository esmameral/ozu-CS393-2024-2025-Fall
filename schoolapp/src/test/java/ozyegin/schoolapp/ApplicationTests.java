package ozyegin.schoolapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import jakarta.transaction.Transactional;
import ozyegin.schoolapp.model.Course;
import ozyegin.schoolapp.model.Student;
import ozyegin.schoolapp.model.Transcript;
import ozyegin.schoolapp.repo.CourseRepository;
import ozyegin.schoolapp.repo.InstructorRepository;
import ozyegin.schoolapp.repo.StudentRepository;
import ozyegin.schoolapp.repo.TranscriptRepository;

@SpringBootTest
class ApplicationTests {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@Autowired
	TranscriptRepository tranRepository;
	
	@Autowired
	InstructorRepository instructorRepository;

	@Test
	void testQueries() {
		List<Course> list=courseRepository.findByNameContains("Programming");
		
		for (Course course : list) {
			System.out.println(course);
		}
		
		assertEquals(2,list.size());
		
		
		
		List<Course> list2=courseRepository.findByCreditGreaterThan(5);
		for (Course course : list2) {
			System.out.println(course);
		}
		assertEquals(2,list2.size());
		
	}
	
	@Test
	void testCourseRepo() {
		long count=courseRepository.count();
		
		Course c=new Course("CS393", "Backend Applications", 4);
		c.setRoomNumber("232");
		courseRepository.save(c);
		
		List<Course> list=courseRepository.findAll();
		assertTrue(list.size()==count+1);
		
		Course course=courseRepository.findById(1).get();
		assertTrue(course.getId()==1);
		
	}
	
	@Test
	void testEntityRelationships() {
		Course c=new Course("CS393", "Backend Applications 61", 4);
		c.setRoomNumber("232");
	
		
		Student s1=new Student("Baris1","CS");
		//s1.setId(111);
		Student s2=new Student("Sema1","IE");
		studentRepository.save(s1);
		studentRepository.save(s2);
		
		c.getStudents().add(s1);
		c.getStudents().add(s2);
				
		s1.getCourses().add(c);
		s2.getCourses().add(c);
		

		courseRepository.save(c);
	
		
	
		
	}
	
	
	
	@Test
	void testStudentAndTranscript() {
		Student s=new Student("Sema","CS");
		Transcript tran=new Transcript();
		tran.setGrade(80);
		//tranRepository.save(tran);
		s.setTranscript(tran);
		studentRepository.save(s);
		
		
		
		
	}
	@Test
	void testCascadeDelete() {
		
		studentRepository.deleteById(1402);
	}
	
	@Test
	void testGetStudentsByName() {
		List<Student> list=studentRepository.getStudentsNameLike("B");
		assertTrue(list.size()>0);
		for (Student student : list) {
			System.out.println(student.getName());
		}
		
	}
	@Test
	void testGetStudentsByCourseAndGrade() {
		List<Student> list=studentRepository.getAllStudentsInACourseWithAGrade("CS391",80);
		assertTrue(list.size()>0);
		for (Student student : list) {
			System.out.println(student.getName());
		}
		
	}
	@Test
	@Transactional
	@Commit
	void testUpdateCourse() {
		courseRepository.updateCourseNameAndRoom("Introduction to OO programming with Java", "410", "CS105");
		
	}
	@Test
	@Transactional
	@Commit
	void testUnassignInstructor() {
		courseRepository.unassignInstructorFromACourse(2);
		Course course=courseRepository.findById(2).get();
		assertTrue(course.getInstructor()==null);
	}
	
	
	@Test
	@Transactional
	@Commit
	void testDeleteInstructor() {
		courseRepository.unassignInstructorFromCourses(2);
		instructorRepository.deleteById(2);
	}
}
