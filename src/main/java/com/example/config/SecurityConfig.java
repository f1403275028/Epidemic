package com.example.config;


import com.example.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * @author Zenglin.Fang
 * @ClassName SecurityConfig
 * @Description:
 * @Data: 2021/2/13 14:58
 **/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        //授权：

        //首页所有人可以访问，功能页只有对应有权限的人才能访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/Dashboard/**").hasRole("vip");
        */

        //没有权限进入登录界面  自动跳转：/login
        http.formLogin().loginPage("/noPermissions");

        // 注销登录  :/logout   删除cookie
        http.logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID");
    }

    @Autowired
    private LoginMapper loginMapper;

    //用户认证，并对用户密码进行加密 BCryptPasswordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        for (int i = 0; i < loginMapper.queryUser().size();i++){
            auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                    .withUser(loginMapper.queryUser().get(i).getUsername())
                    .password(new BCryptPasswordEncoder().encode(loginMapper.queryUser().get(i).getPassword()))
                    .roles("vip");
        }
    }
}
