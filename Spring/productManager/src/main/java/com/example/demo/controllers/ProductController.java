package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@CrossOrigin(origins="*")
@RestController
public class ProductController {

	@Autowired
	List<Product> productList;
	
	@GetMapping("/products")
	public List<Product> getProduct(){
		
		return productList;
	}
	
	@GetMapping("products/{id}")
	public Product findProductById(@PathVariable("id") long pid) {
		
		return this.productList.stream().
				filter(eachProduct -> eachProduct.getProductId()==pid).
				findFirst().orElse(null);
	}
	
	@PostMapping(value="/products", consumes="application/json", produces="application/json")
	public Product addProduct(@RequestBody Product product) {
		this.productList.add(product);
		return product;
	}
	@PutMapping(value="/products{id}", consumes="application/json", produces="application/json")
	private Product updateProduct(@RequestBody Product product){
		
		long pid = product.getProductId();
		
		Product productToUpdate = findProductById(pid);
		
		if(productToUpdate!=null) {
			productToUpdate.setProductId(product.getProductId());
			productToUpdate.setProductName(product.getProductName());
			productToUpdate.setRating(product.getRating());
			productToUpdate.setRefImage(product.getRefImage());
			productToUpdate.setPrice(product.getPrice());
		}
		return productToUpdate;
	}
	
	@DeleteMapping(value="/products", consumes="application/json", produces="application/json")
	public Product removeProduct(@RequestBody Product product) {
		
		Product productToDelete = findProductById(product.getProductId());
		if(productToDelete!=null)
			this.productList.remove(productToDelete);
		return productToDelete;
	}
}
