package com.atguigu.cache.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	
	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;

	@Test
	public void contextLoads() {
		Employee empById = employeeMapper.getEmpById(1);
		System.out.println(empById);
	}

	@Test
	public void testRedis() {
		stringRedisTemplate.opsForValue().append("msg", "woaibeijingtianmen");
		
		redisTemplate.opsForValue().set("emp-test", employeeMapper.getEmpById(1));
		
		empRedisTemplate.opsForValue().set("emp-test-new", employeeMapper.getEmpById(1));
	}
}
