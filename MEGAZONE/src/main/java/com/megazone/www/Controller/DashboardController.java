package com.megazone.www.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megazone.www.Service.DashboardService;

@RequestMapping("/dashboard")
@Controller
public class DashboardController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final DashboardService dashboardService;
	
	public DashboardController(DashboardService dashboardService) {
		super();
		this.dashboardService = dashboardService;
	}
	
	

	@GetMapping("/count")
	public void count() {
		System.out.println(dashboardService.selectDashboard());
	}
	
}
