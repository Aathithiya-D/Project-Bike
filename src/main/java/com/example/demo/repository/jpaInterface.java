package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.bike;

public interface jpaInterface extends JpaRepository<bike, Integer>
{

}
