package com.example.demo.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection="car")
public class Car {

	@Id
	private ObjectId _id;
	private String brand;
	private List<String> model;
	private Owner owner;
	private Dealer dealer;
}
