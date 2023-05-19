package com.example.demo_hibernate.hibernate_test;

import com.example.demo_hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()// org.hibernate.cfg
                .configure("META-INF/hibernate.cfg.xml")// Session Factory читает файл
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try { //исправляем зарплату
            Session session = sessionFactory.getCurrentSession(); // Обертка вокруг подключения к базе при помощи JDBC
            session.beginTransaction(); // открыли транзакцию
            //Employee emp = session.get(Employee.class, 1); // получили работника с id = 1
            //emp.setSalary(1500);

            session.createQuery("UPDATE Employee set salary = 1000"+
                    "where name = 'Elena'").executeUpdate(); //использовали HQL




            session.getTransaction().commit();
            System.out.println("DONE!");
        }
        finally {
            sessionFactory.close();
        }
    }
}
