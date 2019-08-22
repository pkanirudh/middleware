package com.edu.sjsu.lab2;

import java.util.*;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.json.JSONException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

@RestController

public class PassengerController {
    @Autowired //to get the bean called PassengerRepository
    private PassengerRepository passengerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    /*
       Passenger display  JSON
    */
    @RequestMapping(path="/passenger/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public ResponseEntity getPassengerJson(@PathVariable("id")Long id) {
        try{

            if(passengerRepository.findOne(id) == null)
                return ResponseEntity.ok(noFlightFound(id));
            else{


                // Reservation r = reservationRepository.findOne(id);
                HashMap<String,List> abc = new HashMap<String,List>();
                HashMap<String,java.lang.Object> passengerlistobject = new HashMap<String,java.lang.Object>();
                // HashMap<String,ResponseEntity> reservationlist = new HashMap<String,ResponseEntity>();
                // reservationlist.put("reservations",ResponseEntity.ok(reser));
                passengerlistobject.put("passenger",passengerRepository.findOne(id));
                System.out.println("passengerlistobject"+passengerlistobject);
                // JSONObject json1 = new JSONObject(passengerlistobject);


                return ResponseEntity.ok(passengerlistobject);
                //return ResponseEntity.ok(passengerRepository.findOne(id));

            }
        }
            catch(Exception e){

                return ResponseEntity.ok(noFlightFound(id));

        }




    }

    /*
        Passenger diaplay xml
    */
    @RequestMapping(path="/passenger/{id}",
            method = RequestMethod.GET,
            params="xml=true",
            produces="application/xml"
            )
    public ResponseEntity getPassenger(@PathVariable("id")Long id
                                 ) {
        System.out.println("------------------------xml--------------------------");
        Passenger passenger = passengerRepository.findOne(id);
        try{

            if(passenger != null)
            {
                // Reservation r = reservationRepository.findOne(id);
                HashMap<String,List> abc = new HashMap<String,List>();
                HashMap<String,java.lang.Object> passengerlistobject = new HashMap<String,java.lang.Object>();
                // HashMap<String,ResponseEntity> reservationlist = new HashMap<String,ResponseEntity>();
                // reservationlist.put("reservations",ResponseEntity.ok(reser));
                passengerlistobject.put("passenger",passengerRepository.findOne(id));
                System.out.println("passengerlistobject"+passengerlistobject);
                // JSONObject json1 = new JSONObject(passengerlistobject);


                JSONObject json1 = new JSONObject(passengerlistobject);
                String xml3 = XML.toString(json1);
                System.out.println(xml3);
                return ResponseEntity.ok(xml3);
            }
            else {

                String s = "{\"BadRequest\": {\"code\": \" 404 \",\"msg\": \" Sorry, the requested passenger with id "+id+" does not exist\""+
                        "}}";
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
            }

        }catch(Exception e){

            return ResponseEntity.ok(noFlightFound(id));

        }

    }

    /*
        Create Passenger
    */
    @RequestMapping(path="/passenger", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity passenger(@RequestParam(value="firstname") String firstname,
                                             @RequestParam(value="lastname") String lastname,
                                             @RequestParam(value="age") int age,
                                             @RequestParam(value="gender") String gender,
                                             @RequestParam(value="phone") Long phone) {

        //Passenger p = passengerRepository.findOne(phone);

        Passenger p = passengerRepository.findOne(phone);
        System.out.println(p);
        //Passenger pass = new Passenger(firstname, lastname, age, gender, phone);
        HashMap<String,List> abc = new HashMap<String,List>();
        HashMap<String,java.lang.Object> passengerlistobject = new HashMap<String,java.lang.Object>();
        try {

            p = passengerRepository.save(new Passenger(firstname, lastname, age,gender, phone));
            System.out.println("p"+ p);
                //return ResponseEntity.ok(noFlightFound1());


               // p = new Passenger(firstname, lastname, age, gender, phone);
               // passengerRepository.save(p);


            HashMap<String,java.lang.Object> passengerlistobject1 = new HashMap<String,java.lang.Object>();
            // HashMap<String,ResponseEntity> reservationlist = new HashMap<String,ResponseEntity>();
            // reservationlist.put("reservations",ResponseEntity.ok(reser));
            passengerlistobject1.put("passenger",p);
            System.out.println("passengerlistobject"+passengerlistobject1);

            return ResponseEntity.ok(passengerlistobject1);
                // JSONObject json1 = new JSONObject(passengerlistobject);


        }catch(Exception ex){

            return ResponseEntity.ok(noFlightFound1());
        }



    }


    private HashMap noFlightFound(Long id){
        HashMap<String,Map> hashMap=new HashMap<String,Map>();
        HashMap<String, String> multiValueMap=new HashMap<String, String>();
        multiValueMap.put("code","404");
        String st = "Sorry the requested passenger with id " + id + " does not exist";
        multiValueMap.put("msg",st);
        hashMap.put("Badrequest",multiValueMap);
        return hashMap;
    }

    private HashMap noFlightFound1(){
        HashMap<String,Map> hashMap=new HashMap<String,Map>();
        HashMap<String, String> multiValueMap=new HashMap<String, String>();
        multiValueMap.put("code","400");
        String st = "Sorry the passenger cannot be created";
        multiValueMap.put("msg",st);
        hashMap.put("Badrequest",multiValueMap);
        return hashMap;
    }


    private HashMap noFlightFound2(Long id){
        HashMap<String,Map> hashMap=new HashMap<String,Map>();
        HashMap<String, String> multiValueMap=new HashMap<String, String>();
        multiValueMap.put("code","200");
        String st = ("Passenger with id " + id + " deleted successfully");
        multiValueMap.put("msg",st);
        hashMap.put("Badrequest",multiValueMap);
        return hashMap;
    }
    /*
        Update a
    */
    @RequestMapping(path="/passenger/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity updatePassenger(@PathVariable("id")Long id,
                                                   @RequestParam(value="firstname") String firstname,
                                                   @RequestParam(value="lastname") String lastname,
                                                   @RequestParam(value="age") int age,
                                                   @RequestParam(value="gender") String gender,
                                                   @RequestParam(value="phone") Long phone) {

        System.out.println("in put method");
        Passenger pass = null;
        HashMap<String,List> abc = new HashMap<String,List>();
        HashMap<String,java.lang.Object> passengerlistobject = new HashMap<String,java.lang.Object>();
        try {
            pass = passengerRepository.findOne(id);
            pass.setFirstname(firstname);
            pass.setLastname(lastname);
            pass.setAge(age);
            pass.setGender(gender);
            pass.setPhone(phone);
            passengerRepository.save(pass);

            passengerlistobject.put("passenger",pass);
            System.out.println("passengerlistobject"+pass);

        }catch(Exception e){

            return ResponseEntity.ok(noFlightFound(id));

        }

        return ResponseEntity.ok(passengerlistobject);

    }

    /*
        Delete Passenger
    */
    @RequestMapping(path="/passenger/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deletePassenger(@PathVariable("id")Long id) {


        Passenger pass = passengerRepository.findOne(id);
        System.out.println(pass);
        try {
            if(pass != null) {

                //passengerRepository.d
                passengerRepository.delete(id);
                JSONObject json1 = new JSONObject(noFlightFound2(id));
                String xml3 = XML.toString(json1);
                // String s = "User successfully deleted!";
                return ResponseEntity.ok(xml3);
            }
            else{
                passengerRepository.delete(id);
                return ResponseEntity.ok("Hello");
            }

        }catch(Exception e){
            return ResponseEntity.ok(noFlightFound(id));
        }



    }




    }