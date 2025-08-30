/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-30 14:23:05 UTC+08:00
 ****************************************************/
package host.fairy.utils;

import host.fairy.constant.ConfigConstant;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author Lionel Johnson
 */
public class RedisPoolUtils {
    private static final JedisPool JEDIS_POOL;
    
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 最大连接数
        config.setMaxTotal(100);
        // 最大空闲连接数
        config.setMaxIdle(100);
        // 最小空闲连接数
        config.setMinIdle(0);
        // 获取连接时的最大等待时间
        config.setMaxWait(Duration.ofMinutes(1));
        JEDIS_POOL = new JedisPool(
                config,
                ConfigConstant.REDIS_HOST,
                ConfigConstant.REDIS_PORT,
                10000,
                ConfigConstant.REDIS_PASSWORD,
                ConfigConstant.REDIS_DEFAULT_DB
        );
    }
    
    public static Jedis getJedisPool() {
        return JEDIS_POOL.getResource();
    }
}
