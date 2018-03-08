package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Customer validateCustomer(String em, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerCustomer(Customer c) {
		System.out.println("in dao - reg "+sf +" "+c);
		Integer id=(Integer)sf.getCurrentSession().save(c);
		return "Customer reged successfully with ID "+id;
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
