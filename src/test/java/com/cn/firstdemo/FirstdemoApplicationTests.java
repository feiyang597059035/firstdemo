package com.cn.firstdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cn.firstdemo.common.redis.redisConfig1.GoodsKey;
import com.cn.firstdemo.common.redis.redisConfig1.RedisUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstdemoApplicationTests {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {}

    @Test
    public void testRedis() {

        String i = redisUtil.get(GoodsKey.getMiaoshaGoodsStock, "" + 1, String.class);
        System.out.println(i);
    }

}
