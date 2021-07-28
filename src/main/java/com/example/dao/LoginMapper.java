package com.example.dao;

import com.example.pojo.Login;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {

    /**查询所有用户的账号密码*/
    List<Login> queryUser();

    /**添加新用户*/
    int addUser(Login login);
}
