package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/")
	public List<Employee> findAll() {

		System.out.println("Find All");
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Employee findOne(@PathVariable Integer id) {
		System.out.println(id.intValue());

		Employee e = service.findOne(id);
		System.out.println(e.getFirstName());
//		System.out.println(e.getDepartment().getManager().getFirstName());

		return service.findOne(id);
	}

	@PostMapping("/")
	public Employee addEmployee(@RequestBody Employee emp) {
		System.out.println(emp);
		return service.addEmployee(emp);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee emp) {
		return service.updateEmployee(id, emp);
	}

}
