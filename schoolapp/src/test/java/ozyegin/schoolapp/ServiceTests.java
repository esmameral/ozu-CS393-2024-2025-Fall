package ozyegin.schoolapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ozyegin.schoolapp.model.Course;
import ozyegin.schoolapp.service.CourseService;

@SpringBootTest
public class ServiceTests {

	@Autowired
	CourseService service;
	
	@Test
	void testFindCourse(){
		Course c=service.getCourse("CS391");
		System.out.println(c.getName());
		assertNotNull(c);
	}
}
