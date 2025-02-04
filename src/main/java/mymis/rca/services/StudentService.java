package mymis.rca.services;

import mymis.rca.models.Student;
import mymis.rca.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentService {

    // Method to add a new student
    public void addStudent(Student student) {
        Session session = null;
        Transaction tx = null;
        try {
            // Open a session
            session = HibernateUtil.getSessionFactory().openSession();

            // Start a transaction
            tx = session.beginTransaction();

            // Save the student object
            session.save(student);

            // Commit the transaction to save the student
            tx.commit();

            // Get the generated ID using LAST_INSERT_ID()
            Long studentId = (Long) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult();

            // Print the generated ID
            System.out.println("Generated Student ID: " + studentId);

        } catch (Exception e) {
            // Rollback transaction in case of an error
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session
            if (session != null) {
                session.close();
            }
        }
    }
}
