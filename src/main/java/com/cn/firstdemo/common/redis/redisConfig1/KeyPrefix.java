package com.cn.firstdemo.common.redis.redisConfig1;

public interface KeyPrefix {
		
	public int expireSeconds();
	
	public String getPrefix();
	
}
