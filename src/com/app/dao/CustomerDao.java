package com.app.dao;

import com.app.pojos.Customer;

public interface CustomerDao {
	Customer validateCustomer(String em,String pass);
	String registerCustomer(Customer c);
	String unsubscribeCustomer(String email);
	String updateCustomer(Customer c);

}
