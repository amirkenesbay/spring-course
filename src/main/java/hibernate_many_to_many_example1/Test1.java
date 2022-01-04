package hibernate_many_to_many_example1;

import hibernate_many_to_many_example1.entity.Role;
import hibernate_many_to_many_example1.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            User user1 = new User("test1");

            Role role1 = new Role("admin");

            user1.addRoleToUser(role1);
            role1.addUserToRole(user1);

            session.beginTransaction();

            session.save(role1);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
            session.close();
        }
    }
}
