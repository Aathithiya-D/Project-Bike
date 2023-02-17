package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.bike;
import com.example.demo.repository.jpaInterface;

@Service
public class serviceProviderPS {
	
	@Autowired
	jpaInterface j1;
	
	public Iterable<bike> getDetailsBySorting(String field)
	{
		return j1.findAll(Sort.by(field));
	}
	
	public Iterable<bike> getDetailsBySortingGrp(String field1, String field2)
	{
		Sort Field1 = Sort.by(field1);
		Sort Field2 = Sort.by(field2);
		
		return j1.findAll(Field1.and(Field2));
	}
	
	public Page<bike> getDetailsByPaging(int pageNo, int pageSize)
	{
		Pageable paging = PageRequest.of(pageNo, pageSize);
		return j1.findAll(paging);
	}
	
	public Page<bike> getDetailsByPagingandSorting1(int pageNo, int pageSize, int choice, String field)
	{
		Pageable paging;
		
		if(choice == 1)
		paging = PageRequest.of(pageNo, pageSize, Direction.ASC, field);
		
		else
		paging = PageRequest.of(pageNo, pageSize, Direction.DESC, field);
	
		return j1.findAll(paging);
	}
	
	public Page<bike> getDetailsByPagingandSorting2(int pageNo, int pageSize, String choice, String field)
	{
		Pageable paging;
		
		if(choice.equalsIgnoreCase("1"))
		paging = PageRequest.of(pageNo, pageSize, Direction.ASC, field);
		
		else
		paging = PageRequest.of(pageNo, pageSize, Direction.DESC, field);
	
		return j1.findAll(paging);
	}

}
