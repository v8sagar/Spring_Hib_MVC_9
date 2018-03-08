package com.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class CustomerUpdateController {
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/update")
	public String showUpdateForm(Model map, HttpSession hs) {
		System.out.println("in show update form");
		// retrieve validated cust details from session scope & add it to model
		// map for easy form binding.
		map.addAttribute(hs.getAttribute("cust_dtls"));
		map.addAttribute("mesg", "Update Your Details here");
		return "update";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String processUpdateForm(Customer c,Model map,HttpSession hs)
	{
		System.out.println("in process update from "+c);
		//service layer method
		map.addAttribute("mesg",service.updateCustomer(c));
		//store updated details under sess scope
		hs.setAttribute("cust_dtls",c);
		return "redirect:/cust/details";
	}

}
