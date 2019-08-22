package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="dealer")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dealer {

	@Id
	private long id;
	private String dealerName;
}
