package com.edu.sjsu.lab2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import org.json.XML;
import org.json.JSONObject;
import org.springframework.ui.*;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;

import org.json.JSONException;


import javax.persistence.Id;
import java.util.Date;

import java.util.*;

@RestController
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(path = "/flight/{flightnumber}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public ResponseEntity<?> getFlightJson(@PathVariable("flightnumber") String number) {
        ModelMap m2 = new ModelMap();
        ModelMap m = new ModelMap();

        System.out.println("number " + number);
        if (flightRepository.findOne(number) == null)
        { System.out.println("No flights found");
            m.addAttribute("code",404);
            m.addAttribute("msg","Sorry, the requested flight with number " +number+ " does not exist");
            m2.addAttribute("BadRequest",m);
            return ResponseEntity.ok(m2);
        }

        else{
            Flight f = flightRepository.findOne(number);
            //ModelMap m = new ModelMap();
            m.addAttribute("flightNumber", f.getFlightnumber());
            m.addAttribute("price", f.getPrice());
            m.addAttribute("from", f.getPrice());
            m.addAttribute("to", f.getPrice());
            m.addAttribute("depatureTime", new SimpleDateFormat("yyyy-MM-dd-hh").format(f.getDepartureTime()));
            m.addAttribute("arrivalTime", new SimpleDateFormat("yyyy-MM-dd-hh").format(f.getArrivalTime()));
            m.addAttribute("seatsLeft", f.getPrice());
            m.addAttribute("description", f.getPrice());


            m2.addAttribute("flight",m);

            return ResponseEntity.ok(m2);

        }
    }

    //Xml not working commented
    @RequestMapping(path = "/flight/{flightnumber}",
            method = RequestMethod.GET,
            params = "xml=true",
            produces = {"application/xml"})
    public ResponseEntity getFlightXml(@PathVariable("flightnumber") String number,
                                       @RequestParam(value = "xml", required = false) String xml) throws JSONException {


        System.out.println("number " + number);
        ModelMap ms = new ModelMap();
        ModelMap ms2 = new ModelMap();
        if (flightRepository.findOne(number) == null)
        {
            System.out.println("No flights found");
            ms.addAttribute("code","404");
        //String s3 = "No flight with flightnumber " +number+ "not found");
            ms.addAttribute("msg","Sorry, the requested flight with number " +number+ " does not exist");
            System.out.println(ms);
        //ModelMap ms2 = new ModelMap();
            ms2.addAttribute("BadRequest",ms);
            System.out.println(ms2);
            //return ResponseEntity.ok(ms2);

            String s = "{\"BadRequest\": {\"code\": \" 404 \",\"msg\": \" Sorry, the requested flight with number "+number+" does not exist\""+
                    "}}";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
        }

            //return ResponseEntity.ok("Hello");




        else{
            Flight f = flightRepository.findOne(number);
            ModelMap m = new ModelMap();
            m.addAttribute("flightNumber", f.getFlightnumber());
            m.addAttribute("price", f.getPrice());
            m.addAttribute("from", f.getPrice());
            m.addAttribute("to", f.getPrice());
            m.addAttribute("depatureTime", new SimpleDateFormat("yyyy-MM-dd-hh").format(f.getDepartureTime()));
            m.addAttribute("arrivalTime", new SimpleDateFormat("yyyy-MM-dd-hh").format(f.getArrivalTime()));
            m.addAttribute("seatsLeft", f.getPrice());
            m.addAttribute("description", f.getPrice());

            ModelMap m2 = new ModelMap();
            m2.addAttribute("flight",m);

            JSONObject json1 = new JSONObject(m2);
            String xml1 = XML.toString(json1);


            return ResponseEntity.ok(xml1);

        }


    }

    @RequestMapping(path = "/flight/{flightnumber}", method = RequestMethod.POST,produces = {"application/xml"})
    public ResponseEntity flight(
            @PathVariable(value = "flightnumber") String flightnumber,
            @RequestParam(value = "price") int price,
            @RequestParam(value = "from") String fromairport,
            @RequestParam(value = "to") String toairport,
            @RequestParam(value = "departureTime") String departureTime,
            @RequestParam(value = "arrivalTime") String arrivalTime,
            @RequestParam(value = "seatsLeft") int seatsLeft,
            @RequestParam(value = "description") String description) {

        String result = "";
        Flight flight;

        try {


            Calendar cal_departure = Calendar.getInstance();
            cal_departure.set(Calendar.YEAR, Integer.valueOf(departureTime.substring(0, 4)));
            cal_departure.set(Calendar.MONTH, (Integer.valueOf(departureTime.substring(5, 7)) - 1));
            cal_departure.set(Calendar.DAY_OF_MONTH, Integer.valueOf(departureTime.substring(8, 10)));
            cal_departure.set(Calendar.HOUR_OF_DAY, Integer.valueOf(departureTime.substring(11, 13)));
            Date departDate = cal_departure.getTime();
            SimpleDateFormat sdf_depart = new SimpleDateFormat("yyyy-MM-dd-HH");
            String depart = sdf_depart.format(departDate);
            Date departure_date = sdf_depart.parse(depart);

            Calendar cal_arrival = Calendar.getInstance();
            cal_arrival.set(Calendar.YEAR, Integer.valueOf(arrivalTime.substring(0, 4)));
            cal_arrival.set(Calendar.MONTH, (Integer.valueOf(arrivalTime.substring(5, 7)) - 1));
            cal_arrival.set(Calendar.DAY_OF_MONTH, Integer.valueOf(arrivalTime.substring(8, 10)));
            cal_arrival.set(Calendar.HOUR_OF_DAY, Integer.valueOf(arrivalTime.substring(11, 13)));
            Date arrivalDate = cal_arrival.getTime();
            SimpleDateFormat sdf_arrive = new SimpleDateFormat("yyyy-MM-dd-HH");
            String arrive = sdf_arrive.format(arrivalDate);
            Date arrival_date = sdf_arrive.parse(arrive);


            Flight fl = new Flight(flightnumber, price, fromairport, toairport, departure_date, arrival_date, seatsLeft, description);

           /* if (fl == null) {
                return ResponseEntity.ok(noFlightFound(flightnumber));
            } else {
                flight = flightRepository.save(fl);*/

            //System.out.println(flight);
            flight = flightRepository.save(fl);
            flightRepository.save(flight);
            ObjectMapper mapper = new ObjectMapper();
            //result = mapper.writeValueAsString(flight);
            result = mapper.writeValueAsString(flight);
            //  return new ResponseEntity<>(result, HttpStatus.OK);

            JSONObject json = new JSONObject(result);
            String xml2 = XML.toString(json);
            return ResponseEntity.ok(xml2);



        } catch (Exception e) {

            return ResponseEntity.ok(noFlightFound(flightnumber));
        }
    }

    private HashMap noFlightFound(String id){
        HashMap<String,Map> hashMap=new HashMap<String,Map>();
        HashMap<String, String> multiValueMap=new HashMap<String, String>();
        multiValueMap.put("code","404");
        String st = "Sorry the requested flight with flightnumber " + id + " does not exist";
        multiValueMap.put("msg",st);
        hashMap.put("Badrequest",multiValueMap);
        return hashMap;
    }

    private HashMap noFlightFound1(String id){
        HashMap<String,Map> hashMap=new HashMap<String,Map>();
        HashMap<String, String> multiValueMap=new HashMap<String, String>();
        multiValueMap.put("code","200");
        String st = "Flight with " + id + " deleted successfully";
        multiValueMap.put("msg",st);
        hashMap.put("Badrequest",multiValueMap);
        return hashMap;
    }



    @RequestMapping(path = "/flight/{id}",
            method = RequestMethod.DELETE
           )

    public ResponseEntity deleteFlightJson(@PathVariable("id") String id) {
        Flight f = null;
        try {
            f = flightRepository.findOne(id);
            if (f != null) {

                flightRepository.delete(f);
                JSONObject json = new JSONObject(noFlightFound1(id));
                String xml2 = XML.toString(json);
                return ResponseEntity.ok(xml2);

            } else {

                JSONObject json = new JSONObject(noFlightFound(id));
                String xml2 = XML.toString(json);
                return ResponseEntity.ok(xml2);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(noFlightFound(id));

        }
    }
}