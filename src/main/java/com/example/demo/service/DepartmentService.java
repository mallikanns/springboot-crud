package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repo;

	public List<Department> findAll() {
		return repo.findAll();
	}

	public Department findOne(Integer id) {
		return repo.findById(id).get();
	}

	public Department addDepartment(Department dept) {
		Department ret = null;
		try {
			findOne(dept.getId());
		} catch (NoSuchElementException e) {
			System.out.println(dept.getId());
			ret = repo.save(dept);
		}
		return ret;
//		return repo.save(dept);
	}

	public Department updateDepartment(String id, Department dept) {
		Department ret = null;
		try {
			findOne(dept.getId());
			ret = repo.save(dept);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return ret;
//		return repo.save(dept);
	}
}
