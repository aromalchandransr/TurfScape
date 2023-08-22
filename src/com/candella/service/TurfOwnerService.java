package com.candella.service;

import java.util.List;

import com.candella.entity.TurfOwner;

public interface TurfOwnerService {
	public void addTurfOwner(TurfOwner turfOwner);

	public void updateTurfOwner(int ownerid, String columnname);

	public List<TurfOwner> viewTurfOwner();
	
	public TurfOwner searchTurfOwner(int owner_id);

}
