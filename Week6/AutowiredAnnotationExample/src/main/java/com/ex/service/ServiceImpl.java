package com.ex.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ex.dao.Dao;

public class ServiceImpl implements Service {
	
	@Autowired
	private Dao dog;

	@Override
	public void auth() {
		System.out.println("ServiceImpl");
		dog.getEmployeeById();
	}

}
