package com.edu.sjsu.lab2;


//import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.lang.*;

@Entity //indicates that we are using JPA
@Table(name="passenger")

public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;
    private String lastname;
    private int age;
    private String gender;

    @Column(name="phone", unique=true )
    private Long phone; // Phone numbers must be unique ...


    public Passenger() { }

    public Passenger(String firstname, String lastname, int age, String gender, Long phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.phone = phone;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
