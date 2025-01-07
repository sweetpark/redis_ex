package redis.ex.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.ex.domain.Member;

import java.time.Duration;

@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;
    private ObjectMapper objectMapper;

    @Autowired
    public RedisService(RedisTemplate<String, String> redisTemplate ){
        this.redisTemplate = redisTemplate;
    }


    public void saveRedis(Member member) throws Exception{
        String memberNum = member.getNum();
        String memberJson = objectMapper.writeValueAsString(member);

        redisTemplate.opsForValue().set("member:pending:" + memberNum, memberJson, Duration.ofMinutes(30));

    }


    public Member getFromRedis(String memberNum) throws Exception{
        String memberJson = redisTemplate.opsForValue().get("member:pending:" + memberNum);
        return objectMapper.readValue(memberJson, Member.class);
    }


    public void deleteFromRedis(String memberNum){
        redisTemplate.delete("payment:pending" + memberNum);
    }



}
