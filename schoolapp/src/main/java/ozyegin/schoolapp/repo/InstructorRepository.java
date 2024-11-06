package ozyegin.schoolapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ozyegin.schoolapp.model.Instructor;
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
	
	

}
