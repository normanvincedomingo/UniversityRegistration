package com.universityregistration.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.universityregistration.model.Student;


public class StudentDaoImpl implements StudentDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {
		Session session = sessionFactory.openSession();  
		  @SuppressWarnings("unchecked")  
		  List<Student> studentList = session.createQuery("from Student")  
		    .list();  
		  session.close();  
		  return studentList; 
	}

	@Transactional  
	 public int insertRow(Student student) {  
	  Session session = sessionFactory.openSession();  
	  Transaction tx = session.beginTransaction();  
	  session.saveOrUpdate(student);  
	  tx.commit();  
	  Serializable id = session.getIdentifier(student);  
	  session.close();  
	  return (Integer) id;  
	 }  
	
	@Override  
	 public Student getRowById(int id) {  
	  Session session = sessionFactory.openSession();  
	  Student employee = (Student) session.load(Student.class, id);  
	  return employee;  
	 }  
	  
	 @Override  
	 public int updateRow(Student student) {  
	  Session session = sessionFactory.openSession();  
	  Transaction tx = session.beginTransaction();  
	  session.saveOrUpdate(student);  
	  tx.commit();  
	  Serializable id = session.getIdentifier(student);  
	  session.close();  
	  return (Integer) id;  
	 }  
	  
	 @Override  
	 public int deleteRow(int id) {  
	  Session session = sessionFactory.openSession();  
	  Transaction tx = session.beginTransaction();  
	  Student employee = (Student) session.load(Student.class, id);  
	  session.delete(employee);  
	  tx.commit();  
	  Serializable ids = session.getIdentifier(employee);  
	  session.close();  
	  return (Integer) ids;  
	 }  
	  

}

