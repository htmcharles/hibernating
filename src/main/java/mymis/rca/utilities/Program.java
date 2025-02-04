package mymis.rca.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.time.LocalDate;
import mymis.rca.models.Student;

public class Program {

    public static void main(String[] args) {
        // Get SessionFactory and open session
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create a new student
        Student student1 = new Student("Mike", "Mugabo", "mike@gmail.com", 12, LocalDate.now());

        // Persist the student to the database (don't use merge here)
        session.persist(student1);

        // Commit transaction and close session
        transaction.commit();
        session.close();
    }
}
