package ozyegin.myproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ozyegin.myproject.model.Course;

@Repository
public class CourseDAOImpl implements CourseDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int saveCourse(Course course) {
		String sql="INSERT INTO course (course_name,code,credit) VALUES (?,?,?)";
		return jdbcTemplate.update(sql, course.getName(),course.getCode(),course.getCredit());
	}
}
