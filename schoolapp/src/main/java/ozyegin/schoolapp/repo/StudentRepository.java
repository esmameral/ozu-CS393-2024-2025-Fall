package ozyegin.schoolapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ozyegin.schoolapp.model.Student;
import ozyegin.schoolapp.projection.StudentBasicInfo;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("Select s from Student s where s.name LIKE ?1%")
	public List<Student> getStudentsNameLike(String name);
	
	@Query("Select s from Student s")
	public List<StudentBasicInfo> getAllStudents();
		
	
	@Query("Select s from Student s join s.courses c join s.transcript t where t.grade>=:grade and c.code=:code")
	public List<Student> getAllStudentsInACourseWithAGrade(@Param("code") String courseCode, @Param("grade") int grade);

}
