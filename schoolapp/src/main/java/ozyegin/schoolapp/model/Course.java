package ozyegin.schoolapp.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "COURSE")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(length = 100,name = "COURSE_NAME")
	private String name;
	
	@Column(length = 5,name = "COURSE_CODE")
	private String code;
	@Column(precision = 3)
	private int credit;
	
	private String roomNumber;
	
	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Transient
	private List<Student> students=new ArrayList<>();
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Course() {
		super();
	}

	public Course(int id, String code, String name, int credit) {
		this.id=id;
		this.code=code;
		this.name=name;
		this.credit=credit;
	}
	public Course(String code, String name, int credit) {
		this.code=code;
		this.name=name;
		this.credit=credit;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	 @Override
		public String toString() {
			return "Course [id=" + id + ", name=" + name + ", code=" + code + ", credit=" + credit + "]";
		}

}
