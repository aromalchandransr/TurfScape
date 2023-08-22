package com.candella.dao;

import java.util.List;

import com.candella.entity.Turf;


public interface TurfDAO {
	public void addTurf(Turf turf);

	public void updateTurf(int turfid, String columnname);

	public List<Turf> viewTurf();
	
	public Turf searchTurf(int turf_id);
	
	public List<Turf> viewTurfBasedOnLocation(String location);


}
