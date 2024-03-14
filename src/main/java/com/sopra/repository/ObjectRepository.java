package com.sopra.repository;

import java.util.List;

import com.sopra.BookStore.Inventory;

public interface ObjectRepository<T> {
	
	public void store(List<Inventory> t);
	public T get(int id);
	public void delete(T t);
	
	public List<T> getAll();

}
