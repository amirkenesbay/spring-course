package hibernate_one_to_many;

import hibernate_one_to_many.entity.Department;
import hibernate_one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        Session session = null;
        SessionFactory factory = new Configuration()
                .configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        try {
//            session = factory.getCurrentSession();
//            Department department = new Department("IT", 300, 1200);
//            Employee employee1 = new Employee("Amir", "Kenesbay", 800);
//            Employee employee2 = new Employee("Elen", "Page", 1000);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            session.beginTransaction();
//            session.save(department);
//            session.getTransaction().commit();
//            System.out.println("Done");

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//            session.getTransaction().commit();
//            System.out.println("Done");

            session = factory.getCurrentSession();

            session.beginTransaction();

            Employee employee = session.get(Employee.class, 4);

            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
        }
    }
}
