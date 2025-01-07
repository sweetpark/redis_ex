package redis.ex;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.ex.domain.Member;
import redis.ex.web.RedisService;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    RedisService redisService;


    @Test
    void redisTemplateString(){
        ValueOperations<String, String> valieOperations = redisTemplate.opsForValue();


        String key = "name";
        valieOperations.set(key, "test data");
        String value = valieOperations.get(key);
        Assertions.assertEquals(value, "test data");
    }



    @Test
    void redisFuncTest(){
        Member testMember = new Member("test", "01022223333");
        System.out.println("member:pending:" + testMember.getNum());
        try{
            redisService.saveRedis(testMember);
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            redisService.getFromRedis(testMember.getNum()).getName().equals("test");
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
