package ozyegin.schoolapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ozyegin.schoolapp.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	public List<Course> findByNameContains(String name);
	
	
	public List<Course> findByCreditGreaterThan(int credit);

}
