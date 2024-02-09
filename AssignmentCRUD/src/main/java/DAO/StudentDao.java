package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Student;
import utility.HibernateUtility;

public class StudentDao {
	public void registerStudent(Student theStudent) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
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
	
	public void updateStudentr(Student theStudent) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
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
	
	public void deleteStudent(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
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
	
	//   Test in running time
	
//	public void deleteStudent(int id) {
//
//		  Transaction transaction = null;
//
//		  try (Session session = HibernateUtility._getSessionFactory_().openSession()) {
//
//		    // start a transaction
//
//		    transaction = session.beginTransaction();
//
//		    // Delete a user object
//
//		    Student theStudent = session.get(Student.class, id);
//
//		    if (theStudent == null) {
//		      System.out.println("No student found with id " + id);
//		    } else {
//		      session.delete(theStudent);
//		      System.out.println("Student's records has been deleted");
//		    }
//
//		    // commit transaction  
//		    transaction.commit();
//
//		  } catch (Exception e) {
//
//		    if (transaction != null) {
//		      transaction.rollback();
//		    }
//		    e.printStackTrace();
//
//		  }
//
//		}
	
	public Student searchStudent(int id) {

        Transaction transaction = null;
        Student theStudent = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            theStudent = session.get(Student.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return theStudent;
    }
	public List < Student > AllStudents() {

        Transaction transaction = null;
        List < Student > studentsDisplay = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            studentsDisplay = session.createQuery("from Student").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return studentsDisplay;
    }

}
