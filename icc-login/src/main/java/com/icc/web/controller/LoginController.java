package com.icc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.icc.application.UserService;
import com.icc.web.config.KafkaProviderConfig;

@RestController
@RequestMapping("login")
public class LoginController {
	
	@Reference(version="1.0.0",timeout=100000)
	private UserService userService;
	
	@Autowired
	private KafkaProviderConfig config;
	
	@RequestMapping("test")
	@ResponseBody
	public String login(){
		try {
			config.getProviderKafkaTemplate().send("test",0,"provider","provider:provideing");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String id = userService.findById(10001L);
		return id;
	}
}
