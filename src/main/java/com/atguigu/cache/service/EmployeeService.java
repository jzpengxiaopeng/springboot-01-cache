package com.atguigu.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;

@CacheConfig(cacheNames = "empCache", cacheManager = "empCacheManager")
@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Cacheable(cacheNames = "empCache")
	public Employee getEmp(Integer id) {
		System.out.println("查询第[" + id + "]号员工");
		return employeeMapper.getEmpById(id);
	}

	@Caching(cacheable = { @Cacheable(key = "#lastName") }, put = { @CachePut(key = "#result.id"), @CachePut(key = "#result.email") })
	public Employee getEmpByLastName(String lastName) {
		System.out.println("查询名字为[" + lastName + "]的员工");
		return employeeMapper.getEmpByLastName(lastName);
	}
}
