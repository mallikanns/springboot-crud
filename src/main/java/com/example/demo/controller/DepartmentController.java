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

import com.example.demo.model.Department;
//import com.example.demo.model.Employee;
import com.example.demo.service.DepartmentService;
//import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;

	@GetMapping("/")
	public List<Department> findAll() {

		System.out.println("Find All");
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Department findOne(@PathVariable Integer id) {
//		System.out.println(id.intValue());

//		Department e = service.findOne(id);
//		System.out.println(e.getFirstName());
//		System.out.println(e.getDepartment().getManager().getFirstName());

		return service.findOne(id);
	}

	@PostMapping("/")
	public Department addDepartment(@RequestBody Department dept) {
		System.out.println(dept);
		return service.addDepartment(dept);
	}

	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable String id, @RequestBody Department dept) {
		return service.updateDepartment(id, dept);
	}
	

}
