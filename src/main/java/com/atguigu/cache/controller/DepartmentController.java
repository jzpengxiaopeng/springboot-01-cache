package com.atguigu.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@GetMapping("/dept/{id}")
	public Department getDeptById(@PathVariable("id") Integer id) {
		return departmentService.getDeptById(id);
	}

}
