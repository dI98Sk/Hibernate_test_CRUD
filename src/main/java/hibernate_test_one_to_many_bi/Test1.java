package hibernate_test_one_to_many_bi;


import hibernate_test_one_to_many_bi.entity.Department;
import hibernate_test_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 { // Test to get hibernate connection and save info about user
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()// org.hibernate.cfg
                .configure("META-INF/hibernate.cfg.xml")// Session Factory читает файл
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = sessionFactory.getCurrentSession(); // Обертка вокруг подключения к базе при помощи JDBC
            Department dep = new Department("IT",300,1200);
            Employee emp1 = new Employee("Dmitrii","Skakun",800);
            Employee emp2 = new Employee("Alex","Smith",1000);


            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);

            session.beginTransaction(); // открыли транзакцию
            session.save(dep);




            session.getTransaction().commit();
            System.out.println("DONE!");

        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
