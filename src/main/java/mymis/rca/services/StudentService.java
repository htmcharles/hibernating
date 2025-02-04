package mymis.rca.services;


import mymis.rca.models.Student;
import mymis.rca.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {
    // Hibernate SessionFactory
    protected static SessionFactory sf = HibernateUtil.getSessionFactory();

    // Singleton pattern
    private static StudentService studentServices;

    public static synchronized StudentService getInstance() {
        if (studentServices == null) {
            studentServices = new StudentService();
        }
        return studentServices;
    }

    // Private constructor to prevent instantiation
    private StudentService() {
    }

    // Method to add a student
    public void addStudent(Student student) {
        // Using try-with-resources for automatic session management
        try (Session session = sf.openSession()) {
            // Begin transaction
            Transaction transaction = session.beginTransaction();

            try {
                // Persist the student entity
                session.persist(student);

                // Commit the transaction
                transaction.commit();
            } catch (Exception e) {
                // Rollback in case of an error
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();  // Log the exception
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception if session fails to open
        }
    }

    // You can add other CRUD operations here (e.g., update, delete, etc.)
}
