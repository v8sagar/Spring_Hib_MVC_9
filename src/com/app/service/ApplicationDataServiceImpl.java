package com.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ApplicationDataServiceImpl implements ApplicationDataService {

	@Override
	public List<String> getSupportedPlatforms() {

		return Arrays.asList("Win32", "Win64", "Linux", "Mac");
	}

	@Override
	public List<String> getSupportedTechnologies() {
		// TODO Auto-generated method stub
		return Arrays.asList("spring", "hibernate", "jsf", "struts2", ".net");
	}

	@Override
	public List<String> getSupportedBrowsers() {
		// TODO Auto-generated method stub
		return Arrays.asList("firefox","chrome","safari","opera");
	}

}
