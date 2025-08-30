package host.fairy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringBootRedisApplicationTests {
    
    
    private final RedisTemplate<String, Object> redisTemplate;
    
    @Autowired
    SpringBootRedisApplicationTests(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("key1", "value1");
        
        Object value = redisTemplate.opsForValue().get("key1");
        System.out.println("key1: " + value);
    }
}
