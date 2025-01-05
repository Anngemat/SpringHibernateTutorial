package com.example.HibernateTut.HibernateEx.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.HibernateTut.HibernateEx.Crud.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
		
	}
	
	@Override
	public Student find(int id) {
		Student returnedStudent =entityManager.find(Student.class,id);
		return returnedStudent;
	}

	@Override
	public List<Student> retrieveStudents() {
		TypedQuery<Student> theQuery = entityManager.createQuery("Select s From Student s Where firstName = 'Hasan'",Student.class);
		List<Student> retrievedStudents = theQuery.getResultList();
		return retrievedStudents;
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> theQuery = entityManager.createQuery("Select s From Student s Where s.lastName=: data",Student.class);
		theQuery.setParameter("data", lastName);
		List<Student> retrievedStudents = theQuery.getResultList();
		return retrievedStudents;
	}

	
}
