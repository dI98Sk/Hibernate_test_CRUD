package com.example.demo_hibernate.hibernate_test;

import com.example.demo_hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()// org.hibernate.cfg
                .configure("META-INF/hibernate.cfg.xml")// Session Factory читает файл
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try { // что бы убедиться что Session закроется
            Session session = sessionFactory.getCurrentSession(); // Обертка вокруг подключения к базе при помощи JDBC
            Employee emp = new Employee("Anastasiya","Bezos","CEO",1800);
            session.beginTransaction(); // открыли транзакцию
            session.save(emp); // сохранили (INSERT) в базу введеные данные
            session.getTransaction().commit();

            int myId = emp.getId();

            // Получаем  данные из базы
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId); // получили (SELECT) из базы -
                                                                   // преобразуем строку из базы в объект
            session.getTransaction().commit();

            System.out.println(employee);
            System.out.println("DONE!");
        }
        finally {
            sessionFactory.close();
        }
    }
}
