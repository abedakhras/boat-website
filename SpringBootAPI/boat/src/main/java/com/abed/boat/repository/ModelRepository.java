package com.abed.boat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.abed.boat.models.Boat;
import com.abed.boat.models.Model;
import com.abed.boat.models.Shipyard;



public interface  ModelRepository extends CrudRepository<Model, Long> {
	
}
