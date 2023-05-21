package hibernate_test_many_to_many;

import hibernate_test_many_to_many.entity.Child;
import hibernate_test_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("META-INF/hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try{
            /*session = sessionFactory.getCurrentSession();

            Section section1 = new Section("Football");
            Child child1 = new Child("Zaur",5);
            Child child2 = new Child("Alex", 6);
            Child child3 = new Child("Dan",7);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();


            session.save(section1);


            session.getTransaction().commit();
            System.out.println("DONE!");*/
            //****************************************
            /*session = sessionFactory.getCurrentSession();


            session.beginTransaction();


           Section section = session.get(Section.class, 1);
            System.out.println(section);
            System.out.println(section.getChildren());


            session.getTransaction().commit();
            System.out.println("DONE!");*/
            //*****************************************
            /*session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Child child = session.get(Child.class, 4);

            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();
            System.out.println("DONE!");*/
            //****************************************
            /*session = sessionFactory.getCurrentSession();


            session.beginTransaction();


            Section section = session.get(Section.class, 1);
            session.delete(section);


            session.getTransaction().commit();
            System.out.println("DONE!");*/
            //************************************
            /*session = sessionFactory.getCurrentSession();

            Section section1 = new Section("Dance");
            Child child1 = new Child("Olga",12);
            Child child2 = new Child("Grigoriy", 8);
            Child child3 = new Child("Pavel",9);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.persist(section1);

            session.getTransaction().commit();
            System.out.println("DONE!");*/
            //************************************

            /*session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Section section = session.get(Section.class, 7);
            session.delete(section);

            session.getTransaction().commit();
            System.out.println("DONE!");*/
            //***********************************

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Child child = session.get(Child.class,5);
            session.delete(child);

            session.getTransaction().commit();
            System.out.println("DONE!");



        }
        finally {
            session.close();
            sessionFactory.close();

        }
    }
}
