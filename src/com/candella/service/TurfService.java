package com.candella.service;

import java.util.List;

import com.candella.entity.Turf;


public interface TurfService {
	public void addTurf(Turf turf);

	public void updateTurf(int turfid, String columnname);

	public List<Turf> viewTurf();
	
	public Turf searchTurf(int turf_id);
	
	public List<Turf> viewTurfBasedOnLocation(String location);

}
