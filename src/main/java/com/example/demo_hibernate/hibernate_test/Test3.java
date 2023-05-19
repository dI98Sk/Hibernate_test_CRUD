package com.example.demo_hibernate.hibernate_test;

import com.example.demo_hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()// org.hibernate.cfg
                .configure("META-INF/hibernate.cfg.xml")// Session Factory читает файл
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try { // что бы убедиться что Session закроется
            Session session = sessionFactory.getCurrentSession(); // Обертка вокруг подключения к базе при помощи JDBC
            session.beginTransaction(); // открыли транзакцию


            List<Employee> ems = session.createQuery("from Employee").getResultList();

            for(Employee e:ems){
                System.out.println(e);
            }

            session.getTransaction().commit();

            System.out.println("DONE!");
        }
        finally {
            sessionFactory.close();
        }
    }
}
