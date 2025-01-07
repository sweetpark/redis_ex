package redis.ex;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Test
    void redisTemplateString(){
        ValueOperations<String, String> valieOperations = redisTemplate.opsForValue();


        String key = "name";
        valieOperations.set(key, "test data");
        String value = valieOperations.get(key);
        Assertions.assertEquals(value, "test data");
    }
}
