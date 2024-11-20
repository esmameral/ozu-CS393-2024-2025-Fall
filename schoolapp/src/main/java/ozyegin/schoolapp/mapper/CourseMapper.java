package ozyegin.schoolapp.mapper;

import ozyegin.schoolapp.dto.CourseDTO;
import ozyegin.schoolapp.model.Course;

public class CourseMapper {
	public static CourseDTO courseToCourseDTO(Course course) {
		CourseDTO dto=new CourseDTO(course.getName(), course.getCode(), course.getCredit(), course.getRoomNumber());
		return dto;
	}
	
	public static Course courseDTOToCourse(CourseDTO dto) {
		Course course=new Course();
		course.setCode(dto.getCode());
		course.setName(dto.getName());
		course.setCredit(dto.getCredit());
		course.setRoomNumber(dto.getOfficeNumber());
		return course;
	}

}
