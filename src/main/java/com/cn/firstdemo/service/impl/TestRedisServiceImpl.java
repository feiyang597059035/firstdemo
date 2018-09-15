package com.cn.firstdemo.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cn.firstdemo.model.TUser;
import com.cn.firstdemo.service.TestRedisService;

@Service("testRedisService")
public class TestRedisServiceImpl implements TestRedisService {

    @Override
    @Cacheable(value = "usercache", keyGenerator = "wiselyKeyGenerator")
    public TUser setRedis() {
        // TODO Auto-generated method stub
        TUser u = new TUser();
        u.setName("sss");
        u.setName("bb");
        return u;
    }

}
