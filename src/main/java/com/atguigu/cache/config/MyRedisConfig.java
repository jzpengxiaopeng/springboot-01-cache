package com.atguigu.cache.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.bean.Employee;

@Configuration
public class MyRedisConfig {

	@Bean
	public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
		RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
		template.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
		template.setDefaultSerializer(serializer);
		return template;
	}

	@Primary
	@Bean
	public RedisCacheManager empCacheManager(RedisTemplate<Object, Employee> empRedisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
		cacheManager.setUsePrefix(true);
		return cacheManager;
	}

	@Bean
	public RedisTemplate<Object, Department> deptRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
		RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
		template.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer<Department>(Department.class);
		template.setDefaultSerializer(serializer);
		return template;
	}

	@Bean
	public RedisCacheManager deptCacheManager(RedisTemplate<Object, Department> deptRedisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(deptRedisTemplate);
		cacheManager.setUsePrefix(true);
		return cacheManager;
	}

}
