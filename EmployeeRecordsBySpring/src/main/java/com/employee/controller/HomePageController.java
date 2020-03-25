package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	@RequestMapping (value = {"/homepage","/edit/homepage"})
	public String home()
	{
		return "homepage";
	}
	
	@RequestMapping (value = {"","/edit"})
	public String homePage()
	{
		return "includepage_home";
	}
}