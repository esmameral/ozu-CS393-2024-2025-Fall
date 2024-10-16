package ozyegin.myproject.dao;

import java.util.List;

import ozyegin.myproject.model.Course;


public interface StudentDAO {
	public List<Course> getCourses(String sid) ;
	public int enrollCourse(String sid, Course course);
}
