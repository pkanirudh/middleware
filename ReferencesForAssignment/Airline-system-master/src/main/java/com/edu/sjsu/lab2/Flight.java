package com.edu.sjsu.lab2;

import org.springframework.format.annotation.DateTimeFormat;
//import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.*;


@Entity
@SecondaryTable(name = "plane", pkJoinColumns = @PrimaryKeyJoinColumn(name="flightnumber"))
public class Flight {
    @Id
    private String flightnumber;
    private int price;
    private String fromairport;
    private String toairport;


    private Date departureTime;

    private Date arrivalTime;
    private int seatsLeft;
    private String description;
    //private List<Passenger> passengers;

    //For reservation
    /*@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="reservation_in_flight")
    @JsonBackReference
    private Reservation reservation;*/

    @Embedded
    private Plane plane;
    // private List<Passenger> passengers;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "capacity", column = @Column(name = "capacity", table = "plane")),
            @AttributeOverride(name = "model", column = @Column(name = "model", table = "plane")),
            @AttributeOverride(name = "manufacturer", column = @Column(name = "manufacturer", table = "plane")),
            @AttributeOverride(name = "yearOfManufacture", column = @Column(name = "yearOfManufacture", table = "plane"))
    })


    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }





    public Flight(String flightnumber, int price, String fromairport, String toairport, Date departureTime, Date arrivalTime, int seatsLeft, String description) {
        this.flightnumber=flightnumber;
        this.price = price;
        this.fromairport = fromairport;
        this.toairport = toairport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatsLeft = seatsLeft;
        this.description = description;
        this.plane = new Plane(120, "Boeing 757", "Boeing", 1998);



    }

    public Flight(){}

   // public Flight(int price,Stfromairport,toairport,departureTime,arrivalTime,seatsLeft,description);




    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFromairport() {
        return fromairport;
    }

    public void setFromairport(String fromairport) {
        this.fromairport = fromairport;
    }

    public String getToairport() {
        return toairport;
    }

    public void setToairport(String toairport) {
        this.toairport = toairport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }*/

   /* public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }*/
}
