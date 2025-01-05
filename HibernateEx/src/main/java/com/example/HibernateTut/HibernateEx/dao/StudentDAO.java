package com.example.HibernateTut.HibernateEx.dao;

import java.util.List;

import com.example.HibernateTut.HibernateEx.Crud.Student;

public interface StudentDAO {

	void save(Student student);
	Student find(int id);
	List<Student> retrieveStudents();
	List<Student> findByLastName(String lastName);
}
