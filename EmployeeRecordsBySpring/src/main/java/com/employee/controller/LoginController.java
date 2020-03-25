package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping (value = {"/adminlogin","/edit/adminlogin"})
	public String login()
	{
		return "adminlogin";
	}
	
	@RequestMapping (value = {"/about","/edit/about"})
	public String aboutUs()
	{
		return "aboutpage";
	}
	
	@RequestMapping (value = {"/login","edit/login"})
	public String checkLogin(@RequestParam ("user") String user,@RequestParam ("pass") String pass,Model m)
	{
		if(pass.equals("123"))
		{
			String msg = "Welcome "+user;
			m.addAttribute("message",msg);
			return "adminhome";
		}
		else
		{
			String mgs = "Wrong Password!!!";
			m.addAttribute("msg",mgs);
			return "loginerror";
		}
	}
}