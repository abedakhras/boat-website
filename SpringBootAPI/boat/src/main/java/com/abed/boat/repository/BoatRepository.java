package com.abed.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abed.boat.models.Boat;



public interface  BoatRepository extends JpaRepository<Boat, Long> {

}
