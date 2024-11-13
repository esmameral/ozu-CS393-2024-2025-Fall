package ozyegin.schoolapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ozyegin.schoolapp.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	public List<Course> findByNameContains(String name);
	
	//@Query("select c from Course c where c.code=?1")
	public Course findByCode(String code);	
	
	public List<Course> findByCreditGreaterThan(int credit);
	
	@Modifying
	//@Query("Update Course c set c.name=?1, c.roomNumber=?2 where c.code=?3")
	@Query(value="update course c set course_name=?1,room_number=?2 where c.course_code=?3",nativeQuery = true)
	public void updateCourseNameAndRoom(String newName, String newRoomNumber, String code);
	
	
	@Modifying
	@Query("Update Course c set c.instructor=null where c.id=?1")
	public void unassignInstructorFromACourse(int id);
	
	
	
	@Modifying
	@Query("Update Course c set c.instructor=null where c.instructor.id=?1")
	public void unassignInstructorFromCourses(int instructorId);

}
