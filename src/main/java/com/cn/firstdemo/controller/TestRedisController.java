package com.cn.firstdemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cn.firstdemo.common.redis.redisConfig1.RedisUtil;
import com.cn.firstdemo.common.utils.JdkSerializeUtil;
import com.cn.firstdemo.model.TUser;

import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/redis")
public class TestRedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/setString")
    public void setRedis() {
        Jedis jedis = redisUtil.getJedis();
        jedis.set("11", "11");
        jedis.set("ss", "333", "NX", "PX", 1000);

        TUser user = new TUser();
        user.setName("dds");
        user.setPassword("tt");
        jedis.set("nn".getBytes(), JdkSerializeUtil.serialize(user));

        TUser userb = new TUser();
        userb.setName("dds");
        userb.setPassword("tt");
        List<TUser> list = new ArrayList<TUser>();
        list.add(user);
        list.add(userb);
        jedis.set("mm".getBytes(), JdkSerializeUtil.serializeList(list));

        jedis.set("user", JSON.toJSONString(user));
        redisUtil.returnPool(jedis);
        System.out.println("ss");

    }

    @RequestMapping("/getString")
    public String getRedisString() {
        Jedis jedis = redisUtil.getJedis();
        String yy = jedis.get("11");
        byte[] data = jedis.get("nn".getBytes());
        Object object = JdkSerializeUtil.unserialize(data);
        if (object != null && (object instanceof TUser)) {
            System.out.println(((TUser)object).toString());
        }
        byte[] dataList = jedis.get("mm".getBytes());
        List<TUser> list = (List<TUser>)JdkSerializeUtil.unserializeList(dataList);
        /* BU bu = (BU)object;
        System.out.println(bu);*/
        redisUtil.returnPool(jedis);
        return yy;
    }

    @RequestMapping("/setList")
    public void setRedisList() {
        Jedis jedis = redisUtil.getJedis();
        jedis.rpush("list", "333");
        jedis.rpush("list", "444");
        String[] hh = new String[2];
        hh[1] = "1";
        hh[0] = "2";
        jedis.lpush("list", hh);
        redisUtil.returnPool(jedis);
        // list 保存json 数据格式
        /*        TUser user = new TUser();
        user.setName("ss");
        user.setPassword("ddd");
        String yy = JSON.toJSONString(user);
        System.out.println(JSON.toJSONString(user));
        jedis.rpush("list", yy);*/
        /*jedis.rpushx("vvv", yy);
        redisUtil.returnPool(jedis);*/

        System.out.println("ss");
    }

    @RequestMapping("/getList")
    public List<String> getRedisList() {
        Jedis jedis = redisUtil.getJedis();
        List<String> list = (List<String>)jedis.lrange("list", 0, 10);
        for (int i = 0; i < list.size(); i++) {
            String yy = list.get(i);
            TUser uTUser = JSON.toJavaObject(JSON.parseObject(yy), TUser.class);
            System.out.println(uTUser);
        }
        redisUtil.returnPool(jedis);
        return list;
    }

    @RequestMapping("/setMap")
    public void setRedisMap() {
        Jedis jedis = redisUtil.getJedis();
        Map<String, String> map = new HashMap<String, String>();
        map.put("yys", "ddd");
        map.put("er", "dsd");
        map.put("rrs", "ddd");
        jedis.hmset("map", map);

        // 保存对象
        /*Map<String, List<TUser>> map2=new HashMap<String, List<TUser>>();
        TUser user=new TUser();
        user.setName("dd");
        user.setPassword("ddd");
        TUser user2=new TUser();
        user2.setName("ttt");
        user2.setPassword("ee");
        List<TUser> list=new ArrayList<TUser>();
        list.add(user);
        list.add(user2);
        map2.put("ttt", list);*/
        redisUtil.returnPool(jedis);

        System.out.println("ss");
    }

    @RequestMapping("/getMap")
    public Map<String, String> getRedisMap() {
        Jedis jedis = redisUtil.getJedis();
        Map<String, String> map = new HashMap<String, String>();
        map = jedis.hgetAll("map");

        List<String> list = jedis.hmget("map", "yys", "er");
        System.out.println(list.toString());
        redisUtil.returnPool(jedis);
        return map;
    }

    @RequestMapping("/setSet")
    public void setRedisSet() {
        Jedis jedis = redisUtil.getJedis();

        jedis.sadd("set", "yyy");
        jedis.sadd("set", "nnn");

        redisUtil.returnPool(jedis);

        System.out.println("ss");
    }

    @RequestMapping("/getSet")
    public Map<String, String> getRedisSet() {
        Jedis jedis = redisUtil.getJedis();
        Map<String, String> map = new HashMap<String, String>();
        Set<String> set = jedis.smembers("set");
        System.out.println(set.toString());
        redisUtil.returnPool(jedis);
        return map;
    }

    @RequestMapping("/setSortSet")
    public void setRedisSortSet() {
        Jedis jedis = redisUtil.getJedis();

        jedis.zadd("sort", 80, "rr");
        jedis.zadd("sort", 85, "r3r");
        jedis.zadd("sort", 82, "r4r");
        redisUtil.returnPool(jedis);

        System.out.println("ss");
    }

    @RequestMapping("/getSortSet")
    public Map<String, String> getRedisSortSet() {
        Jedis jedis = redisUtil.getJedis();
        Map<String, String> map = new HashMap<String, String>();
        Set<String> set = jedis.zrange("sort", 0, -1);
        System.out.println(set.toString());
        redisUtil.returnPool(jedis);
        return map;
    }

}
