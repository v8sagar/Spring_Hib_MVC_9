package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ComplaintDao;
import com.app.pojos.Complaint;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {
	@Autowired
	private ComplaintDao dao;
	@Override
	public String logComplaint(Complaint c) {
		
		return dao.logComplaint(c);
	}

}
