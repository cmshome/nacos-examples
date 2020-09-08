package com.alibaba.nacos.example.spring.boot.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.example.spring.boot.util.JsonUtils;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @NacosValue(value = "${name:lxk-test}", autoRefreshed = true)
    private String name;

    @NacosValue(value = "${age:18}", autoRefreshed = true)
    private int age;


    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("useLocalCache", useLocalCache);
        map.put("name", name);
        map.put("age", age);
        return JsonUtils.parseObjToFormatJson(map);

    }
}