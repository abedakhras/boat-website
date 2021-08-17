package com.abed.boat.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Boat {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "shipyard_id", nullable = true)
	private Shipyard shipyard;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "model_id", nullable = true)
	private Model model;
	
	private int size;
	private int type;
	
	
	public Boat() {
		super();
	}
	public Boat(Long id, String name, Shipyard shipyard,Model model, int size, int type) {
		super();
		this.id = id;
		this.name = name;
		this.shipyard = shipyard;
		this.model=model;
		this.size = size;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Shipyard getShipyard() {
		return shipyard;
	}
	public void setShipyard(Shipyard shipyard) {
		this.shipyard = shipyard;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	
	
	
	
}
