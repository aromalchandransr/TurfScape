package com.candella.service;

import java.util.List;

import com.candella.dao.TurfOwnerDAOImp;
import com.candella.entity.TurfOwner;

public class TurfOwnerServiceImp implements TurfOwnerService {
	TurfOwnerDAOImp turfOwnerDAOImp=new TurfOwnerDAOImp();

	@Override
	public void addTurfOwner(TurfOwner turfOwner) {
		turfOwnerDAOImp.addTurfOwner(turfOwner);
		

	}

	@Override
	public void updateTurfOwner(int ownerid, String columnname) {
		turfOwnerDAOImp.updateTurfOwner(ownerid, columnname);

	}

	@Override
	public List<TurfOwner> viewTurfOwner() {
		
		return turfOwnerDAOImp.viewTurfOwner();
	}

	@Override
	public TurfOwner searchTurfOwner(int owner_id) {
		
		return turfOwnerDAOImp.searchTurfOwner(owner_id);
	}

}
