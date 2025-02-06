package mymis.rca.services;

import mymis.rca.models.Student;
import mymis.rca.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentService {
    // Hibernate SessionFactory
    protected static SessionFactory sf = HibernateUtil.getSessionFactory();
    protected static Session session;

    // Singleton pattern
    private static StudentService studentServices;

    public static synchronized StudentService getInstance() {
        if (studentServices == null) {
            studentServices = new StudentService();
        }
        return studentServices;
    }

    private StudentService() {}

    // Method to add a student
    public void addStudent(Student student) {
        session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(student);  // Persist the student entity
            transaction.commit();  // Commit transaction if everything goes fine
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback in case of error
            }
            e.printStackTrace();
        } finally {
            session.close();  // Ensure session is closed
        }
    }

    // Method to get all students
    public List<Student> getAllStudents() {
        session = sf.openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        session.close();
        return students;
    }
}
