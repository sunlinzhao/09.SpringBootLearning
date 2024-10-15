package com.slz.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/15
 */
@Configuration
public class RedisConfig {

    @Bean //JedisConnectionFactory 连接工厂装配成 Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        //key val 采用不同的序列化方式
//        // key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        // value序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        // 必须调用 afterPropertiesSet 方法，否则序列化方式不会生效
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
