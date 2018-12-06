package com.icc.application.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.icc.application.UserService;

@Service(version="1.0.0")
public class UserServiceImpl implements UserService{

	@Override
	public String findById(Long id) {
		return id+"";
	}

}
