package com.edu.sjsu.lab2;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.edu.sjsu.lab2.Flight;

@Entity
public class Reservation {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "orderNumber")
    private Long orderNumber;
    //private Passenger passenger;
    // sum of each flight’s price.;

    private int price;

    @OneToOne
    @JoinColumn(name = "passenger_in_reservation")
    private Passenger passenger;

    /*@OneToMany(mappedBy = "reservation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Flight> flights;*/

    @OneToMany
    @JoinColumn(name="flights")
    private List<Flight> flights = new ArrayList<Flight>();


    public Reservation(int price,Passenger passenger,List<Flight> flights) {

        this.price = price;
        this.passenger = passenger;
        this.flights = flights;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Reservation(Long orderNumber) {
        this.orderNumber = orderNumber;

    }

    public Reservation() {
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }



    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


}
