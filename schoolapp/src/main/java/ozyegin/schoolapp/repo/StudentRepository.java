package ozyegin.schoolapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ozyegin.schoolapp.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
