package hibernate_test2;

import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Amir", "Kenesbay", "IT", 500);
//            Detail detail = new Detail("Nur-Sultan", "123456789", "amirkenesbay@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Alex", "Mercer", "Sales", 700);
            Detail detail = new Detail("Almaty", "987654321", "alexmercer@gmail.com");
            employee.setEmpDetail(detail);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
