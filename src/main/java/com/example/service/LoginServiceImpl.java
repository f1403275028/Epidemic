package com.example.service;

import com.example.dao.LoginMapper;
import com.example.pojo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<Login> queryUser() {
       return loginMapper.queryUser();
    }

    @Override
    public int addUser(Login login) {
        return loginMapper.addUser(login);
    }
}
