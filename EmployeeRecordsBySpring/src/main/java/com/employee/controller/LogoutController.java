package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping (value = {"/logout","/edit/logout"})
	public String pageLogout()
	{
		return "homepage";
	}
}