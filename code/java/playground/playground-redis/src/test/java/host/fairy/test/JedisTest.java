/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-30 14:01:02 UTC+08:00
 ****************************************************/
package host.fairy.test;

import host.fairy.constant.ConfigConstant;
import host.fairy.utils.RedisPoolUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lionel Johnson
 */
public class JedisTest {
    private Jedis jedis;
    private Jedis jedis2;
    
    @BeforeEach
    public void setUp() {
        jedis = new Jedis(ConfigConstant.REDIS_HOST, ConfigConstant.REDIS_PORT);
        jedis.auth(ConfigConstant.REDIS_PASSWORD);
        jedis.select(ConfigConstant.REDIS_DEFAULT_DB);
        jedis2 = RedisPoolUtils.getJedisPool();
    }
    
    @Test
    public void saveString() {
        // 存数据
        String result = jedis.set("name", "马欣源");
        System.out.println("result = " + result);
        // 取数据
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }
    
    @Test
    public void saveHash() {
        Map<String, String> userInfo = new HashMap<String, String>() {{
            put("name", "fairy");
            put("age", "18");
        }};
        // 存入数据, 返回值是新添加的域(Key)的数量
        long result = jedis.hset("user:1", userInfo);
        System.out.println("result = " + result);
        
        long gender = jedis.hset("user:1", "gender", "女");
        System.out.println("gender = " + gender);
        
        Map<String, String> cacheUserInfo = jedis2.hgetAll("user:1");
        System.out.println("cacheUserInfo = " + cacheUserInfo);
    }
    
    @AfterEach
    public void showDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
