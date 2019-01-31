package com.lidong.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建服务
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${config.name}")
    private String name;

    @Value("${config.age}")
    private Integer age;


    /**
     * 服务接口
     * @return
     */
    @RequestMapping("/hello")
    public String sayHello() {
        return "name ---> "+name+" age -->"+age;
    }


}