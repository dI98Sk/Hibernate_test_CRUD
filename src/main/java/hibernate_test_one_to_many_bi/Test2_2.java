package hibernate_test_one_to_many_bi;


import hibernate_test_one_to_many_bi.entity.Department;
import hibernate_test_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2_2 { // Test to get hibernate connection and save info about user
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()// org.hibernate.cfg
                .configure("META-INF/hibernate.cfg.xml")// Session Factory читает файл
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Get department:");
            Department dep = session.get(Department.class, 3);

            System.out.println("Show department:");
            System.out.println(dep);

            System.out.println("Load our users:");
            dep.getEmps().get(0);


            session.getTransaction().commit();
            System.out.println("Show employee of the department:");
            System.out.println(dep.getEmps());
            System.out.println("DONE!");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
