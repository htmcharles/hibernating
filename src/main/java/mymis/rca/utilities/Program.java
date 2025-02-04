package mymis.rca.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.time.LocalDate;
import mymis.rca.models.Student;

public class Program {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student1 = new Student( "Mike", "Mugabo","mike@gmail.com",12, LocalDate.now());
        session.merge(student1);
        transaction.commit();

    }

}
