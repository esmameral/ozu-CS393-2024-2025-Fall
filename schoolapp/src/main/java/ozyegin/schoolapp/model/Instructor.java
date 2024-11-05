package ozyegin.schoolapp.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="INSTRUCTOR")
public class Instructor extends Person {

	private String officeNumber;
	
	@OneToMany(mappedBy = "instructor")
	private List<Course> courses=new ArrayList<Course>();
	
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	
	
}
