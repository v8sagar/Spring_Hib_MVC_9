package com.app.service;

import java.util.List;

public interface ApplicationDataService {
	List<String> getSupportedPlatforms();
	List<String> getSupportedTechnologies();
	List<String> getSupportedBrowsers();
}
