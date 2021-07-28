package com.example.config;

import com.example.util.LoginInterceptor;
import com.example.util.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/Dashboard/**")
                .excludePathPatterns("/static/**","/index","/","/index.html","/whetherlogout","/logout","/user/**");
    }

    /**让Spring检测到自定义的国际化*/
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
