package ozyegin.myproject;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import ozyegin.myproject.dao.CourseDAO;
import ozyegin.myproject.dao.StudentDAO;
import ozyegin.myproject.model.Course;
import ozyegin.myproject.service.CalendarService;

@SpringBootTest
@ActiveProfiles("tr")
class ApplicationTests {

	@Autowired
	CourseDAO courseDAO;
	
	@Autowired
	StudentDAO studentDAO;
	
	@MockBean
	CalendarService calendarMock;
	
	@Test
	void testCreateCourse() {
		Course c=new Course("CS401","Project",6);
		int result=courseDAO.saveCourse(c);
		assertTrue(result==1);	
	}
	
	@Test
	void testStudentDAO() {
		List<Course> list= studentDAO.getCourses("S02");
		assertTrue(list.size()==1);
		
	}
	
	@Test
	void testEnrollment() {
		
		int courseCount1= studentDAO.getCourses("S02").size();
		when(calendarMock.timeConflictCheck("S02", "CS401")).thenReturn(false);
		when(calendarMock.timeConflictCheck("S01", "CS401")).thenReturn(true);
		
		Course c=new Course(4,"CS401","Project",6);
		studentDAO.enrollCourse("S02", c);
		studentDAO.enrollCourse("S01", c);
		verify(calendarMock, times(1)).timeConflictCheck("S02", "CS401");
		verify(calendarMock, times(1)).timeConflictCheck("S01", "CS401");
		
		int courseCount2= studentDAO.getCourses("S02").size();
		assertTrue(courseCount2==courseCount1+1);
		
		
	}

}
