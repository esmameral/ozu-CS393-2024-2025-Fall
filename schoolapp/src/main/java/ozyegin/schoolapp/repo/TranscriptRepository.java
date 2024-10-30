package ozyegin.schoolapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ozyegin.schoolapp.model.Student;
import ozyegin.schoolapp.model.Transcript;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {

}
