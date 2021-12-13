package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Alex", "Smith", "IT" , 600);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
