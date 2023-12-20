// Booking.java
package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pickup_id")
    private PickupPoint pickupPoint;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drop_id")
    private DropPoint dropPoint;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public Booking(String pickupId, String dropId) {
    }

    public Booking(double price) {
        this.price = price;
    }

    public Booking(double price, City city, PickupPoint pickupPoint, DropPoint dropPoint, Driver driver) {
        this.price = price;
        this.city = city;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.driver = driver;
    }

	public void Booking1(String pickupId, String dropId) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public PickupPoint getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(PickupPoint pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public DropPoint getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(DropPoint dropPoint) {
		this.dropPoint = dropPoint;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

    // Getters, setters, and other methods
}