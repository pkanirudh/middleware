package com.edu.sjsu.lab2;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, String>{
    public Reservation findByFlightsAndAndPassenger(Flight f,Passenger p);


}
