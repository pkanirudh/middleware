package com.example.demo.repo;

import java.util.List;

public interface MyRepository<T> {

	public T save(T t);
	
	public List<T> findAll();
	
	public long remove(T t);
}
