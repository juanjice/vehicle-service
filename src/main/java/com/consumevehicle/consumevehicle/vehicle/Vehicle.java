package com.consumevehicle.consumevehicle.vehicle;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @author Juan Manuel Jimenez Celis
 */
public class Vehicle {
    private Person owner;
    private Person driver;
    private String id;


    public Vehicle(Person owner, Person driver,String id) {
        this.owner = owner;
        this.driver = driver;
        this.id=id;
    }
    //static method to generate a random vehicle
    public static Vehicle getRandomVehicle(){
       return new Vehicle(Person.getRandomPerson(),
               Person.getRandomPerson(),
               UUID.randomUUID().toString());
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
