package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> employees = session.createQuery("from Employee " + "where salary > 750 and name = 'Evan'")
                    .getResultList();

            for (Employee employee : employees){
                System.out.println(employee);
            }

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
