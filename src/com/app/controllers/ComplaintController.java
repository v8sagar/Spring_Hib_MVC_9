package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Complaint;
import com.app.service.ApplicationDataService;
import com.app.service.ComplaintService;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {
	@Autowired
	private ComplaintService service;
	@Autowired
	private ApplicationDataService dataService;

	@RequestMapping(value = "/reg")
	public String showRegForm(Complaint c, Model map) {
		System.out.println("in show comp form " + c);
		map.addAttribute("os_list", dataService.getSupportedPlatforms());
		map.addAttribute("techno_list", dataService.getSupportedTechnologies());
		map.addAttribute("browser_list", dataService.getSupportedBrowsers());
		return "reg_complaint";
	}

}
