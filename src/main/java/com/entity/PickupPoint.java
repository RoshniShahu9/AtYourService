package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PICKUP_POINT")
public class PickupPoint {
   @Id
   @Column(name = "PICKUP_ID")
   private Long id;

   @Column(name = "NAME", length = 50)
   private String name;

   public PickupPoint() {
   }

   public PickupPoint(long id, String name) {
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