package com.candella.service;

import java.util.List;

import com.candella.dao.PaymentDAOImp;
import com.candella.entity.Payment;

public class PaymentServiceImp implements PaymentService {
	PaymentDAOImp paymentDAO=new PaymentDAOImp();

	@Override
	public void addPayment(Payment payment) {
		paymentDAO.addPayment(payment);
		

	}

	@Override
	public List<Payment> viewPayment() {
		
		return paymentDAO.viewPayment();
	}

}
