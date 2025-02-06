// Program.java
package mymis.rca.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import mymis.rca.models.Student;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = "2005-02-20";
        LocalDate dob = LocalDate.parse(date, pattern);
        System.out.println(dob);

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.persist(new Student("hatuma", "Mike", "mike@example.com", 12, dob));
        session.getTransaction().commit();
        session.close();
    }
}