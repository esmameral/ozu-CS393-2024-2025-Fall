package ozyegin.schoolapp.dto;

public class CourseDTO {
	
	private String name;
	
	private String code;
	
	private int credit;
	
	private String officeNumber;

	
	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseDTO(String name, String code, int credit, String officeNumber) {
		super();
		this.name = name;
		this.code = code;
		this.credit = credit;
		this.officeNumber = officeNumber;
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

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	
	
}
