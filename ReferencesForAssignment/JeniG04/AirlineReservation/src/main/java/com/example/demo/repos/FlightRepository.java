package com.example.demo.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Flight;

@Repository

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query(value="SELECT * FROM flight WHERE source=?1 AND destination=?2",nativeQuery = true)
	public List<Flight> findAll(String source,String destination);
}
//public interface FlightRepository extends CrudRepository<Flight, Long> {
//
////	@Query(value="select * from flight")
////	public List<Flight> findAll1();
//}


