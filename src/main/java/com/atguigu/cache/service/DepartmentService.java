package com.atguigu.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.mapper.DepartmentMapper;

@Service
public class DepartmentService {
	@Autowired
	DepartmentMapper departmentMapper;

	@Cacheable(cacheNames = "deptCache", cacheManager = "deptCacheManager")
	public Department getDeptById(Integer id) {
		System.out.println("查询第[" + id + "]号部门");
		return departmentMapper.getDeptById(id);
	}
}
