package com.candella.service;

import java.util.List;

import com.candella.dao.TimeSlotDAOImp;
import com.candella.entity.TimeSlot;

public class TimeSlotServiceImp implements TimeSlotService {
	TimeSlotDAOImp timeSlotDAOImp=new TimeSlotDAOImp();

	@Override
	public List<TimeSlot> viewTimeSlots() {
		
		return timeSlotDAOImp.viewTimeSlots();
	}

}
