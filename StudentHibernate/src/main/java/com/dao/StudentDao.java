package com.dao;

import java.util.List;

import org.hibernate.*;

import com.controller.HibernateUtility;
import com.model.Student;

public class StudentDao {
	
	public void registerStudent(Student theStudent) {
        Transaction transaction = null;
        try  {
        	Session session = HibernateUtility.getSession().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            
            session.save(theStudent);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	public void updateStudent(Student theStudent) {
        Transaction transaction = null;
        try {
        	Session session = HibernateUtility.getSession().openSession(); 
        	transaction = session.beginTransaction();
            session.update(theStudent);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	public void deleteStudent(String id) {

        Transaction transaction = null;
        try  {
        	
        	Session session = HibernateUtility.getSession().openSession();
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Student theStudent = session.get(Student.class, id);
            if (theStudent != null) {
                session.delete(theStudent);
                System.out.println("Student's records has been deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	/*
	 * public List < Student > AllStudents() {
	 * 
	 * Transaction transaction = null; List < Student > studentsDisplay = null; try
	 * {
	 * 
	 * Session session = HibernateUtility.getSession().openSession(); // start a
	 * transaction transaction = session.beginTransaction(); studentsDisplay =
	 * session.createQuery("from Student").getResultList(); // Should match the
	 * class name not the table name transaction.commit(); } catch (Exception e) {
	 * if (transaction != null) { transaction.rollback(); } e.printStackTrace(); }
	 * return studentsDisplay; }
	 */

	
	// DAO class
	public List<Student> getAllStudents() {

	  Session session = HibernateUtility.getSession().openSession();
	  
	  List<Student> students = session.createQuery("FROM Student").list();
	  
	  return students;

	}
}
