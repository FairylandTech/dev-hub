package host.fairy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringBootRedisApplicationTests {
    
    private final RedisTemplate<String, String> redisTemplate;
    
    SpringBootRedisApplicationTests(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("key1", "value1");
        
        String value = redisTemplate.opsForValue().get("key1");
        System.out.println("key1: " + value);
    }
    
}
