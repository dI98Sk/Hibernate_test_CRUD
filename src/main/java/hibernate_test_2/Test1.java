package hibernate_test_2;


import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 { // Test to get hibernate connection and save info about user
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()// org.hibernate.cfg
                .configure("META-INF/hibernate.cfg.xml")// Session Factory читает файл
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try { // что бы убедиться что Session закроется
            /*
            Session session = sessionFactory.getCurrentSession(); // Обертка вокруг подключения к базе при помощи JDBC

            Employee employee = new Employee("Dmitrii", "Skakun", "IT", 1500);
            Detail detail = new Detail("Moscow","89287777788", "skakundima@gmail.com");

            employee.setEmpDetail(detail);
            session.beginTransaction(); // открыли транзакцию
            session.save(employee);

            session.getTransaction().commit();
            System.out.println("DONE!");

            Session session = sessionFactory.getCurrentSession(); // Обертка вокруг подключения к базе при помощи JDBC

            Employee employee = new Employee("Oleg", "Smirhov", "Sales", 1000);
            Detail detail = new Detail("Sant.P","89607879854", "smirnoff@gmail.com");

            employee.setEmpDetail(detail);
            session.beginTransaction(); // открыли транзакцию
            session.save(employee);

            session.getTransaction().commit();
            System.out.println("DONE!");

            session = sessionFactory.getCurrentSession(); // Обертка вокруг подключения к базе при помощи JDBC

            session.beginTransaction(); // открыли транзакцию
            Employee employee = session.get(Employee.class, 2);
            System.out.println(employee.getEmpDetail());



            session.getTransaction().commit();
            System.out.println("DONE!");
             */

            session = sessionFactory.getCurrentSession(); // Обертка вокруг подключения к базе при помощи JDBC
            Employee employee = new Employee("Dmitrii", "Skabilev", "CEO", 2500);
            Detail detail = new Detail("Saratov","89287453788", "sima@gmail.com");

            employee.setEmpDetail(detail);
            session.beginTransaction(); // открыли транзакцию
            session.save(employee);

            session.getTransaction().commit();
            System.out.println("DONE!");


        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}

