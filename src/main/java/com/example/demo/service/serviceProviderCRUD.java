package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.bike;
import com.example.demo.repository.jpaInterface;

@Service
public class serviceProviderCRUD {
	
	@Autowired
	jpaInterface f1;

	
	public List<bike> getDetails()
	{
		System.out.println("Retrieved All the Details Present In The Table");
		return f1.findAll();
	}
	
	public String deleteDetails(@PathVariable("id") int id)
	{
		f1.deleteById(id);
		return "Id : "+id+" is deleted";
	}
	
	public String postDetails(@RequestBody bike b1)
	{
		f1.save(b1);
		return "Bike Details Are Successfully Saved In The DataBase";
	}

	public bike updateBikeDetails(@RequestBody bike b)
	{
		System.out.println("The Changes Made Have Been Successfully Updated");
		return f1.save(b);
	}

}
