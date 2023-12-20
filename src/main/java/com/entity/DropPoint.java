package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drop_point")
public class DropPoint {
    @Id
    @Column(name = "drop_id")
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    public DropPoint() {
        // Default constructor is required for JPA
    }

    public DropPoint(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Rest of the code
}