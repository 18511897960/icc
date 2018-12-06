package com.icc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.icc.application.UserService;

@RestController
@RequestMapping("login")
public class LoginController {
	
	@Reference(version="1.0.0",timeout=100000)
	private UserService userService;
	
	@RequestMapping("test")
	@ResponseBody
	public String login(){
		String id = userService.findById(10001L);
		return id;
	}
}
