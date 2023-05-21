
package hibernate_test_one_to_many_uni;



import hibernate_test_one_to_many_uni.entity.Department;
import hibernate_test_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1_1 { // Test to get hibernate connection and save info about user
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
            Department department = session.get(Department.class, 2);

            session.delete(department);


            session.getTransaction().commit();
            System.out.println("DONE!");




        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
