package com.universityregistration.dao;

import java.util.List;

import com.universityregistration.model.Student;


public interface StudentDao {

	public List<Student> getStudents();

	public int insertRow(Student student);

	public Student getRowById(int id);

	public int updateRow(Student student);

	public int deleteRow(int id);

}
