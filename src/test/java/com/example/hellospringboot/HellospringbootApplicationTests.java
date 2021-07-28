package com.example.hellospringboot;


import com.alibaba.druid.pool.DruidDataSource;
import com.example.dao.LoginMapper;
import com.example.pojo.Login;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.DataInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@SpringBootTest
class HellospringbootApplicationTests {
    @Test
    void contextLoads() throws Exception {
        String exe = "python";
        String command = "D:\\yiqingdataPY\\main.py";
        String[] cmdArr = new String[] {exe,command};
        Process process = null;
        process = Runtime.getRuntime().exec(cmdArr);
        assert process != null;
        InputStream is = process.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readLine();
        process.waitFor();
        System.out.println(str);

    }
    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads_Druid() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        connection.close();
    }

    @Autowired
    private LoginMapper loginMapper;
    @Test
    public void getUser(){
        List<Login> list = loginMapper.queryUser();
        System.out.println(list.get(0)+","+list.get(1));
    }
    }
