package ozyegin.schoolapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import ozyegin.schoolapp.projection.InstructorInfo;
import ozyegin.schoolapp.repo.InstructorRepository;

@Service
public class InstructorService {
	@Autowired
	InstructorRepository repo;
	
	
	public List<InstructorInfo> getAll() {
		return repo.getAllInstructor();
	}
}
