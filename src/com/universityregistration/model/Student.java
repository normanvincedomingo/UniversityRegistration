package com.universityregistration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.universityregistration.controller.IsValidHobby;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Pattern(regexp="[^0-9]*")
	private String studentName;
	
	@Size(min=2,max=30) 
	@IsValidHobby(listOfValidHobbies="Music|Football|Cricket|Hockey")
	private String studentHobby;
	
	private Long studentMobile;
	
	@Past
	private Date studentDOB;
	
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
