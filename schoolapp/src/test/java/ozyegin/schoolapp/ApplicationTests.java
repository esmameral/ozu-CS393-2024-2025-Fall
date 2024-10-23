package ozyegin.schoolapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ozyegin.schoolapp.model.Course;
import ozyegin.schoolapp.repo.CourseRepository;

@SpringBootTest
class ApplicationTests {
	@Autowired
	CourseRepository courseRepository;

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

}
