package com.candella.service;

import java.util.List;

import com.candella.dao.FareDAOImp;
import com.candella.entity.Fare;

public class FareServiceImp implements FareService {
	FareDAOImp fareDAO=new FareDAOImp();

	@Override
	public List<Fare> viewFare() {
		
		return fareDAO.viewFare();
	}

}
