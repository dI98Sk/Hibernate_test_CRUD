package hibernate_test_one_to_many_uni;



import hibernate_test_one_to_many_uni.entity.Department;
import hibernate_test_one_to_many_uni.entity.Employee;
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
            session = sessionFactory.getCurrentSession();

            Department dep = new Department("HR",500, 1000);
            Employee employee1 = new Employee("Bogdan","Deko", 600);
            Employee employee2 = new Employee("Alexey","Surchi", 800);

            dep.addEmployeeToDepartment(employee1);
            dep.addEmployeeToDepartment(employee2);

            session.beginTransaction();
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
