package com.klu.HibernateLab;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        
    	System.out.println( "Hello World!" );
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
        Metadata md = new MetadataSources().getMetadataBuilder(ssr).build();
        
        SessionFactory sf = md.getSessionFactoryBuilder().build();
       
        Session session =sf.openSession();
        Transaction t = session.beginTransaction();

        Vehicle vehicle = new Car();
        vehicle.setName("BMW");
        vehicle.setType("model");
        vehicle.setMaxSpeed(200);
        vehicle.setColor("Black");
        session.save(vehicle);

        Car car = new Car();
        car.setName("Audi");
        car.setType("Car");
        car.setMaxSpeed(200);
        car.setColor("Red");
        car.setNumberOfDoors(4);
        session.save(car);

        Truck truck = new Truck();
        truck.setName("Maruthi");
        truck.setType("Truck");
        truck.setMaxSpeed(120);
        truck.setColor("Blue");
        truck.setLoadCapacity(500);
        session.save(truck);

        t.commit();
        session.close();

        System.out.println("Records inserted successfully!");
    }
}

