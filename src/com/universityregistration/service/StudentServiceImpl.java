package com.universityregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.universityregistration.dao.StudentDao;
import com.universityregistration.model.Student;


public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDao studentDao;

	@Override
	public int insertRow(Student student) {
		return studentDao.insertRow(student);
	}

	@Override
	public List<Student> getList() {
		return studentDao.getStudents();
	}
	
	@Override  
	 public Student getRowById(int id) {  
	  return studentDao.getRowById(id);  
	 }  
	  
	 @Override  
	 public int updateRow(Student student) {  
	  return studentDao.updateRow(student);  
	 }  
	  
	 @Override  
	 public int deleteRow(int id) {  
	  return studentDao.deleteRow(id);  
	 }  

}

