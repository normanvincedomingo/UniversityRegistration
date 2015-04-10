package com.universityregistration.service;

import java.util.List;

import com.universityregistration.model.Student;

public interface StudentService {
	
	public int insertRow(Student student);  
	  
	 public List<Student> getList();  
	 
	 public Student getRowById(int id);

		public int updateRow(Student student);

		public int deleteRow(int id);

}

