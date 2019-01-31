package com.lidong.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Springboot01Application {

    public static void main(String[] args) {
//        SpringApplication.run(Springboot01Application.class, args);//默认web应用
        new SpringApplicationBuilder(Springboot01Application.class)
                //WebApplicationType 应用的类型
                // NONE 非web应用
                //SERVLET web应用
                //REACTIVE //响应式应用
                .web(WebApplicationType.SERVLET)//这里默认按照web应用来分析
                .run(args);
    }
    @GetMapping(value = "test")
    public String hello(String text){
        return text;
    }
}

