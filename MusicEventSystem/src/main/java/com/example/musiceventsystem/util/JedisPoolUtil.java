package com.example.musiceventsystem.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
    private static JedisPool jedisPool;

    public static JedisPool getInstance() {
        if (jedisPool == null) {
            synchronized (JedisPoolUtil.class) {
                if (jedisPool == null) {
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    jedisPoolConfig.setMaxTotal(20);
                    jedisPoolConfig.setMaxIdle(10);
                    jedisPool = new JedisPool(jedisPoolConfig, "13.236.134.190", 6379, 4000);
                }
            }
        }
        return jedisPool;
    }
}
