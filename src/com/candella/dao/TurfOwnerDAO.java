package com.candella.dao;

import java.util.List;

import com.candella.entity.TurfOwner;



public interface TurfOwnerDAO {
	public void addTurfOwner(TurfOwner turfOwner);

	public void updateTurfOwner(int ownerid, String columnname);

	public List<TurfOwner> viewTurfOwner();
	
	public TurfOwner searchTurfOwner(int owner_id);


}
