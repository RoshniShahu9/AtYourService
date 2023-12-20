package com.ayo.AYO2;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.City;
import com.entity.Driver;
import com.entity.DropPoint;
import com.entity.PickupPoint;
import com.entity.Booking;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create a Hibernate configuration
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // Build the SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a new session
        org.hibernate.Session session = sessionFactory.openSession();

        // Begin a transaction
        Transaction transaction = session.beginTransaction();

        try {
            // Create a new City entity
            City city = new City((long) 1, "Nagpur");

            // Create a list of PickupPoints
            List<PickupPoint> pickupPoints = new ArrayList<>();
            pickupPoints.add(new PickupPoint((long) 101, "Burdi"));
            pickupPoints.add(new PickupPoint((long) 102, "LOKMANYA"));
            pickupPoints.add(new PickupPoint((long) 103, "CHATRPATI"));

            // Create a list of DropPoints
            List<DropPoint> dropPoints = new ArrayList<>();
            dropPoints.add(new DropPoint((long) 201, "Agresan"));
            dropPoints.add(new DropPoint((long) 202, "LOKMANYA"));
            dropPoints.add(new DropPoint((long) 203, "CHATRAPATI"));

            // Create a list of Driver entities
            List<Driver> drivers = new ArrayList<>();
            drivers.add(new Driver((long) 501,"Wagon r", "MH29BP1001"));
            drivers.add(new Driver((long) 501,"I10", "MH29BM000"));

            // Save the driver entities
            for (Driver driver : drivers) {
                session.save(driver);
            }

            // Save the entities
            session.save(city);
            for (PickupPoint pickupPoint : pickupPoints) {
                session.save(pickupPoint);
            }
            for (DropPoint dropPoint : dropPoints) {
                session.save(dropPoint);
            }

            List<Booking> bookings = new ArrayList<>();
            for (int i = 0; i < pickupPoints.size(); i++) {
                for (int j = 0; j < dropPoints.size(); j++) {
                    // Create a new Driver for each booking
                    Driver driver = new Driver("Vehicle " + (i * dropPoints.size() + j + 1), "MH29" + (i * dropPoints.size() + j + 1));

                    // Save the driver entity
                    session.save(driver);

                    // Create a new Booking with the current driver
                    Booking booking = new Booking(100.0, city, pickupPoints.get(i), dropPoints.get(j), driver);

                    // Add the booking to the list
                    bookings.add(booking);
                }
            }

            // Create specific Booking entities and add them to the list
            Booking specificBooking = new Booking(50.0, city, pickupPoints.get(2), dropPoints.get(1), drivers.get(1));
            bookings.add(specificBooking);

            Booking specificBooking1 = new Booking(30.0, city, pickupPoints.get(0), dropPoints.get(1), drivers.get(1));
            bookings.add(specificBooking1);

            Booking specificBooking2 = new Booking(30.0, city, pickupPoints.get(2), dropPoints.get(1), drivers.get(1));
            bookings.add(specificBooking2);

            Booking specificBooking3 = new Booking(30.0, city, pickupPoints.get(1), dropPoints.get(2), drivers.get(0));
            bookings.add(specificBooking3);
            // Save the booking entities
            for (Booking booking : bookings) {
                session.save(booking);
            }

            // Commit the transaction
            transaction.commit();

            System.out.println("Entities created successfully!");
        } catch (Exception e) {
            // Rollback the transaction if an error occurs
            transaction.rollback();

            System.out.println("Error creating entities: " + e.getMessage());
        } finally {
            // Close the session and the SessionFactory
            session.close();
            sessionFactory.close();
        }
    }
}
