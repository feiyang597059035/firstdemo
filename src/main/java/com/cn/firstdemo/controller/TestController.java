package com.cn.firstdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.firstdemo.model.TUser;
import com.cn.firstdemo.service.TestRedisService;

@RestController
@RequestMapping("/vv")
public class TestController {
    @Autowired
    private TestRedisService testRedisService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/ss")
    public String setRedis2() {
        redisTemplate.boundValueOps("mnn").set("rr");

        System.out.println(redisTemplate.boundValueOps("mnn").get());
        TUser user = new TUser();
        user.setName("ss");
        user.setPassword("dd");
        redisTemplate.boundValueOps("object").set(user);
        TUser ss = (TUser)redisTemplate.boundValueOps("object").get();
        redisTemplate.boundListOps("bList").rightPush("444");

        List<TUser> list = redisTemplate.boundListOps("bList").range(0, 10);
        List<TUser> users = list;

        // testRedisService.setRedis();
        return "dsd";

    }

}
