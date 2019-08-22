package com.edu.sjsu.lab2;

import org.springframework.http.MediaType;

import org.json.JSONObject;
import org.json.XML;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    private HashMap noEntityFound(){
        HashMap<String,Map> hashMap=new HashMap<String,Map>();
        HashMap<String, String> multiValueMap=new HashMap<String, String>();
        multiValueMap.put("code","404");
        multiValueMap.put("msg","No flight found");
        hashMap.put("Badrequest",multiValueMap);
        return hashMap;
    }

    @RequestMapping(path="/reservation",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Reservation searchReservationJson(@RequestParam(value="passengerId") Long id,
                                          @RequestParam(value="from") String fromairport,
                                          @RequestParam(value="to") String toairport,
                                          @RequestParam(value="flightnumber") String flightnumber) {

        Passenger p = passengerRepository.findOne(id);
        System.out.println(p);
        Flight f = flightRepository.findOne(flightnumber);
        System.out.println(f);
        Reservation reserv = reservationRepository.findByFlightsAndAndPassenger(f, p);
        System.out.println(reserv);
        return reserv;

    }



    @RequestMapping(path="/reservation/{orderNumber}",
            method = RequestMethod.GET,
            params="json=true",
            produces = {"application/json"})
    public ResponseEntity getReservationJson(@PathVariable("orderNumber")String orderNumber, @RequestParam(value="json") String json) {
        if(reservationRepository.findOne(orderNumber) == null)
            return ResponseEntity.ok(noEntityFound());
        else{return new ResponseEntity(reservationRepository.findOne(orderNumber), HttpStatus.OK);}
    }




    @RequestMapping(path="/reservation", method = RequestMethod.POST,produces = {"application/xml"})
    public ResponseEntity<?> reservation(
                                         @RequestParam(value="passengerId") Long id,
                                         @RequestParam(value="flightLists") List<String> flightLists
    ) {
        Reservation reser = null;
        int price = 0;
        int capacity=0;
        int seatleft=0;
        System.out.print(flightLists);

        try {

                   List<Flight> flightcontainer = new ArrayList<Flight>();
                   Passenger p  = passengerRepository.findOne(id);
                   System.out.println("flightlist"+flightLists.size());
                   System.out.println("passenger" + p);
                   for(String f :flightLists) {
                       System.out.println(f);
                       Flight flight = flightRepository.findOne(f);
                       flightcontainer.add(flight);
                       System.out.println(flight);
                       price = price + flightRepository.findOne(f).getPrice();
                       System.out.println(price);
                       System.out.println(flightcontainer.size());
                   }


                     for(int i = 0;i < flightcontainer.size();i++){
                         System.out.println(flightcontainer.get(i).getPlane().getCapacity());
                         System.out.println("Hello");


                         Date start1 = flightcontainer.get(i).getDepartureTime();
                         Date end1 = flightcontainer.get(i).getArrivalTime();

                         for(int j = i+1;j < flightcontainer.size();j++){
                             System.out.println("Hello1");

                             Date start2 = flightcontainer.get(j).getDepartureTime();
                             Date end2 = flightcontainer.get(j).getArrivalTime();
                             if(isoverlap(start1, start2, end1, end2)  == true){
                                 //System.out.println("Overlapping");
                                 String s = "{\"BadRequest\": {\"code\": \" 400 \",\"msg\": \"Reservation with id "+" cannot be created\""+
                                         "}}";
                                 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
                             }



                         }


                      }

                      System.out.println("After this check");
                //int capacity;
                //int seatleft;

                for(int i = 0;i < flightcontainer.size();i++){
                         capacity=flightRepository.findOne(flightcontainer.get(i).getFlightnumber()).getPlane().getCapacity();
                         seatleft = flightcontainer.get(i).getSeatsLeft();
                         if((capacity - seatleft) ==capacity){
                             String s = "{\"BadRequest\": {\"code\": \" 400 \",\"msg\": \"Reservation with id "+" cannot be created\""+
                                     "}}";
                             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
                         }
                }



            //passengerRepository.findOne(reservationRepository.findByFlightsAndAndPassenger())
                reser = new Reservation(price,p,flightcontainer);
                System.out.println("Hello3");
                System.out.println(price);
                System.out.println(p);
                System.out.println("flightcontainer"+flightcontainer);
                System.out.println("reser"+reser);
                //System.out.println("                                                                                 ");

                reservationRepository.save(reser);
                seatleft=seatleft-1;
                Flight flight4 =null;
                for(int i = 0;i < flightcontainer.size();i++){
                flight4=flightRepository.findOne(flightcontainer.get(i).getFlightnumber());//
                flight4.setSeatsLeft(seatleft);
                flightRepository.save(flight4);
                //  flightRepository.s

                }
            JSONObject json = new JSONObject(reser);
                String xml2 = XML.toString(json);

                HashMap<String,Map> hashMap=new HashMap<String,Map>();
                HashMap<String,Object> mymultival = new HashMap<String,Object>();
                HashMap<String, String> multiValueMap=new HashMap<String, String>();
                multiValueMap.put("code","404");
                multiValueMap.put("msg","No flight found");
                hashMap.put("Badrequest",multiValueMap);

                HashMap<String,List> abc = new HashMap<String,List>();
                HashMap<String,java.lang.Object> reservationlistobject = new HashMap<String,java.lang.Object>();
                // HashMap<String,ResponseEntity> reservationlist = new HashMap<String,ResponseEntity>();
                // reservationlist.put("reservations",ResponseEntity.ok(reser));
                reservationlistobject.put("reservations",reser);

                JSONObject json1 = new JSONObject(reservationlistobject);
                String xml3 = XML.toString(json1);
                //return ResponseEntity.ok(reservationlist);
                return ResponseEntity.ok(xml3);





        }catch(Exception e){
            System.out.println("Error in creating new reservation "+ e);
            String s = "{\"BadRequest\": {\"code\": \" 404 \",\"msg\": \" Sorry, the requested reservation with id "+" does not exist\""+
                    "}}";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);

        }



    }



    public boolean isoverlap(Date start1, Date start2, Date end1, Date end2){
             return start1.before(end2) && start2.before(end1);

    }



    @RequestMapping(path = "/reservation/{orderNumber}",
            method = RequestMethod.DELETE,
            params = "json=true",
            produces = {"application/json"})

    public void deleteReservationJson(@PathVariable("orderNumber") String orderNumber, @RequestParam(value = "json") String json) {
        Reservation r = null;
        try {
            r = reservationRepository.findOne(orderNumber);
            reservationRepository.delete(r);

        }catch(Exception e){
            e.printStackTrace();
        }
    }



    /*@RequestMapping(path="/reservation/{orderNumber}", method = RequestMethod.POST,produces = {"application/xml"})
    public ResponseEntity<?> reservation(@PathVariable("orderNumber")String orderNumber,@RequestParam(value="flightsAdded") List<String> flightsAdded,
            @RequestParam(value="flightsRemoved") List<String> flightsRemoved
    ){

        //for(int i =0 ;i < flightsAdded.size();i++){
            System.out.println("Hello");
            Long i = Long.parseLong(orderNumber);
            System.out.println(i);
            System.out.println("Hello"+reservationRepository.findOne(String.valueOf(i)).getFlights());
            //flightRepository.findOne(flightsAdded.get(i)).
        //}

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hello");
    }*/


    @RequestMapping(path="/reservation/{orderNumber}", method = RequestMethod.POST,produces = {"application/json"})
    public @ResponseBody ResponseEntity updateReservation(
                                                   @PathVariable("orderNumber") String orderNumber,
                                                   @RequestParam(value="flightsAdded") List<String> flightsAdded,
                                                   @RequestParam(value="flightsRemoved") List<String> flightsRemoved
                                                   ) {

        //Need to add the flights added in reservation  and need to remove the flights present
        System.out.println("in put method");


        try {
            Reservation reserv = null;
            List<Flight> flightstobeaddedcontainer = new ArrayList<Flight>();
            for(String f :flightsAdded) {
                System.out.println(f);
                Flight flight = flightRepository.findOne(f);
                flightstobeaddedcontainer.add(flight);
                flightRepository.save(flightstobeaddedcontainer);
                System.out.println(flight);

             List<Flight> flightstoberemoved = new ArrayList<Flight>();
             for(String fr :flightsRemoved){
                 Flight flightr = flightRepository.findOne(fr);
                 flightstoberemoved.add(flightr);
                 flightRepository.delete(flightstoberemoved);

                 //Passenger op = reservationRepository.findByFlightsAndAndPassenger();

                 //Passenger p = passengerRepository.findOne(rese);

                 //reservation r = reservationRepository.findByFlightsAndAndPassenger()

                 //reserv = reservationRepository.findByFlightsAndAndPassenger(f, p);
                 System.out.println(reserv);
             }
                return ResponseEntity.ok(reserv);
            }
        }catch(Exception e){
            System.out.println("Error in creating new reservation "+ e);
            String s = "{\"BadRequest\": {\"code\": \" 404 \",\"msg\": \" Sorry, the requested reservation with id "+" does not exist\""+
                    "}}";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
        }

       return null;

    }



    @RequestMapping(path="/reservation/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deletePassenger(@PathVariable("id")String id) {

        Reservation pass = null;
        try {
            pass = reservationRepository.findOne(id);
            reservationRepository.delete(pass);

        }catch(Exception e){
            return "Error deleting reservation"+e.toString();
        }

        return "Reservation successfully deleted!";

    }


}
