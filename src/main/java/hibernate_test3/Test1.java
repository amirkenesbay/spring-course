package hibernate_test3;

import hibernate_test3.entity.Passport;
import hibernate_test3.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.List;

public class Test1 {
    static Session session = null;
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory()) {

//            addPersonAndPassportDetails(factory);
//            getPersonDetails(factory);
//            getPassportDetails(factory);
//            deletePersonDetails(factory);
//            searchPersonDetails(factory);
//            updatePersonDetails(factory);
            deleteQueryForPersonDetails(factory);
        } finally {
            session.close();
        }
    }

    private static void addPersonAndPassportDetails(SessionFactory factory){
        session = factory.getCurrentSession();
        Person person = new Person("Konor", "McGregor", 32);
        Passport passport = new Passport(2018, 2028);
        person.setPassportDetail(passport);
        passport.setPerson(person);
        session.beginTransaction();
        session.save(passport);
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }

    private static void getPersonDetails(SessionFactory factory){
        session = factory.getCurrentSession();
        session.beginTransaction();
        Person person = session.get(Person.class, 1);
        System.out.println(person.getPassportDetail());
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }

    private static void getPassportDetails(SessionFactory factory){
        session = factory.getCurrentSession();
        session.beginTransaction();
        Passport passport = session.get(Passport.class, 1);
        System.out.println(passport.getPerson());
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }

    private static void deletePersonDetails(SessionFactory factory){
        session = factory.getCurrentSession();
        session.beginTransaction();
        Person person = session.get(Person.class, 2);
        session.delete(person);
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }

    private static void deletePassportDetails(SessionFactory factory){
        session = factory.getCurrentSession();
        session.beginTransaction();
        Passport passport = session.get(Passport.class, 2);
        session.delete(passport);
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }

    private static void searchPersonDetails(SessionFactory factory){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Person> personList = session.createQuery("from Person " + "where age > 22").getResultList();
        for (Person person : personList) {
            System.out.println(person);
        }
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }

    private static void updatePersonDetails(SessionFactory factory){
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("update Person set age = 20 " + "where firstName = 'Amir'").executeUpdate();
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }

    private static void deleteQueryForPersonDetails(SessionFactory factory){
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete Person " + "where firstName = 'Adam'").executeUpdate();
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }
}
