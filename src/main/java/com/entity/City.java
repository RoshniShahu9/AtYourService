package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    private Long id;

    @Column(name = "city_name",length=50)
    private String cityName;

	public City(Long id, String cityName) {
		super();
		this.id = id;
		this.cityName = cityName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

    // ...

    // Rest of the code
}