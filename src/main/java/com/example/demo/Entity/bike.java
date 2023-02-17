package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bike_details_final")
public class bike {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	private int mfYear;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMfYear() {
		return mfYear;
	}
	public void setMfYear(int mfYear) {
		this.mfYear = mfYear;
	}
	
	public bike(int id, String name, String category, int mfYear) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.mfYear = mfYear;
	}
	
	public bike() {
		
	}
}
