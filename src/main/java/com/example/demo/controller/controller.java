package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.bike;
import com.example.demo.service.serviceProviderCRUD;
import com.example.demo.service.serviceProviderPS;

@RestController
public class controller {

	@Autowired
	serviceProviderCRUD s1;
	
	@Autowired
	serviceProviderPS s2;
	
	@GetMapping("/get")
	public List<bike> getDetails()
	{
		return s1.getDetails();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDetails(@PathVariable("id") int id)
	{
		return s1.deleteDetails(id);
	}
	
	@PostMapping("/post")
	public String postDetails(@RequestBody bike b1)
	{
		return s1.postDetails(b1);
	}
	
	@PutMapping("/put/{id}")
	public bike updateBikeDetails(@RequestBody bike b)
	{
		return s1.updateBikeDetails(b);
	}
		
	@GetMapping("/get/{field}")
	public Iterable<bike> getDetailsBySorting(@PathVariable("field") String field)
	{
		return s2.getDetailsBySorting(field);
	}
	
	@GetMapping("/get/{field1}/{field2}")
	public Iterable<bike> getDetailsBySortingGrp(@PathVariable("field1") String field1, @PathVariable("field2") String field2)
	{
		return s2.getDetailsBySortingGrp(field1, field2);
	}
	
	@RequestMapping("/getPage/{pageNo}/{pageSize}")
	public Page<bike> getDetailsByPaging(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize)
	{
		return s2.getDetailsByPaging(pageNo, pageSize);
	}
	
	@RequestMapping("/getPS1/{pageNo}/{pageSize}/{choice}/{field}")
	public Page<bike> getDetailsByPagingandSorting1(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, @PathVariable("choice") int choice, @PathVariable("field") String field)
	{
		return s2.getDetailsByPagingandSorting1(pageNo, pageSize, choice, field);
	}
	
	@RequestMapping("/getPS2")
	public Page<bike> getDetailsByPagingandSorting2(@RequestParam(defaultValue = "0", required = false) int pageNo, @RequestParam(defaultValue = "4", required = false) int pageSize, @RequestParam(defaultValue = "1", required = false) String choice, @RequestParam(defaultValue = "mfYear", required = false) String field)
	{
		return s2.getDetailsByPagingandSorting2(pageNo, pageSize, choice, field);		
	}
}
