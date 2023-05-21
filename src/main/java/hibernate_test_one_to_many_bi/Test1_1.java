package hibernate_test_one_to_many_bi;


import hibernate_test_one_to_many_bi.entity.Department;
import hibernate_test_one_to_many_bi.entity.Employee;
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
            /*
            session = sessionFactory.getCurrentSession(); // Обертка вокруг подключения к базе при помощи JDBC

            session.beginTransaction(); // открыли транзакцию

            Department department = session.get(Department.class, 1);

            System.out.println(department);
            System.out.println(department.getEmps());

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 1);

            System.out.println(emp);
            System.out.println(emp.getDepartment());
             */

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 2);

            session.delete(emp);


            session.getTransaction().commit();
            System.out.println("DONE!");

        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
