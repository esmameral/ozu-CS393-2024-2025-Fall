package ozyegin.schoolapp.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import ozyegin.schoolapp.model.Course;
import ozyegin.schoolapp.model.Transcript;

public class StudentDTO {
    private int studentId;
	private String fullName;
	private String program;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	

}
