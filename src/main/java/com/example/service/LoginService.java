package com.example.service;

import com.example.pojo.Login;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {
    /**查询所有用户的账号密码*/
    List<Login> queryUser();

    /**添加新用户*/
    int addUser(Login login);
}
