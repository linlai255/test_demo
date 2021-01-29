package com.cll.demo.config;

import com.cll.demo.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class MyRedisTemplate {
    @Bean
    public RedisTemplate<Object, User> MyredisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,User> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        return template;
    }
}
