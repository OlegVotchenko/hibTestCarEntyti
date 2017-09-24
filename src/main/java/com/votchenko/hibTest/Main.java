package com.votchenko.hibTest;

import com.votchenko.hibTest.Entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Car car = new Car ("Mazda", "RX7", 1981);
        Car car2 = new Car ("UAZ", "Patriot", 1990);
        Car car3 = new Car ("Toyota", "Mark2", 2220);

       try(SessionFactory sessionFactory = new Configuration ().configure ()
               .buildSessionFactory ())
       {
            Session session = sessionFactory.openSession ();
           Transaction  transaction = session.beginTransaction ();
           session.save (car);
           session.save (car2);
           session.save (car3);
           transaction.commit ();

           System.out.println ("Done saving id=" + car.getId ());
           System.out.println ("Done saving id=" + car2.getId ());
           System.out.println ("Done saving id=" + car3.getId ());
           List<Car> cars = session.createQuery("from Car", Car.class).list();

           cars.forEach (System.out::println);
       }
    }
}
