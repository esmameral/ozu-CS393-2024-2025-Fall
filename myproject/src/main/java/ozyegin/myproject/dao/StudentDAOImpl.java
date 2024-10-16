package ozyegin.myproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ozyegin.myproject.model.Course;
import ozyegin.myproject.service.CalendarService;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CalendarService calendarService;

	@Override
	public List<Course> getCourses(String sid) {
		String sql="SELECT course_name,code,credit  FROM COURSE_STUDENT CS, COURSE C "
				+ "WHERE C.ID=CS.COURSE_ID AND CS.STUDENT_ID =?";
		List<Course> cList= jdbcTemplate.query(sql, new CourseRowMapper(), sid);
		for (Course course : cList) {
			System.out.println(course);
		}
		return cList;

	}

	@Override
	public int enrollCourse(String sid, Course course) {
		if(!calendarService.timeConflictCheck(sid, course.getCode())){
			String sql="INSERT INTO COURSE_STUDENT (STUDENT_ID, COURSE_ID) VALUES(?, ?)";
			return jdbcTemplate.update(sql, sid,course.getId());
		}else
			return 0;
		
	}
	
	class CourseRowMapper implements RowMapper<Course>{

		@Override
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			Course c=new Course();
			c.setCode(rs.getString(2));
			c.setName(rs.getString(1));
			c.setCredit(rs.getInt(3));
			return c;
		}
		
	}

}
