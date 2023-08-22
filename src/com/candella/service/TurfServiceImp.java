package com.candella.service;

import java.util.List;

import com.candella.dao.TurfDAOImp;
import com.candella.entity.Turf;

public class TurfServiceImp implements TurfService {
	TurfDAOImp turfDAOImp=new TurfDAOImp();

	@Override
	public void addTurf(Turf turf) {
		turfDAOImp.addTurf(turf);
	
		

	}

	@Override
	public void updateTurf(int turfid, String columnname) {
		turfDAOImp.updateTurf(turfid, columnname);

	}

	@Override
	public List<Turf> viewTurf() {
		
		return turfDAOImp.viewTurf();
	}

	@Override
	public Turf searchTurf(int turf_id) {
		
		return turfDAOImp.searchTurf(turf_id);
	}

	@Override
	public List<Turf> viewTurfBasedOnLocation(String location) {
		
		return turfDAOImp.viewTurfBasedOnLocation(location);
	}

}
