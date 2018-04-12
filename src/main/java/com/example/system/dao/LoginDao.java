package com.example.system.dao;


import com.example.system.model.LoginMsg;

public interface LoginDao {
	
	int getLoginNoByLogin(LoginMsg login);
	
}
