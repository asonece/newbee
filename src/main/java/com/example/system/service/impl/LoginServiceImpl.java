package com.example.system.service.impl;

import com.example.system.dao.LoginDao;
import com.example.system.model.LoginMsg;
import com.example.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginDao loginDao;

    public int getLoginNoByLogin(LoginMsg login) {
        return loginDao.getLoginNoByLogin(login);
    }

}
