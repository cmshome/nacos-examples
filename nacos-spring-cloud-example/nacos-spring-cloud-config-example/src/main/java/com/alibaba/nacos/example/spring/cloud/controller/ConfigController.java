package com.alibaba.nacos.example.spring.cloud.controller;

import com.alibaba.nacos.example.spring.cloud.util.JsonUtils;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;
    @Value(value = "${name:lxk-test}")
    private String name;

    @Value(value = "${age:18}")
    private int age;

    /**
     * http://localhost:8080/config/get
     */
    @RequestMapping("/get")
    public String get() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("useLocalCache", useLocalCache);
        map.put("name", name);
        map.put("age", age);
        return JsonUtils.parseObjToFormatJson(map);
    }
}