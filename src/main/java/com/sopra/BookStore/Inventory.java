package com.sopra.BookStore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventory {
	@Id
	int bookId;
	String name;
	String genre;
	int quantity;
	int price;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Inventory [bookId=" + bookId + ", name=" + name + ", genre=" + genre + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	public Inventory(int bookId, String name, String genre, int quantity, int price) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.genre = genre;
		this.quantity = quantity;
		this.price = price;
	}
	public Inventory() {
		
	}
	
	
	
	
	

}
