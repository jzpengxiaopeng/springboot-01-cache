package com.atguigu.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/emp/{id}")
	public Employee getEmp(@PathVariable("id") Integer id) {
		return employeeService.getEmp(id);
	}

	@GetMapping("/emp/lastName/{lastName}")
	public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
		return employeeService.getEmpByLastName(lastName);
	}
}
