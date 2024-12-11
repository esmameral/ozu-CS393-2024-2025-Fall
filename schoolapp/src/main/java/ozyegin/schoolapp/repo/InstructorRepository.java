package ozyegin.schoolapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ozyegin.schoolapp.model.Instructor;
import ozyegin.schoolapp.projection.InstructorInfo;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
	
	@Query("Select i from Instructor i")
	public List<InstructorInfo> getAllInstructor();

}
