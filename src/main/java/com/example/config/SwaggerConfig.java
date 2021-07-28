package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
/*开启Swagger2*/
@EnableSwagger2 /*  :/swagger-ui.html */
public class SwaggerConfig {

    //配置Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //设置要开启swagger的环境--生产环境dev
        Profiles profiles = Profiles.of("dev");
        //通过环境监听Environment，判断是否处于设置开启swagger的环境
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);

        //配置文档信息
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("曾木欠")
                .apiInfo(apiInfo())
                //是否启用swagger 如果为false 则不能访问swagger
                .enable(flag)
                .select()
                    /*
                     * 配置扫描接口 basePackage:指定要扫描的包 **
                     * withClassAnnotation:扫描类上的注解
                     * withMethodAnnotation:扫描方法上的注解
                     * */
                    .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                    /*
                     *   过滤路径 : 只扫描 /Dashboard/** 下的接口
                     */
                    /**.paths(PathSelectors.ant("/Dashboard/**"))*/
                    .build();
    }
    //配置apiinfo
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("fzl","https://blog.csdn.net/weixin_44976835","1403275028@qq.com");

        return new ApiInfo(
                "Epidemic Swagger",
                "fzl最帅",
                "1.0",
                "https://blog.csdn.net/weixin_44976835",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );

    }
}
