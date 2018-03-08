package com.app.controllers;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	@RequestMapping("/login")
	public String showLoginForm(Customer c) {
		System.out.println("in show login form " + c);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(Model map, Customer c1, HttpSession hs, RedirectAttributes flashMap) {
		System.out.println("in process login form " + map);
		Customer validCust = service.validateCustomer(c1.getEmail(), c1.getPass());
		if (validCust == null) {
			map.addAttribute("mesg", "Invalid Login ,pls Retry...");
			return "login";
		}
		/*
		 * how to add the attrs in curnt +additional req scope Via
		 * RedirectAttributes
		 * 
		 */
		flashMap.addFlashAttribute("mesg", "Successful Login");
		// to remember clnt dtls till logut
		hs.setAttribute("cust_dtls", validCust);
		// successful login --- redirect clnt to dtls page
		return "redirect:/cust/details";
	}

	@RequestMapping("/register")
	public String showRegForm(Customer c) {
		System.out.println("in show reg form " + c);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegForm(Model map, Customer c1, RedirectAttributes flashMap) {
		System.out.println("in process reg form " + c1);
		// invoke service layer's method
		String mesg1 = service.registerCustomer(c1);
		if (mesg1.contains("Failed")) {
			map.addAttribute("mesg", mesg1);
			return "register";
		}
		// successful reg
		flashMap.addFlashAttribute("mesg", mesg1.concat("Proceed to Login"));
		return "redirect:/cust/login";
	}

	// req handling method to show un subscription form
	@RequestMapping("/unsubscribe")
	public String showUnsubscribeForm(Customer c) {
		System.out.println("in show un subscribe form " + c);

		return "unsubscribe";
	}

	// req handling method to process un subscription form
	@RequestMapping(value = "/unsubscribe", method = RequestMethod.POST)
	public String processUnsubscribeForm(Customer c, Model map, HttpSession hs) {
		System.out.println("in process un subscribe form " + c.getEmail());
		String mesg = service.unsubscribeCustomer(c.getEmail());
		if (mesg.contains("Failed")) {
			map.addAttribute("mesg", mesg);
			return "unsubscribe";
		}
		hs.setAttribute("mesg", mesg);
		// hs.setAttribute("mesg", mesg.concat("Do u want to subscribe again
		// ?"));
		// return "redirect:/cust/register";
		return "redirect:/cust/logout";

	}

	// req handling method logout customer
	@RequestMapping("/logout")
	public String logout(HttpSession hs, Model map) {
		System.out.println("in logout ");
		// store un-subscription mesg in model map
		map.addAttribute("mesg", hs.getAttribute("mesg"));
		hs.invalidate();

		return "logout";
	}

	// req handling method to forward user to details.jsp
	@RequestMapping(value = "/details")
	public String showDetails() {
		System.out.println("in show dtls");
		return "details";
	}
}
