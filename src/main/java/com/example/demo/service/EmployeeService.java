package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public List<Employee> findAll() {
		return repo.findAll();
	}

	public Employee findOne(Integer id) {
		// ถ้าไม่เจอจะไม่ error ทุกอย่างเป็น null
		//return repo.findById(id).orElse(new Employee());
//		ถ้าไม่เจอจะขึ้น error
		return repo.findById(id).get();
	}

	public Employee addEmployee(Employee emp) {
		Employee ret = null;
		try {
			findOne(emp.getId());
		} catch (NoSuchElementException e) {
			System.out.println(emp.getId());
			ret = repo.save(emp);
		}
		return ret;
//		return repo.save(emp);
	}

	public Employee updateEmployee(Integer id, Employee emp) {
		Employee ret = null;
		try {
			findOne(emp.getId());
			ret = repo.save(emp);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return ret;

//		or
//		return repo.findById(id).map(x -> {
//			x.copy(emp);
//			return repo.save(x);
//		}).orElseGet(() -> {
//			throw new RuntimeException("Notfound Employee");
//		});
	}

}
