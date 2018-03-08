package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.pojos.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;

	@Override
	public Customer validateCustomer(String em, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerCustomer(Customer c) {
		return dao.registerCustomer(c);
	}

	@Override
	public String unsubscribeCustomer(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

}
