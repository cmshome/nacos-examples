package com.alibaba.nacos.example.spring.cloud.controller;

import com.alibaba.nacos.example.spring.cloud.util.JsonUtils;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 通过 Spring Cloud 原生注解 @RefreshScope 实现配置自动更新：
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${nacosServer:false}")
    private boolean nacosServer;

    @Value(value = "${name:d}")
    private String name;

    @Value(value = "${from:d}")
    private String from;

    @Value(value = "${want:d}")
    private String want;

    @Value(value = "${movie:d}")
    private String movie;

    @Value(value = "${son:d}")
    private String son;

    @Value(value = "${age:0}")
    private int age;


    /**
     * 端口默认是8080，看配置里面的端口是否设置
     * 启动后，web 访问地址  http://localhost:9999/config/get
     */
    @RequestMapping("/get")
    public String get() {
        // 希望结果json有序，方便阅读。
        Map<String, Object> map = Maps.newTreeMap();
        map.put("nacosServer", nacosServer);
        map.put("name", name);
        map.put("from", from);
        map.put("want", want);
        map.put("movie", movie);
        map.put("son", son);
        map.put("age", age);
        return JsonUtils.parseObjToFormatJson(map);
    }
}