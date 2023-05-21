package hibernate_test_one_to_many_bi;


import hibernate_test_one_to_many_bi.entity.Department;
import hibernate_test_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 { // Test to get hibernate connection and save info about user
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()// org.hibernate.cfg
                .configure("META-INF/hibernate.cfg.xml")// Session Factory читает файл
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            Department dep = new Department("Sales",300,1200);
            Employee emp1 = new Employee("Dmitrii","Skakun",300);
            Employee emp2 = new Employee("Alex","Smith",1000);
            Employee emp3 = new Employee("Elena","Sidorova",800);

            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            dep.addEmployeeToDepartment(emp3);

            session.beginTransaction();
            session.save(dep);
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
