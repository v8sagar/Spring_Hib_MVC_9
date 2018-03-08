package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Complaint;

@Repository
public class ComplaintDaoImpl implements ComplaintDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public String logComplaint(Complaint c) {
		sf.getCurrentSession().persist(c);
		return "Complaint Logged successfully , ID " + c.getId();
	}

}
