package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;

protected Device(){
}

public Device(String name, String status){
    this.name = name;
    this.status = status;
}

public Long getId(){return id;}
public String getName(){return name;}
public String getStatus(){return status;}

}