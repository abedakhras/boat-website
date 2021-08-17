package com.abed.boat.controller;

import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abed.boat.models.Boat;
import com.abed.boat.models.Model;
import com.abed.boat.models.Shipyard;
import com.abed.boat.repository.BoatRepository;
import com.abed.boat.repository.ModelRepository;
import com.abed.boat.repository.ShipyardRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BoatController {
	@Autowired
	private BoatRepository boatRepository;
	
	@Autowired
	private ShipyardRepository ShipyardRepository;

	@Autowired
	private ModelRepository modelRepository;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello worl";		
	}
	
	@GetMapping("/boats")
	public List<Boat> retrieveBoatValue() {
		return boatRepository.findAll();		
	}
	
	@PostMapping("/boats")
	public Boat create(@RequestBody Boat newBoat) {
		/*
		 * we can put all this code into service component 
		 * i write it here beacuse the time is limited 
		 * */
		Shipyard shipyard = new Shipyard(newBoat.getShipyard().getName(),newBoat.getShipyard().getName());
		Model model = new Model(newBoat.getModel().getModel(),newBoat.getModel().getYear());
		Shipyard ShipyardObject=ShipyardRepository.save(shipyard);
		Model modelObject = modelRepository.save(model);
		newBoat.setModel(modelObject);
		newBoat.setShipyard(ShipyardObject);
		return boatRepository.save(newBoat);
	}
}
