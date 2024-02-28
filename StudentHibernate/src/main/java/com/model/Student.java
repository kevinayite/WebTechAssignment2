package com.model;


import javax.persistence.*;

@Entity
@Table (name ="students")
public class Student {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "department")
	private String department;
	
	
	@Column(name = "faculty")
	private String faculty;



	public Student() {
		super();
	}



	public Student(String id) {
		super();
		this.id = id;
	}



	public Student(String id, String firstName, String lastName, String department, String faculty) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.faculty = faculty;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getFaculty() {
		return faculty;
	}



	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	
	


}


