package com.example.demo_hibernate.hibernate_test;

import com.example.demo_hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()// org.hibernate.cfg
                .configure("META-INF/hibernate.cfg.xml")// Session Factory читает файл
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try { //исправляем зарплату
            Session session = sessionFactory.getCurrentSession(); // Обертка вокруг подключения к базе при помощи JDBC
            session.beginTransaction(); // открыли транзакцию

            //Удаление когда в программе уже есть готовый объект с пользователем
            //Employee emp = session.get(Employee.class, 5); // получили работника с id = 1
            //session.delete(emp);//удаление пользователя полученного по  ID ранее

            session.createQuery("DELETE Employee where name = 'Elena'")
                    .executeUpdate(); // удаление нескольких пользователей






            session.getTransaction().commit();
            System.out.println("DONE!");
        }
        finally {
            sessionFactory.close();
        }
    }
}
